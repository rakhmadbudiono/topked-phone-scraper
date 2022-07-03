package tokped.phone.scraper;

import java.io.IOException;
import com.gargoylesoftware.htmlunit.html.DomElement;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlPage;

class ProductPriceScraper extends TokpedScraper {
    static final String TAG = "div";
    static final String DATA_TEST_ID = "lblPDPDetailProductPrice";

    public Double scrap(String url) throws IOException {
        try {
            WebClient client = SetupWebClient();
            HtmlPage page = client.getPage(url);
            CloseWebClient(client);

            DomElement element = GetElementByDataTestId(page, TAG, DATA_TEST_ID);

            return getProductPrice(element);
            
        } catch (IOException e) {
            throw new IOException("ProductPriceScraper.scrap : " + e);
        }
    }

    public Double getProductPrice(DomElement element) {
        String text = element.asNormalizedText();
        text = text.replace("Rp", "").replace(".", "");

        return Double.parseDouble(text);
    }
}
