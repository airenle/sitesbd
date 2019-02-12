package HttpSpider;

import org.apache.http.HttpEntity;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class SimpleClient {
    public static void main(String[] args) {
        int count = 0;
        for (int i = 0; i <= 225; i += 25) {
            count++;
            HttpGet httpGet = new HttpGet("https://movie.douban.com/top250?start=" + i);
            httpGet.setConfig(RequestConfig.custom().setConnectTimeout(30000).setSocketTimeout(30000).build());
            CloseableHttpClient httpClient = null;
            CloseableHttpResponse reponse = null;
            String reponseStr = "";
            try {
                httpClient = HttpClientBuilder.create().build();
                HttpClientContext context = HttpClientContext.create();
                reponse = httpClient.execute(httpGet, context);
                int state = reponse.getStatusLine().getStatusCode();
                if (state == 200)
                    reponseStr = "";
                HttpEntity entity = reponse.getEntity();
                if (entity != null)
                    reponseStr = EntityUtils.toString(entity, "utf-8");

            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                try {
                    if (reponse != null)
                        reponse.close();
                    if (httpClient != null)
                        httpClient.close();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
            if (reponseStr == null)
                return;
            Document document = Jsoup.parse(reponseStr);
            Elements infos = document.select("div.info");

            for (Element element : infos
            ) {
                try {

                    Element links = element.getElementsByTag("a").first();
                    Element star = element.getElementsByClass("star").first();
                    Element contents = element.getElementsByTag("p").get(1);
                    String link = links.attr("href");
                    String title = links.child(0).html();
                    String score = star.child(1).html();
                    String content = contents.child(0).html();
                    System.out.print(link + "\n" + title + "\t" + score + "\t" + content + "\n");
                    FileIo fileIo = new FileIo("douban.csv");
                    fileIo.Write_To_Csv(link + "\n" + title + "\t" + score + "\t" + content + "\n");
                } catch (Exception es) {
                    continue;
                }
            }

        }
        System.out.println(count);
        System.out.println();
    }
}
