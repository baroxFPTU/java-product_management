package services;

import dao.ProductDao;
import dao.exceptions.IOValidationException;
import entities.ProductEntity;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import services.exceptions.PreexistProductException;
import services.exceptions.ProductNotFoundException;

/**
 *
 * @author quocb
 */
public class ProductService {
    private ArrayList<ProductEntity> lsProduct;
    private ProductDao productDao = new ProductDao();
    
    public ProductService() {
        try {
            this.lsProduct = productDao.read();
        } catch (IOValidationException ex) {
            System.out.println(ex.getMessage());
        } 
    }
    public ProductService(ArrayList<ProductEntity> lsProduct) {
        this.lsProduct = lsProduct;
    }
    public void create(ProductEntity product) throws PreexistProductException {
        String productID = product.getProductID();
        String productName = product.getProductName();
        
        System.out.println("Is id exit: " + isIdExit(productID));
        
        if (isIdExit(productID)) {
            throw new PreexistProductException("Product's ID is exist.");
        } else if (isNameExist(productName)) {
            throw new PreexistProductException("Product's name is exist.");
        }
        lsProduct.add(product);
    }
    public boolean isNameExist(String productName) {
        Stream<ProductEntity> filteredProducts = lsProduct.stream().filter(prdct -> prdct.getProductName().equalsIgnoreCase(productName));
        boolean isExist = filteredProducts.findAny().isPresent();
        return isExist;
    }
    public boolean isIdExit(String productId) {
        Stream<ProductEntity> filteredProducts = lsProduct.stream().filter(prdct -> prdct.getProductID().equalsIgnoreCase(productId));
        boolean isExist = filteredProducts.findAny().isPresent();
        return isExist;
    }
    public ArrayList<ProductEntity> getByName(String queryName){
        Stream<ProductEntity> matchedProducts = lsProduct.stream().filter(prdct -> {
            return prdct.getProductName().toLowerCase().contains(queryName.toLowerCase());
        });
        List<ProductEntity> list = matchedProducts.collect(Collectors.toList());
        return new ArrayList<>(list);
    }
    public void update(ProductEntity product) throws ProductNotFoundException{
        for (int i = 0; i<lsProduct.size(); i++) {
            if (lsProduct.get(i).getProductID().equals(product.getProductID())) {
                lsProduct.set(i, product);
                break;
            }
        }
    }
    public void delete(String productID){
        lsProduct.removeIf(prdct -> prdct.getProductID().equals(productID));
    }
    public void save() throws IOValidationException{
        productDao.write(lsProduct);
    }
    public ArrayList<ProductEntity> findAll() {
        return lsProduct;
    }
}
