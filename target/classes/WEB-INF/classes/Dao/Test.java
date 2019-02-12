package Dao;

import java.util.List;

public class Test {
    public static void main(String[] args) throws Exception {
        SelectPageDao dao = new SelectPageDao();
        List<Page> bdsites = dao.findAllPages();
        System.out.println(bdsites);
        for (Page bd : bdsites
        ) {
            System.out.println(bd.getType() + "\t" + bd.getLink() + "\t" + bd.getContent());
        }
////        List<Page> findbyid = dao.findByType("娱乐休闲");
////        for (Page bd:findbyid
////             ) {
////            System.out.println(bd.getType() + "\t" + bd.getLink() + "\t" + bd.getContent());
////
////        }
//
////        dao.add(new Page("新的一条记录","22","333"));
//        PageDao pageDao = new SelectPageDao();
//        List list = pageDao.findAllPages();
//        System.out.println(list.toString());

    }
}
