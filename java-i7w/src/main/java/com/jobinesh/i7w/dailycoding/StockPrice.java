package com.jobinesh.i7w.dailycoding;

/**
 * Given a array of numbers representing the stock prices of a company in chronological order, write a function that calculates the maximum profit you could have made from buying and selling that stock once. You must buy before you can sell it.
 * <p>
 * For example, given [9, 11, 8, 5, 7, 10], you should return 5, since you could buy the stock at 5 dollars and sell it at 10 dollars.
 */
public class StockPrice {
    public int maxProfit(int[] stocks) {
        if(stocks == null || stocks.length<=1){
            return 0;
        }
        int buyPrice = 0;
        int sellPrice = 0;
        int profit = 0;
        buyPrice = stocks[0];

        for (int i = 1; i < stocks.length; i++) {
            if (buyPrice > stocks[i] && i + 1 < stocks.length) {
                buyPrice = stocks[i];
                sellPrice = 0;
            } else if (sellPrice < stocks[i] && stocks[i] >= buyPrice) {
                sellPrice = stocks[i];
                if (profit < (sellPrice - buyPrice)) {
                    profit = sellPrice - buyPrice;
                }
            }

        }
        return profit;
    }

    public static void main(String[] args) {
        System.out.println(new StockPrice().maxProfit(new int[]{2, 11, 1, 4, 7}));
    }
}
