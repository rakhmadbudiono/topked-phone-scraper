package tokped.phone.scraper;

import java.io.IOException;
import com.gargoylesoftware.htmlunit.html.DomElement;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlPage;

class ProductNameScraper extends TokpedScraper {
    static final String TAG = "h1";
    static final String DATA_TEST_ID = "lblPDPDetailProductName";

    public String scrap(String url) throws IOException {
        try {
            WebClient client = SetupWebClient();
            HtmlPage page = client.getPage(url);
            CloseWebClient(client);

            DomElement element = GetElementByDataTestId(page, TAG, DATA_TEST_ID);
            String text = element.asNormalizedText();
            
            return removeCommas(text);

        } catch (IOException e) {
            throw new IOException("ProductNameScraper.scrap : " + e);
        }
    }
    private String removeCommas(String text) {
        return text.replace(",", "");
    }
}
