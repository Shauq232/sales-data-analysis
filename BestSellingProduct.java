package bestsellingproduct;
import java.util.HashMap;
public class BestSellingProduct {
    public static void main(String[] args) {
        if (productName.length == 0 || quantitySold.length == 0) {
    System.out.println("No sales data available.");
    return;
}
        
String[] productName = {"Laptop", "Mouse", "Laptop", "Keyboard", "Mouse"};
        int[] quantitySold = {2, 5, 3, 4, 6};

        HashMap<String, Integer> totals = new HashMap<>();

        for (int i = 0; i < productName.length; i++) {
            if (totals.containsKey(productName[i])) {
                totals.put(productName[i],
                        totals.get(productName[i]) + quantitySold[i]);
            } else {
                totals.put(productName[i], quantitySold[i]);
            }
        }
        
        String bestProduct = "NONE";
        int bestQty = 0;

        for (String p : totals.keySet()) {
            if (totals.get(p) > bestQty) {
                bestQty = totals.get(p);
                bestProduct = p;
            }
        }

        System.out.println("Best Selling Product: " + bestProduct);
        System.out.println("Quantity Sold: " + bestQty);
    }
}

