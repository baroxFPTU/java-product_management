package handlers;

import entities.ProductEntity;
import services.ProductServiceSingleton;
import services.exceptions.PreexistProductException;
import views.Form;

/**
 *
 * @author quocb
 */
public class Create implements IHandler{
    @Override
    public void execute() throws PreexistProductException {
        ProductServiceSingleton service = ProductServiceSingleton.getInstance();
        ProductEntity productEntity = Form.getProductData();
        service.create(productEntity);
        System.out.println("Product is created");
    }
}
