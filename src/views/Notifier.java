package views;

/**
 *
 * @author quocb
 */
public class Notifier {
    private String _msg;
    
    public Notifier() {
    }

    public Notifier(String _msg) {
        this._msg = _msg;
    }

    public String getMsg() {
        return _msg;
    }

    public void setMsg(String value) {
        this._msg = value;
        hasChange();
    }
    
    public void hasChange() {
        System.out.println(_msg);
    }
}
