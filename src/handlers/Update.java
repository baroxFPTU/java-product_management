/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package handlers;

import config.ProductConfig;
import entities.ProductEntity;
import services.ProductServiceSingleton;
import services.exceptions.ProductNotFoundException;
import utils.Input;
import views.Form;

/**
 *
 * @author quocb
 */
public class Update implements IHandler {

    @Override
    public void execute() throws Exception {
        ProductServiceSingleton service = ProductServiceSingleton.getInstance();

        String productID = Input.getStringReg("Enter ID: ", "ID", ProductConfig.ID_REGEX);
        if (service.isIdExit(productID)) {
            ProductEntity productEntity = Form.getProductData(productID);
            service.update(productEntity);
            System.out.println("~ Update succeed.");
        } else {
            throw new ProductNotFoundException("Failed. Product is not found.");
        }

    }
}
