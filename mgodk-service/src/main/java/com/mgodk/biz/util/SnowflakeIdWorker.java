package com.mgodk.biz.util;

import java.lang.management.ManagementFactory;
import java.net.InetAddress;
import java.net.NetworkInterface;

/**
 * @ClassName SnowflakeIdWorker
 * @Description 雪花算法 - 分布式 ID 生成算法
 * 无参构造函数,getMaxWorkerId(),getDatacenterId() 为自定义方法，进行初始化
 * 注：
 * Twitter_Snowflake 结构：0 - 0000000000 0000000000 0000000000 0000000000 0 - 00000 - 00000 - 000000000000；
 *  1】1位标识，由于long基本类型在Java中是带符号的，最高位是符号位，正数是0，负数是1，所以id一般是正数，最高位是0；
 *  2】41位时间截(毫秒级)，注意，41位时间截不是存储当前时间的时间截，而是存储时间截的差值（当前时间截 - 开始时间截 得到的值），这里的的开始时间截，
 *      一般是我们的id生成器开始使用的时间，由我们程序来指定的（如下下面程序IdWorker类的startTime属性）。
 *      41位的时间截，可以使用69年，年T = (1L << 41) / (1000L * 60 * 60 * 24 * 365) = 69
 *  3】10位的数据机器位，可以部署在1024个节点，包括5位datacenterId和5位workerId；
 *  4】12位序列，毫秒内的计数，12位的计数顺序号支持每个节点每毫秒(同一机器，同一时间截)产生4096个ID序号加起来刚好64位，为一个Long型。
 * SnowFlake的优点是，整体上按照时间自增排序，并且整个分布式系统内不会产生ID碰撞(由数据中心ID和机器ID作区分)，并且效率较高，经测试，
 *  SnowFlake每秒能够产生26万ID左右。
 */
public class SnowflakeIdWorker {
    /** 开始时间截 (2020-12-21 11:31:53)，起始标记点，作为基准，一般取系统的最近时间（一旦确定不能变动） */
    private final long twepoch = 1608521513000L;
    /** 机器标识 ID 所占的位数 */
    private final long workerIdBits = 5L;
    /** 数据标识 ID 所占的位数 */
    private final long datacenterIdBits = 5L;
    /** 最大机器标识 ID，结果是31 (这个移位算法可以很快的计算出几位二进制数所能表示的最大十进制数) */
    private final long maxWorkerId = -1L ^ (-1L << workerIdBits);
    /** 最大数据标识 ID，结果是31 */
    private final long maxDatacenterId = -1L ^ (-1L << datacenterIdBits);
    /** 序列在 ID 中占的位数 */
    private final long sequenceBits = 12L;
    /** 机器标识 ID 向左移12位 */
    private final long workerIdShift = sequenceBits;
    /** 数据标识 ID 向左移17位(12+5) */
    private final long datacenterIdShift = sequenceBits + workerIdBits;
    /** 时间截向左移22位(5+5+12) */
    private final long timestampLeftShift = sequenceBits + workerIdBits + datacenterIdBits;
    /** 生成序列的掩码，这里为4095 (0b111111111111=0xfff=4095) */
    private final long sequenceMask = -1L ^ (-1L << sequenceBits);

    /** 上次生成 ID 的时间截 */
    private long lastTimestamp = -1L;
    /** 毫秒内序列(0~4095)；0 并发控制 */
    private long sequence = 0L;
    /** 工作机器标识 ID(0~31) */
    private long workerId;
    /** 数据中心标识 ID(0~31) */
    private long datacenterId;

    /** 构造函数 */
    public SnowflakeIdWorker() {
        //this.datacenterId = getDatacenterId(maxDatacenterId);
        //this.workerId = getMaxWorkerId(datacenterId, maxWorkerId);
    }
    public SnowflakeIdWorker(long workerId, long datacenterId) {
        if (workerId > maxWorkerId || workerId < 0) {
            throw new IllegalArgumentException(String.format("worker Id can't be greater than %d or less than 0", maxWorkerId));
        }
        if (datacenterId > maxDatacenterId || datacenterId < 0) {
            throw new IllegalArgumentException(String.format("datacenter Id can't be greater than %d or less than 0", maxDatacenterId));
        }
        this.workerId = workerId;
        this.datacenterId = datacenterId;
    }

    /** 获得下一个ID (该方法是线程安全的) */
    public synchronized long nextId() {
        long timestamp = timeGen();
        //如果当前时间小于上一次ID生成的时间戳，说明系统时钟回退过这个时候应当抛出异常
        if (timestamp < lastTimestamp) {
            throw new RuntimeException(
                    String.format("Clock moved backwards.  Refusing to generate id for %d milliseconds", lastTimestamp - timestamp));
        }
        //如果是同一时间生成的，则进行毫秒内序列
        if (lastTimestamp == timestamp) {
            sequence = (sequence + 1) & sequenceMask;
            //毫秒内序列溢出
            if (sequence == 0) {
                //阻塞到下一个毫秒,获得新的时间戳
                timestamp = tilNextMillis(lastTimestamp);
            }
        } else {
            //时间戳改变，毫秒内序列重置
            sequence = 0L;
        }
        //上次生成ID的时间截
        lastTimestamp = timestamp;
        //移位并通过或运算拼到一起组成64位的ID
        long nextId = ((timestamp - twepoch) << timestampLeftShift)
                | (datacenterId << datacenterIdShift)
                | (workerId << workerIdShift)
                | sequence;
        return nextId;
    }

    /** 当前时间戳：根据上次生成ID的时间截，阻塞到下一个毫秒，直到获得新的时间戳 */
    private long tilNextMillis(long lastTimestamp) {
        long timestamp = timeGen();
        while (timestamp <= lastTimestamp) {
            timestamp = timeGen();
        }
        return timestamp;
    }

    /** 当前时间(毫秒)：返回值以毫秒为单位 */
    private long timeGen() {
        return System.currentTimeMillis();
    }


    /** 获取最大机器标识 ID */
    public long getMaxWorkerId(long datacenterId, long maxWorkerId) {
        StringBuffer mpid = new StringBuffer();
        mpid.append(datacenterId);
        String name = ManagementFactory.getRuntimeMXBean().getName();
        if (!name.isEmpty()) {
            // GET jvmPid
            mpid.append(name.split("@")[0]);
        }
        // MAC + PID 的 hashcode 获取16个低位
        return (mpid.toString().hashCode() & 0xffff) % (maxWorkerId + 1);
    }
    /** 获取数据标识 ID */
    public long getDatacenterId(long maxDatacenterId) {
        long id = 0L;
        try {
            InetAddress ip = InetAddress.getLocalHost();
            NetworkInterface network = NetworkInterface.getByInetAddress(ip);
            if (network == null) {
                id = 1L;
            } else {
                byte[] mac = network.getHardwareAddress();
                id = ((0x000000FF & (long) mac[mac.length - 1])
                        | (0x0000FF00 & (((long) mac[mac.length - 2]) << 8))) >> 6;
                id = id % (maxDatacenterId + 1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return id;
    }


//    /** 测试 */
//    public static void main(String[] args) {
//        for (int i = 0; i < 1000; i++) {
//            System.out.println(new SnowflakeIdWorker(0,0).nextId());
//            //System.out.println(new SnowflakeIdWorker().nextId());
//        }
//    }
    public void setWorkerId(long workerId) {
        this.workerId = workerId;
    }
    public void setDatacenterId(long datacenterId) {
        this.datacenterId = datacenterId;
    }
    public long getDatacenterId() {
        return datacenterId;
    }
    public long getMaxWorkerId() {
        return maxWorkerId;
    }
    public long getMaxDatacenterId() {
        return maxDatacenterId;
    }
}
