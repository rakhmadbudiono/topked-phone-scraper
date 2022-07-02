package tokped.phone.scraper;

import com.gargoylesoftware.htmlunit.*;
import com.gargoylesoftware.htmlunit.html.*;
import java.io.IOException;
import java.util.List;

class Scraper {
    public Scraper() {}

    public MobilePhone[] ScrapMobilePhones() {
        return new MobilePhone[]{
            new MobilePhone(
                "Mobile Phone 1",
                "Mobile Phone 1 Series A",
                "https://img.freepik.com/free-photo/mobile-smart-phone-white-background-technology_10541-3965.jpg?w=1380",
                6900000.0,
                4.2,
                "Store 1"
            ),
            new MobilePhone(
                "Mobile Phone 2",
                "Mobile Phone 2 Series B",
                "https://img.freepik.com/free-photo/mobile-smart-phone-white-background-technology_10541-3965.jpg?w=1380",
                4200000.0,
                1.3,
                "Store 2"
            )
        };
    }

    public void Test() {
        WebClient webClient = new WebClient(BrowserVersion.CHROME);
        webClient.getOptions().setCssEnabled(false);
        webClient.getOptions().setThrowExceptionOnFailingStatusCode(false);
        webClient.getOptions().setThrowExceptionOnScriptError(false);
        webClient.getOptions().setPrintContentOnFailingStatusCode(false);

        try {
            HtmlPage page = webClient.getPage("https://foodnetwork.co.uk/italian-family-dinners/");

            webClient.getCurrentWindow().getJobManager().removeAllJobs();
            
            String title = page.getTitleText();
            System.out.println("Page Title: " + title);

            List<HtmlAnchor> links = page.getAnchors();
            for (HtmlAnchor link : links) {
                String href = link.getHrefAttribute();
                System.out.println("Link: " + href);
            }
            
            webClient.close();
        } catch (IOException e) {
            System.out.println("An error occurred: " + e);
        }
    }
}