/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package handlers;

import entities.ProductEntity;
import java.util.ArrayList;
import services.ProductServiceSingleton;

/**
 *
 * @author quocb
 */
public class Print implements IHandler{
    @Override
    public void execute() {
        ProductServiceSingleton service = ProductServiceSingleton.getInstance();
        
        ArrayList<ProductEntity> lsProduct = service.findAll();
        for (ProductEntity prdct : lsProduct) {
            System.out.println(prdct);
        }
    }
    
    public void execute(ArrayList<ProductEntity> lsProduct) {
        for (ProductEntity prdct : lsProduct) {
            System.out.println(prdct);
        }
    }
}
