package bestsellingproduct;
import java.util.HashMap;
public class BestSellingProduct {
    public static void main(String args[]) {
        
String[] NameOfProduct = {"Smartwatch", "printer", "computer", "printer", "Smartwatch"};
        int[] quantitynumberOfSold = {8, 2, 5, 1, 4};

        HashMap<String, Integer> totals = new HashMap<>();

        for (int n = 0; n < NameOfProduct.length; n++) {
            if (totals.containsKey(NameOfProduct[n])) {
                totals.put(NameOfProduct[n],
                        totals.get(NameOfProduct[n]) + quantitynumberOfSold[n]);
            } else {
                totals.put(NameOfProduct[n], quantitynumberOfSold[n]);
            }
        }
        
        String TheBestProduct = "NONE";
        int BestQuantity = 0;

        for (String pr : totals.keySet()) {
            if (totals.get(pr) > BestQuantity) {
                BestQuantity= totals.get(pr);
                TheBestProduct = pr;
            }
        }

        System.out.println("The Best Selling Product: " + TheBestProduct);
        System.out.println("Number Of Quantity Sold: " + BestQuantity);
    }
}

