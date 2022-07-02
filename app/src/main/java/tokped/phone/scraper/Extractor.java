package tokped.phone.scraper;

import java.io.IOException;
import java.io.File;
import java.nio.file.Files;
import java.util.List;

class Extractor {
    public void ExtractCSV(List<String> rows, String path) throws IOException {
        File file = new File(path);

        Files.write(file.toPath(), rows);
    }
}