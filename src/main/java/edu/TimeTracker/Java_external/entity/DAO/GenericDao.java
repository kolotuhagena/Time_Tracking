package edu.TimeTracker.Java_external.entity.DAO;

import java.sql.SQLException;
import java.util.List;

public interface GenericDao<T> {

    /**
     * Создает новую запись и соответствующий ей объект
     */
    public T create() throws SQLException;

    /**
     * Создает новую запись, соответствующую объекту object
     */
    public T persist(T object) throws SQLException;

    /**
     * Возвращает объект соответствующий записи с первичным ключом key или null
     */
    public T getByPK(int key) throws SQLException;

    /**
     * Сохраняет состояние объекта group в базе данных
     */
    public void update(T object) throws SQLException;

    /**
     * Удаляет запись об объекте из базы данных
     */
    public void delete(T object) throws SQLException;

    /**
     * Возвращает список объектов соответствующих всем записям в базе данных
     */
    public List<T> getAll() throws SQLException;

}
