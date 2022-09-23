package dao;

/**
 *
 * @author quocb
 * @param <T>
 */
public interface IDao <T> {
    public T read()  throws Exception ;
    public boolean write();
}
