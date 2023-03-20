package cn.sunway.list;

import java.util.ArrayList;

/**
 *
1、modCount
 给出一个让列表内部能知道是否当前操作会引起错误结果的标志。
 如果当前线程在操作的时候，其他线程改变了当前的数据，极有可能引起错误的结果，抛出ConcurrentModificationException。

 2、扩容
 默认长度为0，添加数据时增加长度
 构造方法：无参、容量参数、集合参数
 扩容的目标：申请到满足当前需求的数组大小，并将原始的数据转移到新的数组
 长度计算策略：
 如果需要的数组长度<=当前数组长度，则不需要扩容；
 如果需要的数组长度>当前数组长度：
 grow(minCapacity)
 尝试增加原数组的1/2，如果够了，就进行转移；
 此处使用右移操作，不是严格的1/2，是除以2取整的意思
 如果增加1/2还不够，则看是否大于MAX_ARRAY_SIZE(maxInteger-8)，如果够了，则进行转移
 如果比MAX_ARRAY_SIZE还大，则把剩余的8个长度也拿出来，如果不够，那只能保证最大的maxInteger了，如果够，则将长度定为MAX_ARRAY_SIZE；
 转移策略：
 使用Arrays.copyOf，内部使用System.arrayCopy
 前者会自动创建新的数组，后者需要提供目标数组

 3、ensureCapacity
 ArrayList提供给用户使用，如果确认插入数据的大小，可以使用该方法，一次性确定数组容量，避免多次扩容带来的额外消耗。

 * @author sunw
 * @date 2023/3/20
 */
public class ListTest {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.ensureCapacity(100);
    }
}
