package dao;

import java.util.ArrayList;

public interface DAOInterface<Type> {
    public void add(Type type);

    public void update(Type type);

    public void delete(Type type);

    public ArrayList<Type> sellectAll();

    public Type sellectById(Type type);

    public ArrayList<Type> sellectByCondition(String condition);
}
