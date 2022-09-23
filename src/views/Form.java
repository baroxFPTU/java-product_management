package views;

import config.ProductConfig;
import entities.ProductEntity;
import utils.Input;

/**
 *
 * @author quocb
 */
public class Form {
    public static ProductEntity getProductData() {
        String id = Input.getStringReg("Enter ID: ", "ID", ProductConfig.ID_REGEX).toUpperCase();
        String name = Input.getString("Enter name: ", "name", 3);
        Double unitPrice = Input.getDouble("Enter unit price: ", "Unit Price", ProductConfig.MIN_UNIT_PRICE, ProductConfig.MAX_UNIT_PRICE);
        Integer quantity = Input.getInt("Enter quantity: ", "Quantity", ProductConfig.MIN_QUANTITY, ProductConfig.MAX_QUANTITY);
        System.out.print("Is it available now? (Y/N) ");
        String isAvailable = Input.getString();
        ProductEntity productEntity = new ProductEntity(id, name, unitPrice, quantity, null);

        if (isAvailable.equalsIgnoreCase("y")) {
            productEntity.setStatus("available");
        } else {
            productEntity.setStatus("not_available");
        }
        
        return productEntity;
    }
    
    public static ProductEntity getProductData(String id) {
        String name = Input.getString("Enter name: ", "name", 3);
        Double unitPrice = Input.getDouble("Enter unit price: ", "Unit Price", ProductConfig.MIN_UNIT_PRICE, ProductConfig.MAX_UNIT_PRICE);
        Integer quantity = Input.getInt("Enter quantity: ", "Quantity", ProductConfig.MIN_QUANTITY, ProductConfig.MAX_QUANTITY);
        System.out.print("Is it available now? (Y/N) ");
        String isAvailable = Input.getString();
        ProductEntity productEntity = new ProductEntity(id, name, unitPrice, quantity, null);

        if (isAvailable.equalsIgnoreCase("y")) {
            productEntity.setStatus("available");
        } else {
            productEntity.setStatus("not_available");
        }
        
        return productEntity;
    }
    
    public static boolean getConfirmation(String msg, String confirmSignPattern) {
        System.out.println(msg);
        String confirmSign = Input.getString("[~ Type [ " + confirmSignPattern + " ] to confirm, or others to cancel ~]$ ");
        return confirmSign.equals(confirmSignPattern);
    }
}
