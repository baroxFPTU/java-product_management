/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package handlers;

import dao.exceptions.IOValidationException;
import services.ProductServiceSingleton;

/**
 *
 * @author quocb
 */
public class Save implements IHandler {

    @Override
    public void execute() throws IOValidationException {
        ProductServiceSingleton service = ProductServiceSingleton.getInstance();
        service.save();
        System.out.println("~ Saved");
    }

}
