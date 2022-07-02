import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    static Scraper scraper = new Scraper();
    static Extractor extractor = new Extractor();

    public static void main(String[] args) throws IOException {        
        MobilePhone[] phones = scraper.ScrapMobilePhones();
        List<String> rows = phonesToRows(phones);

        String path = "mobile_phones.csv";
        extractor.ExtractCSV(rows, path);
    }

    private static List<String> phonesToRows(MobilePhone[] phones) {
        List<String> rows = new ArrayList<>();

        String title = "product_name,description,image_link,price,rating,store_name";
        rows.add(title);

        for (MobilePhone phone : phones) {
            rows.add(phone.toString());             
        }

        return rows;
    }
}