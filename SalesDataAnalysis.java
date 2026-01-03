package salesdataanalysis;
import java.util.HashMap;
public class SalesDataAnalysis {
    public static void main(String[] args) {
        String[] clients = {"C1","C1","C1","C2","C2"};
        String[] products  = {"Smartwatch","printer","Smartwatch","computer","phone"};
        int[] quantities    = {8, 2, 4, 5, 1};
        HashMap<String, Integer> productTotals = new HashMap<>();
        for (int n = 0; n < products.length; n++) {
            if (productTotals.containsKey(products[n])) {
                productTotals.put(
                    products[n],
                    productTotals.get(products[n]) + quantities[n]
                );
            } else {
                productTotals.put(products[n], quantities[n]);
            }
        }
        String TheBestProduct = "NONE";
        int BestQuantity = 0;

        for (String pr : productTotals.keySet()) {
            if (productTotals.get(pr) > BestQuantity) {
                BestQuantity = productTotals.get(pr);
                TheBestProduct = pr;
            }
        }

        System.out.println("FR1 Result:");
        System.out.println("Best Selling Product: " + TheBestProduct);
        System.out.println("Total Quantity Sold: " + BestQuantity);

        HashMap<String, HashMap<String, Integer>> clientsPatterns = new HashMap<>();
        for (int n = 0; n < clients.length; n++) {
            if (!clientsPatterns.containsKey(clients[n])) {
                clientsPatterns.put(clients[n], new HashMap<>());
            }
            HashMap<String, Integer> prodCount = clientsPatterns.get(clients[n]);

            if (prodCount.containsKey(products[n])) {
                prodCount.put(products[n], prodCount.get(products[n]) + 1);
            } else {
                prodCount.put(products[n], 1);
            }
        }
        System.out.println("FR2 Result:");
        for (String cl : clientsPatterns.keySet()) {

            String recurrentProduct = "NONE";
            int maxCount = 1;

            for (String pr : clientsPatterns.get(cl).keySet()) {
                if (clientsPatterns.get(cl).get(pr) > maxCount) {
                    maxCount = clientsPatterns.get(cl).get(pr);
                    recurrentProduct = pr;
                }
            }

            if (recurrentProduct.equals("NONE")) {
                System.out.println("client " + cl + " has no recurrent purchase pattern");
            } else {
                System.out.println(
                    "client " + cl +
                    " most recurrent product is " +
                    recurrentProduct +
                    " with count " + maxCount
                );
            }
        }
    }
}
