package URL;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("url")
public class URLModel {
    URLController urlController = new URLController();
    @GetMapping("/generateCompact")
    public String GenerateCompact(String originalURL){
        urlController.teste();
        return "";
    }

    @GetMapping("/get/")
    public void Get(@RequestParam("compactURL") String compactURL){

    }
}
