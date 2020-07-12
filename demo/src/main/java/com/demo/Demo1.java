package com.demo;

import java.util.HashMap;
import java.util.Map;

/**
 * @Package com.demo
 * @ClassName Demo1
 * @Description
 * @Author WJJ
 * @Date 2020/7/10 9:54
 * @Version 1.0
 */
public class Demo1 {
    public static void main(String[] args) {
        int[] nums = new int[]{2,7,11,15};
        int target = 9;
//        int[] result = twoSum(nums,target);
//        System.out.println(result[0] + " - " + result[1]);

        while (target < 11) {
            System.out.println(target++);
        }

    }

    public static int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        Map<Integer,Integer> hash = new HashMap<>();
        for(int i = 0; i < nums.length; i++) {
            if(hash.containsKey(nums[i])){
                result[0] = i;
                result[1] = hash.get(nums[i]);
                return result;
            }
            hash.put(target-nums[i],i);
        }
        return result;
    }

}
