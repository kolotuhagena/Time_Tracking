package edu.TimeTracker.Java_external.entity.DAO;

import java.sql.SQLException;
import java.util.List;

public interface GenericDao<T> {

    /**
     * Создает новую запись и соответствующий ей объект
     */
    public void create(T object) throws SQLException;

    /**
     * Возвращает объект соответствующий записи с первичным ключом key или null
     */
    public T getById(int key) throws SQLException;

    /**
     * Сохраняет состояние объекта group в базе данных
     */
    public void update(T object, int id) throws SQLException;

    /**
     * Удаляет запись об объекте из базы данных
     */
    public void delete(int id) throws SQLException;

    /**
     * Возвращает список объектов соответствующих всем записям в базе данных
     */
    public List<T> getAll() throws SQLException;

}
