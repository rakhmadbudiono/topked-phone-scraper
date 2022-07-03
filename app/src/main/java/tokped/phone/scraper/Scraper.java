package tokped.phone.scraper;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

class Scraper {
    final int PAGES = 25;

    ProductLinkScraper productLinkScraper;
    ProductNameScraper productNameScraper;
    ProductDescScraper productDescriptionScraper;
    ProductImgLinkScraper productImgLinkScraper;
    ProductPriceScraper productPriceScraper;
    ProductRatingScraper productRatingScraper;
    StoreNameScraper StoreNameScraper;


    public Scraper() {
        this.productLinkScraper = new ProductLinkScraper();
        this.productNameScraper = new ProductNameScraper();
        this.productDescriptionScraper = new ProductDescScraper();
        this.productImgLinkScraper = new ProductImgLinkScraper();
        this.productPriceScraper = new ProductPriceScraper();
        this.productRatingScraper = new ProductRatingScraper();
        this.StoreNameScraper = new StoreNameScraper();
    }

    public List<MobilePhone> ScrapMobilePhones() {
        List<String> productLinks = new ArrayList<>();
        for (int i = 0; i < PAGES ; i++) {
            try {
                List<String> links = this.productLinkScraper.scrap("https://www.tokopedia.com/p/handphone-tablet/handphone?page=" + Integer.toString(i+ 1));
            
                productLinks.addAll(
                    links
                );
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        List<MobilePhone> phones = new ArrayList<>();
        for (String link : productLinks) {
            try {
                MobilePhone phone = extractMobilePhone(link);
                phones.add(phone);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return phones;
    }

    private MobilePhone extractMobilePhone(String url) throws IOException {
        try {
            return new MobilePhone(
                this.productNameScraper.scrap(url),
                this.productDescriptionScraper.scrap(url),
                this.productImgLinkScraper.scrap(url),
                this.productPriceScraper.scrap(url),
                this.productRatingScraper.scrap(url),
                this.StoreNameScraper.scrap(url)
            );
        } catch (IOException e) {
            throw new IOException("extractMobilePhone: " + e);
        }
    }
}