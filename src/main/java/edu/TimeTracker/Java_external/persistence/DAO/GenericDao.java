package edu.TimeTracker.Java_external.persistence.DAO;

import java.util.List;

public interface GenericDao<T> {

    /**
     * Создает новую запись и соответствующий ей объект
     */
     void create(T object);

    /**
     * Возвращает объект соответствующий записи с первичным ключом key или null
     */
     T getById(int key) ;

    /**
     * Возвращает объект соответствующий записи с логином login
     */
     T getByName(String login) ;
    /**
     * Сохраняет состояние объекта group в базе данных
     */
     void update(T object, int id) ;

    /**
     * Удаляет запись об объекте из базы данных
     */
     void delete(int id) ;

    /**
     * Возвращает список объектов соответствующих всем записям в базе данных
     */
     List<T> getAll() ;

}
