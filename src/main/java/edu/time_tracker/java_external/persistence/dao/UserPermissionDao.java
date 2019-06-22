package edu.time_tracker.java_external.persistence.dao;

import java.util.List;

public interface UserPermissionDao <T> {
    /**
     * Возвращает список объектов соответствующих всем записям в базе данным одному пользователю
     */
    List<T> getAllWithPagination(int userId, int offset, int recordPerPage) ;
    int getRecords(int UserId);


}
