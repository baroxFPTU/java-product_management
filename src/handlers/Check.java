package handlers;

import services.ProductServiceSingleton;
import utils.Input;

/**
 *
 * @author quocb
 */
public class Check implements IHandler{
    @Override
    public void execute() {
        ProductServiceSingleton service = ProductServiceSingleton.getInstance();
        String name = Input.getString("Enter name: ", "name", 3);
        boolean isExist = service.isNameExist(name);
        String message = isExist ? "Product's exist" : "Product not found";
        System.out.println(message);
    }
}
