public class ProfitLoss {
    public static void main(String[] args) {
        int costPrice = 129;
        int sellingPrice = 191;
        int profit = sellingPrice - costPrice;
        double profitPercent = (profit / (double) costPrice) * 100;

        System.out.println("Cost Price: " + costPrice +
                           "\nSelling Price: " + sellingPrice +
                           "\nProfit: " + profit +
                           "\nProfit Percentage: " + profitPercent + "%");
    }
}
