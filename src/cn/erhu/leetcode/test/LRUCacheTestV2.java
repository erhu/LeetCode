package cn.erhu.leetcode.test;

import cn.erhu.leetcode.LRUCacheV2;
import org.junit.Test;

/**
 * #本文件的功能说明#
 * <p/>
 * User: hujunjie
 * Date: 14-10-23
 * Time: 下午3:36
 */
public class LRUCacheTestV2 {
    @Test
    public void test() {
        // 3,[set(1,1),set(2,2),set(3,3),set(4,4),get(4),get(3),get(2),get(1),set(5,5),get(1),get(2),get(3),get(4),get(5)]
        LRUCacheV2 cache = new LRUCacheV2(3);
        cache.set(1, 1);
        cache.set(2, 2);
        cache.set(3, 3);
        cache.set(4, 4);
        System.out.print(cache.get(4) + ", ");
        System.out.print(cache.get(3) + ", ");
        System.out.print(cache.get(2) + ", ");
        System.out.print(cache.get(1) + ", ");
        cache.set(5, 5);
        System.out.print(cache.get(1) + ", ");
        System.out.print(cache.get(2) + ", ");
        System.out.print(cache.get(3) + ", ");
        System.out.print(cache.get(4) + ", ");
        System.out.print(cache.get(5) + ", ");
        // Output:	[4,3,2,-1,-1,2,3,4,5]
        // Expected:[4,3,2,-1,-1,2,3,-1,5]

/*
        // 2,[set(2,1),set(1,1),set(2,3),set(4,1),get(1),get(2)]
        // Output: [1,-1]
        // Expected: [-1,3]
        //===============
        LRUCacheV2 cache = new LRUCacheV2(2);
        cache.set(2, 1);
        cache.set(1, 1);
        cache.set(2, 3);
        cache.set(4, 1);
        System.out.println(cache.get(1));
        System.out.println(cache.get(2));
        System.out.println("----------------");
*/


        // 2,[set(2,1),set(1,1),get(2),set(4,1),get(1),get(2)]
/*
        cache = new LRUCacheV2(2);
        cache.set(2, 1);
        cache.set(1, 1);
        System.out.println(cache.get(2));
        cache.set(4, 1);
        System.out.println(cache.get(1));
        System.out.println(cache.get(2));
*/
        // ok:   1, -1, 1

    }
}
