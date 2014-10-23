package cn.erhu.leetcode;

/**
 * Say you have an array for which the ith element is the price of a given stock on day i.
 * <p/>
 * Design an algorithm to find the maximum profit.
 * You may complete as many transactions as you like
 * (ie, buy one and sell one share of the stock multiple times).
 * However, you may not engage in multiple transactions at the same time
 * (ie, you must sell the stock before you buy again).
 * <p/>
 * User: hujunjie
 * Date: 14-10-23
 * Time: 下午3:35
 */
public class SellStockII {
    /**
     * 后一天的价格－前一天的价格，即为收益
     * 只要保证收益为正即可
     */
    public int maxProfit(int[] prices) {
        int total = 0;
        for (int i = 0; i < prices.length - 1; i++) {
            if (prices[i + 1] > prices[i]) {
                total += (prices[i + 1] - prices[i]);
            }
        }
        return total;
    }
}
