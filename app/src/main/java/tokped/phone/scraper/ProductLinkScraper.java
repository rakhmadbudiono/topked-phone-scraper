package tokped.phone.scraper;

import java.util.ArrayList;
import java.util.List;
import java.io.IOException;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.DomElement;
import com.gargoylesoftware.htmlunit.html.HtmlPage;

class ProductLinkScraper extends TokpedScraper {
    static final String TAG = "div";
    static final String DATA_TEST_ID = "lstCL2ProductList";
    static final String PROMO_URL_PREFIX = "https://ta.tokopedia.com/promo";

    public List<String> scrap(String url) throws IOException {
        try {
            WebClient client = SetupWebClient();
            HtmlPage page = client.getPage(url);
            CloseWebClient(client);

            DomElement element = GetElementByDataTestId(page, TAG, DATA_TEST_ID);

            return getProductDetailLinks(element);
            
        } catch (IOException e) {
            throw new IOException("ProductLinkScraper.scrap : " + e);
        }
    }

    private List<String> getProductDetailLinks(DomElement productListElement) {
        List<String> links = new ArrayList<>(); 
        for (DomElement element : productListElement.getChildElements()) {
            if (
                element == null || 
                element.getFirstChild() == null || 
                element.getFirstChild().getAttributes() == null || 
                element.getFirstChild().getAttributes().item(0) == null) continue;

            String link = element.getFirstChild().getAttributes().item(0).getNodeValue();
            
            if(link.startsWith(PROMO_URL_PREFIX)) continue;
            
            links.add(link);
        }

        return links;
    }
}
