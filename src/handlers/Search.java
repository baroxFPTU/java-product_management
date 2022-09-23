package handlers;

import entities.ProductEntity;
import java.util.ArrayList;
import services.ProductServiceSingleton;
import services.exceptions.ProductNotFoundException;
import utils.Input;

/**
 *
 * @author quocb
 */
public class Search implements IHandler {
    @Override
    public void execute() throws ProductNotFoundException  {
        ProductServiceSingleton service = ProductServiceSingleton.getInstance();

        String name = Input.getString("Enter name: ", "name", 1);
        ArrayList<ProductEntity> lsProduct = service.getByName(name);
        if (lsProduct.isEmpty()) {
            throw new ProductNotFoundException("Have no any Product!");
        }
        
        Print printer = new Print();
        printer.execute(lsProduct);
    }
}
