package views;

import handlers.IHandler;
import handlers.exceptions.CancelProcessException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import utils.Input;

/**
 *
 * @author quocb
 */
public class MenuStrategy {

    private IHandler _handler;

    public MenuStrategy() {
    }

    public void show() {
        final String[] options = {
            "1. Create a Product",
            "2. Check exits Product",
            "3. Search Product's information by Name",
            "4. Update Product",
            "5. Delete Product",
            "6. Save to file",
            "7. Print all Products",
            "Others - Exit"
        };
        for (String option : options) {
            System.out.println(option);
        }
    }

    public int getChoice(String message, int min, int max) {
        try {
            int choice = Integer.valueOf(Input.getString(message, "choice", 1));
            return choice;
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    public void setHandler(IHandler handler) {
        _handler = handler;
    }

    public boolean handleChoice() {
        if (_handler == null) {
            return false;
        }
        
        boolean flag = true;
        try {
            _handler.execute();
        } catch (CancelProcessException clex) {
            System.out.println(clex.getMessage());
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            flag = false;
        }

        try {
            System.out.println("Enter to continue...");
            System.in.read();
        } catch (IOException ex) {
            Logger.getLogger(MenuStrategy.class.getName()).log(Level.SEVERE, null, ex);
        }

        return flag;
    }
}
