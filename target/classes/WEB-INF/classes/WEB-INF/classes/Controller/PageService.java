package Controller;

import Dao.Page;
import Dao.PageDao;
import Dao.SelectPageDao;
import com.sun.org.apache.regexp.internal.RE;

import java.util.List;

public class PageService {
    public List<Page> getAllPages() throws Exception{
        PageDao dao = new SelectPageDao();
        List<Page> list = dao.findAllPages();
        return list;
    }
}
