package tokped.phone.scraper;

import java.io.IOException;
import com.gargoylesoftware.htmlunit.html.DomElement;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlPage;

class ProductDescScraper extends TokpedScraper {
    static final String TAG = "div";
    static final String DATA_TEST_ID = "lblPDPDescriptionProduk";

    public String scrap(String url) throws IOException {
        try {
            WebClient client = SetupWebClient();
            HtmlPage page = client.getPage(url);
            CloseWebClient(client);

            DomElement element = GetElementByDataTestId(page, TAG, DATA_TEST_ID);

            return simplifyDescription(element);
            
        } catch (IOException e) {
            throw new IOException("ProductDescScraper.scrap : " + e);
        }
    }

    private String simplifyDescription(DomElement element) {
        String text = element.asNormalizedText();
        text = extractFirstLine(text);

        return removeCommas(text);
    }

    private String extractFirstLine(String text) {
        return text.split("\n")[0];
    }

    private String removeCommas(String text) {
        return text.replace(",", "");
    }
}
