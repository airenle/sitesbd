package HttpSpider;

import org.apache.http.HttpEntity;
import org.apache.http.client.config.CookieSpecs;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class HttpToBeClient {
    public Document Get_page(String url) throws Exception {
//        new httpclient实例并设置cookie属性
        RequestConfig globalConfig = RequestConfig.custom().setCookieSpec(CookieSpecs.IGNORE_COOKIES).build();
        CloseableHttpClient httpClient = HttpClients.custom().setDefaultRequestConfig(globalConfig).build();
//        新建httpget对象并传入url
        HttpGet httpGet = new HttpGet(url);
//        设置请求头
        httpGet.setHeader("User-Agent", "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_13_6) " +
                "AppleWebKit/537.36 (KHTML, like Gecko) Chrome/71.0.3578.98 Safari/537.36");
//        发起请求
        CloseableHttpResponse response = httpClient.execute(httpGet);
//        实例对象并设置编码格式
        HttpEntity httpEntity = response.getEntity();
        String content = EntityUtils.toString(httpEntity, "utf-8");
//        关闭连接
        response.close();
        httpClient.close();
//        Jsoup解析并返回document对象
        Document document = Jsoup.parse(content);
        return document;
    }
}
