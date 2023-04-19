package cn.sunway.juc;

import java.util.concurrent.ConcurrentHashMap;

/**
 *
 1.7中，ConcurrentHashMap只支持最多16个线程并发，因为segment数组，是不能扩容的；
 每一个segment类似于一个HashMap的结构，每个hashMap可以内部扩容。
 每个segment就是一个ReentrantLock，segment指向tab数组，元素为HashEntry；
 Get方法也需要首先定位到segment，但是不需要加锁；

 * 1.8中，不使用Segment，使用Node，直接在tab的元素上进行加锁，细化了锁粒度
 加锁的方式也由原来的ReentrantLock变成了CAS + synchronized；
 cas：用于设置table[i] == null的情况
 synchronized：用于设置table[i] != null的情况
 Get方法和HashMap就很类似了；


 * @author sunw
 * @date 2023/3/20
 */
public class ConcurrentHashMapTest {

    public static void main(String[] args) {
        ConcurrentHashMap<String, Integer> concurrentHashMap = new ConcurrentHashMap<>();
        concurrentHashMap.putIfAbsent("key", 1);
        concurrentHashMap.replace("key", 2);
    }


}
