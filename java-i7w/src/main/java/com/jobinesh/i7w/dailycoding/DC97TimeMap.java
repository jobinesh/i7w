package com.jobinesh.i7w.dailycoding;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * Write a map implementation with a get function that lets you retrieve the value of a key at a particular time.
 * <p>
 * It should contain the following methods:
 * <p>
 * set(key, value, time): sets key to value for t = time.
 * get(key, time): gets the key at t = time.
 * The map should work like this. If we set a key at a particular time, it will maintain that value forever or until it gets set at a later time. In other words, when we get a key at a time, it should return the value that was set for that key set at the most recent time.
 * <p>
 * Consider the following examples:
 */
public class DC97TimeMap {
    Map<String, TreeMap<Integer, String>> keyValue = new HashMap();

    public void set(String key, String value, int time) {
        TreeMap timeMap = keyValue.get(key);
        if (timeMap == null) {
            timeMap = new TreeMap();
        }
        timeMap.put(time, value);
        keyValue.put(key, timeMap);
    }
    public String get(String key, int timestamp) {
        TreeMap<Integer, String> timeMap = keyValue.get(key);
        if (timeMap == null) {
            return "";
        }
        Integer t = timeMap.floorKey(timestamp);
        if (t == null) {
            return "";
        }
        return timeMap.get(t);
    }
    public String get1(String key, int time) {
        Map<Integer, String> timeMap = keyValue.get(key);
        if (timeMap == null) {
            return null;
        }
        String value = timeMap.get(time);
        if (value != null) {
            return value;
        } else {
            int diff = Integer.MAX_VALUE;
            int matchingTimeKey = -1;
            for (Integer timeMapKey : timeMap.keySet()) {
                if (Math.abs(timeMapKey - time) < diff) {
                    matchingTimeKey = timeMapKey;
                    diff = Math.abs(timeMapKey - time);
                }

            }
            if (matchingTimeKey != -1) {
                return timeMap.get(matchingTimeKey);
            } else {
                return null;
            }
        }
    }

    public static void main(String[] args) {
        /*
        d.set(1, 1, 0) # set key 1 to value 1 at time 0
        d.set(1, 2, 2) # set key 1 to value 2 at time 2
        d.get(1, 1) # get key 1 at time 1 should be 1
        d.get(1, 3) # get key 1 at time 3 should be 2
         */
        DC97TimeMap map = new DC97TimeMap();
        map.set("1", "1", 0);
        map.set("1", "2", 2);
        System.out.println(map.get("1", 1));
        System.out.println(map.get("1", 3));
    }
}
