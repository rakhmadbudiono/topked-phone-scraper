package tokped.phone.scraper;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.Arrays;
import com.gargoylesoftware.htmlunit.html.DomElement;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlPage;

class ProductImgLinkScraper extends TokpedScraper {
    static final String TAG = "img";
    static final String DATA_TEST_ID = "PDPMainImage";

    public String scrap(String url) throws IOException {
        try {
            WebClient client = SetupWebClient();
            HtmlPage page = client.getPage(url);
            CloseWebClient(client);

            DomElement element = GetElementByDataTestId(page, TAG, DATA_TEST_ID);

            return getLink(element);

        } catch (IOException e) {
            throw new IOException("ProductImgLinkScraper.scrap : " + e);
        }
    }

    private String getLink(DomElement element) {
        String url = element.getAttribute("src");

        return removeLastParam(url).replace("[", "").replace("]", "");
    }

    private String removeLastParam(String url) {
        String[] a = url.split("\\?");
        a = Arrays.copyOfRange(a, 0, a.length-1);

        return Arrays.toString(a);
    }
}
