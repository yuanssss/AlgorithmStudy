package leetcode;

/*

假设把某股票的价格按照时间先后顺序存储在数组中，请问买卖该股票一次可能获得的最大利润是多少？


输入: [7,1,5,3,6,4]
输出: 5
解释: 在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
     注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格。
 */
public class q16_maxProfit {
    public static void main(String[] args) {
        q16_maxProfit q = new q16_maxProfit();
        int[] arr = {7, 1, 5, 3, 6, 4};
        int a = q.maxProfit2(arr);
        System.out.println(a);
    }

    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        for (int i = 0; i < prices.length; i++) {
            int buy = prices[i];
            for (int j = i; j < prices.length; j++) {
                if (prices[j] > buy) {
                    maxProfit = Math.max(maxProfit, prices[j] - buy);
                }
            }
        }
        return maxProfit;
    }

    public int maxProfit2(int[]prices) {
        if(prices.length==0)
            return 0;
        int buy=prices[0];
        int maxProfit=0;
        for(int i=0;i<prices.length;i++)
        {
            buy=Math.min(prices[i],buy);
            maxProfit=Math.max(maxProfit,prices[i]-buy);
        }
        return maxProfit;
    }
}
