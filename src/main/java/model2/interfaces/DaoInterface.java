package model2.interfaces;

import java.io.Serializable;
import java.util.List;


public interface DaoInterface<T> extends Serializable {

    public void insert(T entity);

    public void update(T entity);

    public List<T> select(String query) ;

    public void delete(T entity);

    public List<T> findAll();

    public T getEntityByID(int id);
}
