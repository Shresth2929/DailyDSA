package Day5;

public class buySellStocks {

    public static int buySellStocks(int [] arr){
       // Abhi tak ka sabse minimum price (buy karne ke liye)
        int minPrice = Integer.MAX_VALUE;

        // Maximum profit jo abhi tak mila hai
        int maxProfit = 0;

        // Har din ke price par iterate kar rahe hain
        for (int price : arr) {

            // Agar current price abhi tak ke min se chhota hai
            // to isse buy karna better hoga
            if (price < minPrice) {
                minPrice = price;   // new minimum buy price
            } 
            else {
                // Aaj bechne par profit calculate karo
                int profit = price - minPrice;

                // Max profit update karo agar zyada mila ho
                maxProfit = Math.max(maxProfit, profit);
            }
        }
        return maxProfit;
    }


    public static void main(String[] args) {
        int[] arr={7,1,5,3,6,4};
        System.out.println(buySellStocks(arr));
        
    }

    
    
}
