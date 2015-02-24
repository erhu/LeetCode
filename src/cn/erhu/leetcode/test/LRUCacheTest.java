package cn.erhu.leetcode.test;

import cn.erhu.leetcode.LRUCache;
import org.junit.Test;

/**
 * #本文件的功能说明#
 * <p/>
 * User: hujunjie
 * Date: 14-10-23
 * Time: 下午3:36
 */
public class LRUCacheTest {
    @Test
    public void test() {
        // 1,[set(2,1),get(2),set(3,2),get(2),get(3)]
        LRUCache cache = new LRUCache(1);
        cache.set(2, 1);
        System.out.println(cache.get(2));
        cache.set(3, 2);
        System.out.println(cache.get(2));
        System.out.println(cache.get(3));
    }
}
