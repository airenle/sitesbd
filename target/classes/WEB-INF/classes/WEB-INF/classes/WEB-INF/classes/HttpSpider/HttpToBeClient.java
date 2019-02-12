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
        RequestConfig globalConfig = RequestConfig.custom().setCookieSpec(CookieSpecs.IGNORE_COOKIES).build();
        CloseableHttpClient httpClient = HttpClients.custom().setDefaultRequestConfig(globalConfig).build();
        HttpGet httpGet = new HttpGet(url);
//        httpGet.setConfig(RequestConfig.custom().setCookieSpec(CookieSpecs.STANDARD).build());
        httpGet.setHeader("User-Agent", "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_13_6) " +
                "AppleWebKit/537.36 (KHTML, like Gecko) Chrome/71.0.3578.98 Safari/537.36");
        CloseableHttpResponse response = httpClient.execute(httpGet);
        HttpEntity httpEntity = response.getEntity();
        String content = EntityUtils.toString(httpEntity, "utf-8");
        response.close();
        httpClient.close();
        Document document = Jsoup.parse(content);
        return document;
    }
}
