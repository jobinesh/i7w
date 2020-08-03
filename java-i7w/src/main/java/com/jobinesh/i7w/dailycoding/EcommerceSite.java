package com.jobinesh.i7w.dailycoding;

/**
 * You run an e-commerce website and want to record the last N order ids in a log.
 * Implement a data structure to accomplish this, with the following API:
 * <p>
 * record(order_id): adds the order_id to the log
 * get_last(i): gets the ith last element from the log. i is guaranteed to be smaller than or equal to N.
 */
public class EcommerceSite {
    String[] buffer;
    int size = 0;
    int i=0;
    public EcommerceSite(int size) {
        this.size = size;
        buffer=new String[size];
    }

    public void record(String order_id) {
        buffer[i%size] =order_id;
        i++;
    }

    public String getLast(int index) {
        if(i==0){
            return null;
        }
        return buffer[(i-1-index)%size];
    }

    public static void main(String[] args) {
        EcommerceSite  site = new EcommerceSite(5);
        site.record("1000");
        site.record("1001");
        site.record("1002");
        site.record("1003");
        site.record("1004");
        site.record("1005");
        System.out.println("Element: "+site.getLast(4));
    }
}
