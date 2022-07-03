package tokped.phone.scraper;

import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.DomElement;
import com.gargoylesoftware.htmlunit.html.HtmlPage;

import java.io.IOException;
import java.util.List;

class TokpedScraper {
    static WebClient SetupWebClient() {
        WebClient webClient = new WebClient(BrowserVersion.CHROME);
        webClient.getOptions().setCssEnabled(false);
        webClient.getOptions().setThrowExceptionOnFailingStatusCode(false);
        webClient.getOptions().setThrowExceptionOnScriptError(false);
        webClient.getOptions().setPrintContentOnFailingStatusCode(false);
        webClient.getOptions().setJavaScriptEnabled(false);

        return webClient;
    }

    static void CloseWebClient(WebClient client) {
        client.close();
    }

    static DomElement GetElementByDataTestId(HtmlPage page, String tag, String dataTestId) throws IOException {      
        List<DomElement> elements = page.getElementsByTagName(tag);

        DomElement targetElement = null;
        for (DomElement element : elements) {
            if (element.getAttribute("data-testid").equals(dataTestId)) {
                targetElement = element;
                break;
            }
        }

        if (targetElement == null) {
            throw new IOException("GetElementByDataTestId: element not found");
        }

        return targetElement;
    }
}
