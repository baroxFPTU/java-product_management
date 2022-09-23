package services.exceptions;

/**
 *
 * @author quocb
 */
public class ProductNotFoundException extends Exception{

    public ProductNotFoundException(String msg) {
        super(msg);
    }
}
