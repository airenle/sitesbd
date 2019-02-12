package HttpSpider;

import Dao.Page;
import Dao.SelectPageDao;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.util.ArrayList;
import java.util.List;

public class BaiduCilent {
    public static void SearchTab(String div_name) throws Exception {
        HttpToBeClient toBeClient = new HttpToBeClient();
        Document document = toBeClient.Get_page("http://site.baidu.com/");
        Elements tabs = document.select(div_name);
        for (Element element : tabs
        ) {
            Elements links = element.getElementsByTag("a");
            for (Element element1 : links
            ) {
                String href = element1.attr("href");
                String title = element1.html();
                SelectPageDao dao = new SelectPageDao();
                dao.add(new Page(element1.firstElementSibling().html(), href, title));

            }
        }
        System.out.println("--------------------------------------这是一条小尾巴--------------------------------------------");
    }

    public static void HotSearch(String div_name) throws Exception {
        HttpToBeClient toBeClient = new HttpToBeClient();
        Document document = toBeClient.Get_page("http://site.baidu.com/");
        Elements tabs = document.select(div_name);
        for (Element element : tabs
        ) {
            Elements links = element.getElementsByTag("a");
            for (Element element1 : links
            ) {
                String href = element1.attr("href");
                String title = element1.html();
                String type = "热搜推荐";
                SelectPageDao dao = new SelectPageDao();
                dao.add(new Page(type, href, title));

            }
        }
    }

    public static void RealModMt10(String div_name) throws Exception {
        HttpToBeClient toBeClient = new HttpToBeClient();
        Document document = toBeClient.Get_page("http://site.baidu.com/");
        Elements tabs = document.select(div_name);
        for (Element element : tabs
        ) {
            Elements links = element.getElementsByTag("a");
            for (Element element1 : links
            ) {
                String href = element1.attr("href");
                String title = element1.html();
                String type = "实时热搜";
                if (href.equals("javascript:;")) {
                    continue;
                }
                if (title.equals(type)) {
                    continue;
                }
                SelectPageDao dao = new SelectPageDao();
                dao.add(new Page(type, href, title));

            }
        }
    }

    public static void TabWrap(String div_name) throws Exception {
        HttpToBeClient toBeClient = new HttpToBeClient();
        Document document = toBeClient.Get_page("http://site.baidu.com/");
        Elements tabs = document.select(div_name);
        Elements hd = tabs.select("div.hd");
        Elements bd = tabs.select("div.bd");
        Elements bangdan1 = hd.select("a[monkey^=\"bangdan-yi\"]");
        List<String> bangdan12 = new ArrayList<>();
        List<String> bangdan34 = new ArrayList<>();
        List<String> bangdan11 = new ArrayList<>();
        List<String> bangdan22 = new ArrayList<>();
        List<String> bangdan33 = new ArrayList<>();
        List<String> bangdan44 = new ArrayList<>();
        for (Element e : bangdan1
        ) {
            for (int i = 0; i < 6; i++) {
                bangdan12.add(e.text());
            }
        }
        Elements bangdan2 = hd.select("a[monkey^=\"bangdan-er\"]");
        for (Element e : bangdan2
        ) {
            for (int i = 0; i < 6; i++) {
                bangdan12.add(e.text());
            }
        }
        Elements bangdan3 = hd.select("a[monkey^=\"bangdan-san\"]");
        for (Element e : bangdan3
        ) {
            for (int i = 0; i < 10; i++) {
                bangdan34.add(e.text());
            }
        }
        Elements bangdan4 = hd.select("a[monkey^=\"bangdan-si\"]");
        for (Element e : bangdan4
        ) {
            for (int i = 0; i < 10; i++) {
                bangdan34.add(e.text());
            }
        }
        Elements bangdanyi = bd.select("div[monkey^=\"bangdan-yi\"]");
        for (Element e : bangdanyi
        ) {
            Elements contents = e.getElementsByTag("a");
            for (Element e1 : contents
            ) {
                String link = e1.attr("href");
                String title = e1.html();
                bangdan11.add(link);
                bangdan22.add(title);
            }
        }
        Elements bangdaner = bd.select("div[monkey^=\"bangdan-er\"]");
        Elements bangdanera = bangdaner.select("a[class^=\"clr-black\"]");
        for (Element e : bangdanera
        ) {
            Elements contents = e.getElementsByTag("a");
            for (Element e1 : contents
            ) {
                String link = e1.attr("href");
                String title = e1.html();
                bangdan11.add(link);
                bangdan22.add(title);
            }
        }
        Elements bangdansan = bd.select("div[monkey^=\"bangdan-san\"]");
        for (Element e : bangdansan
        ) {
            Elements contents = e.getElementsByTag("a");
            for (Element e1 : contents
            ) {
                String link = e1.attr("href");
                String title = e1.html();
                bangdan33.add(link);
                bangdan44.add(title);
            }
        }
        Elements bangdansi = bd.select("div[monkey^=\"bangdan-si\"]");
        for (Element e : bangdansi
        ) {
            Elements contents = e.getElementsByTag("a");
            for (Element e1 : contents
            ) {
                String link = e1.attr("href");
                String title = e1.html();
                bangdan33.add(link);
                bangdan44.add(title);
            }
        }
        for (int i = 0; i < bangdan11.size(); i++) {
            SelectPageDao dao = new SelectPageDao();
            dao.add(new Page(bangdan12.get(i), bangdan11.get(i), bangdan22.get(i)));
        }
        for (int i = 0; i < bangdan33.size(); i++) {
            SelectPageDao dao = new SelectPageDao();
            dao.add(new Page(bangdan34.get(i), bangdan33.get(i), bangdan44.get(i)));
        }
    }

    public static void SitesModMt10(String div_name) throws Exception {
        HttpToBeClient toBeClient = new HttpToBeClient();
        Document document = toBeClient.Get_page("http://site.baidu.com/");
        Elements tabs = document.select(div_name);
        for (Element element : tabs
        ) {
            Elements links = element.getElementsByTag("a");
            for (Element element1 : links
            ) {
                String href = element1.attr("href");
                String title = element1.html();
                String type = "常用站点";
                if (href.equals("javascript:;")) {
                    continue;
                }
                if (title.equals(type)) {
                    continue;
                }
                SelectPageDao dao = new SelectPageDao();
                dao.add(new Page(type, href, title));

            }
        }
    }

    public static void ToolsMod(String div_name) throws Exception {
        HttpToBeClient toBeClient = new HttpToBeClient();
        Document document = toBeClient.Get_page("http://site.baidu.com/");
        Elements tabs = document.select(div_name);
        for (Element element : tabs
        ) {
            Elements links = element.getElementsByTag("a");
            for (Element element1 : links
            ) {
                String href = element1.attr("href");
                String title = element1.html();
                String type = "实用工具";
                if (href.equals("javascript:;")) {
                    continue;
                }
                if (title.equals(type)) {
                    continue;
                }
                SelectPageDao dao = new SelectPageDao();
                dao.add(new Page(type, href, title));

            }
        }
    }

    public static void CoolsMod(String div_name) throws Exception {
        HttpToBeClient toBeClient = new HttpToBeClient();
        Document document = toBeClient.Get_page("http://site.baidu.com/");
        Elements tabs = document.select(div_name);
        Elements titles = tabs.select("a.clr-blue");
        Elements contents = tabs.select("a.icon.clr-black");
        List<String> titles_list = new ArrayList<>();
        List<String> contents_list = new ArrayList<>();
        List<String> links_list = new ArrayList<>();
        for (Element element : titles
        ) {
            Elements links = element.getElementsByTag("a");
            for (Element element1 : links
            ) {
                String title = element1.html().replace(" ","");
                if (title.equals("更多&gt;&gt;")) {
                    continue;
                }
                if (title.equals("软件") | title.equals("金融")) {
                    for (int i = 0; i < 5; i++) {
                        contents_list.add(title);
                    }
                } else {
                    for (int i = 0; i < 6; i++) {
                        contents_list.add(title);
                    }
                }

            }
        }
        System.out.println(contents_list);
        for (Element element : contents
        ) {
            Elements links = element.getElementsByTag("a");
            for (Element element1 : links
            ) {
                String href = element1.attr("href");
                String title = element1.html();
                links_list.add(href);
                titles_list.add(title);
            }
        }
        for (int i = 0; i < contents_list.size(); i++) {
            SelectPageDao dao = new SelectPageDao();
            dao.add(new Page(contents_list.get(i), links_list.get(i), titles_list.get(i)));
        }
    }

    public static void ContentBottomMt10(String div_name) throws Exception {
        HttpToBeClient toBeClient = new HttpToBeClient();
        Document document = toBeClient.Get_page("http://site.baidu.com/");
        Elements tabs = document.select(div_name);
        Elements titles = tabs.select("a.clr-blue");
        Elements tags = tabs.select("a.clr-gray");
        List<String> titles_list = new ArrayList<>();
        List<String> tags_list = new ArrayList<>();
        List<String> links_list = new ArrayList<>();
        for (Element element : titles
        ) {
            Elements links = element.getElementsByTag("a");
            for (Element element1 : links
            ) {
                String title = element1.html();
                for (int i = 0; i < 24; i++) {
                    titles_list.add(title);
                }
            }
        }
        System.out.println(titles_list);
        for (Element element : tags
        ) {
            Elements links = element.getElementsByTag("a");
            for (Element element1 : links
            ) {
                String href = element1.attr("href");
                String title = element1.html();
                links_list.add(href);
                tags_list.add(title);
            }
        }
        for (int i = 0; i < titles_list.size(); i++) {
            SelectPageDao dao = new SelectPageDao();
            dao.add(new Page(titles_list.get(i), links_list.get(i), tags_list.get(i)));
        }
    }

    public static void main(String[] args) throws Exception {

        /*
        顶部导航栏
         */
//        SearchTab("div.search-tab");
        /*
         热搜
         */
//        HotSearch("div.pages");
//        HotSearch("div.hot-searches");
//        /*
//        新闻
//         */
//        TabWrap("div.tab-wrap");
//        RealModMt10("div.real.mod.mt10");
//        /*
//        常用站点
//         */
//        SitesModMt10("div.sites.mod.mt10");
//        /*
//        猜你喜欢
//         */
////        PrintElements("");
//        /*
//        实用工具
//         */
//        ToolsMod("div.tools.mod");
//        /*
//        站点导航
//         */
//        CoolsMod("div.cools.mod");
//        /*
//        底部导航栏
//         */
//        ContentBottomMt10("div.content-bottom.mt10");
    }
}