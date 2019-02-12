package Dao;

import java.util.List;

public interface PageDao {
    List<Page> findByType(String page) throws Exception;

    void add(Page p) throws Exception;

    void update(int id) throws Exception;

    void delete(int id) throws Exception;

    List<Page> findAllPages() throws Exception;
}
