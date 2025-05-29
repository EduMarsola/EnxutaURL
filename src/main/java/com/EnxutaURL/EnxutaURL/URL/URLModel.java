package com.EnxutaURL.EnxutaURL.URL;

import com.EnxutaURL.EnxutaURL.Persistence;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("URL")
public class URLModel {
    URLController urlController = new URLController();

    @GetMapping("/test")
    public String teste(){
        return "";
    }
    @GetMapping("/generateCompact/")
    public String GenerateCompact(@RequestParam("originalURL") String originalURL){
        if(urlController.Compact(originalURL).isPresent()){
            String reply = urlController.Compact(originalURL).get();
            Persistence.In(originalURL, reply);
            return reply;
        }
        else{
            return "Internal error while compacting";
        }
    }

    @GetMapping("/get/")
    public String Get(@RequestParam("compactURL") String compactURL){
        if(urlController.DeCompact(compactURL).isPresent()){
            return urlController.DeCompact(compactURL).get();
        }
        else{
            return "Internal error while decompacting url";
        }
    }
}
