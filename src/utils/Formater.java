package utils;

import entities.ProductEntity;
import java.util.ArrayList;

/**
 *
 * @author quocb
 */
public class Formater {

    public static ArrayList<String[]> convertToCSVString(ArrayList<ProductEntity> arr) {
        ArrayList<String[]> results = new ArrayList<>();

        for (ProductEntity product : arr) {
            String productID = product.getProductID();
            String productName = product.getProductName();
            String unitPrice = product.getUnitPrice().toString();
            String quanity = product.getQuantity().toString();
            String status = product.getStatus().equals("available") ? "1" : "0";

            results.add(new String[]{productID, productName, unitPrice, quanity, status});
        }

        return results;
    }

    public static ProductEntity convertToEntity(String[] stringRecord) {
        String productID = stringRecord[0].replaceAll("[^\\p{Graph}\n\r\t ]", "");
        String productName = stringRecord[1];
        Double unitPrice = Double.parseDouble(stringRecord[2]);
        Integer quantity = Integer.parseInt(stringRecord[3]);
        String status = stringRecord[4].equals("1") ? "available" : "not_available";
       
        return new ProductEntity(productID, productName, unitPrice, quantity, status);
    }
}
