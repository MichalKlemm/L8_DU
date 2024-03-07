package cz.engeto.L8_DU.RSSReader;
import org.springframework.core.io.ClassPathResource;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

@RestController
public class RSSReader {

    @GetMapping("/scifi")
    public String getScifiContent() throws IOException{
        return getFileContent("scifi.txt");
    }

    @GetMapping("/romantic")
    public String getRomanticContent() throws IOException {
        return getFileContent("romantic.txt");
    }

    @GetMapping("/historic")
    public String getHistoricContent() throws IOException {
        return getFileContent("historic.txt");
    }

    private String getFileContent(String filename) throws IOException {
        ClassPathResource resource = new ClassPathResource(filename);
        InputStream inputStream = resource.getInputStream();
        byte[] bytes = FileCopyUtils.copyToByteArray(inputStream);
        return new String(bytes, StandardCharsets.UTF_8);
    }
}
