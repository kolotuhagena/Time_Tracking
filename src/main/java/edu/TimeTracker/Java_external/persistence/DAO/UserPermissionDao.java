package edu.TimeTracker.Java_external.persistence.DAO;

import java.util.List;

public interface UserPermissionDao <T> {
    /**
     * Возвращает список объектов соответствующих всем записям в базе данным одному пользователю
     */
    List<T> getAllWithPagination(int userId, int offset, int recordPerPage) ;
    int getRecords(int UserId);


}
