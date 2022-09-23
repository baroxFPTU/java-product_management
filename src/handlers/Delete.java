package handlers;

import config.ProductConfig;
import handlers.exceptions.CancelProcessException;
import services.ProductServiceSingleton;
import services.exceptions.ProductNotFoundException;
import utils.Input;
import views.Form;

/**
 *
 * @author quocb
 */
public class Delete implements IHandler {

    @Override
    public void execute() throws ProductNotFoundException, Exception {
        ProductServiceSingleton service = ProductServiceSingleton.getInstance();

        String productID = Input.getStringReg("Enter ID: ", "ID", ProductConfig.ID_REGEX);
        if (service.isIdExit(productID)) {
            Boolean isConfirm = Form.getConfirmation("Are you sure to delete it?", productID);
            if (isConfirm) {
                service.delete(productID);
                System.out.println("~ Removed succeed.");
            } else {
                throw new CancelProcessException("Process is cancel");
            }
        } else {
            throw new ProductNotFoundException("Failed. Product is not found.");
        }
    }

}
