package com.mgodk.biz.util;

/**
 * @ClassName IdWorker
 * @Description ID 生成算法 - 使用 雪花算法
 * @Author WJJ
 * @Date 2020/12/23 11:27
 * @Version 1.0
 */
public class IdWorker extends SnowflakeIdWorker {
    public IdWorker() {
        //super();
        //this.datacenterId = getDatacenterId(maxDatacenterId);
        //this.workerId = getMaxWorkerId(datacenterId, maxWorkerId);
        setDatacenterId(getDatacenterId(getMaxDatacenterId()));
        setWorkerId(getMaxWorkerId(getDatacenterId(),getMaxWorkerId()));
    }

    public IdWorker(long workerId, long datacenterId) {
        super(workerId, datacenterId);
    }

    @Override
    public synchronized long nextId() {
        return super.nextId();
    }

//    /** 测试 */
//    public static void main(String[] args) {
//        for (int i = 0; i < 1000; i++) {
//            System.out.println(new IdWorker(0,0).nextId());
//            System.out.println(new IdWorker().nextId());
//        }
//    }
}
