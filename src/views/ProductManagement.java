package views;

import config.ProductConfig;
import dao.exceptions.IOValidationException;
import entities.ProductEntity;
import handlers.Check;
import handlers.Create;
import handlers.Delete;
import handlers.Print;
import handlers.Save;
import handlers.Search;
import handlers.Update;
import java.util.ArrayList;
import services.ProductServiceSingleton;
import services.exceptions.ProductNotFoundException;
import utils.Input;

/**
 *
 * @author quocb
 */
public class ProductManagement {
    public static void main(String[] args) {
        boolean isContinue = true;
        MenuStrategy menu = new MenuStrategy();
        
        while (isContinue) {
            System.out.println("PRODUCT MANAGEMENT");
            menu.show();
            int choice = menu.getChoice("\n~@userr your choice - % ", 1, -1);
            switch (choice) {
                case 1: {
                    menu.setHandler(new Create());
                    break;
                }
                case 2: {
                    menu.setHandler(new Check());
                    break;
                }
                case 3: {
                    menu.setHandler(new Search());
                    break;
                            
                }
                case 4: {
                    menu.setHandler(new Update());
                    break;
                }
                case 5: {
                    menu.setHandler(new Delete());
                    break;
                }
                case 6: {
                    menu.setHandler(new Save());
                    break;
                }
                case 7: {
                    menu.setHandler(new Print());
                    break;
                }
                default: {
                    menu.setHandler(null);
                }
            }
            
            isContinue = menu.handleChoice();
        }
    }
}
