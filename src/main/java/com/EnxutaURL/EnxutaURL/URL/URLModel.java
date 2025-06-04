package com.EnxutaURL.EnxutaURL.URL;

import com.EnxutaURL.EnxutaURL.Persistence;
import jakarta.persistence.Access;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("URL")
public class URLModel {
    URLController urlController = new URLController();

    @GetMapping("/test")
    public String teste(){
        return "";
    }

    @CrossOrigin
    @GetMapping("/generateCompact/")
    public String GenerateCompact(@RequestParam("originalURL") String originalURL){
        if(urlController.Compact(originalURL).isPresent()){
            String reply = urlController.Compact(originalURL).get();
            Persistence.In(originalURL, reply);
            return "{\"compactURL\" : \"" + reply + "\"}";
        }
        else{
            return "Internal error while compacting";
        }
    }

    @CrossOrigin
    @GetMapping("/get/")
    public String Get(@RequestParam("compactURL") String compactURL){
        if(urlController.DeCompact(compactURL).isPresent()){
            String insert = urlController.DeCompact(compactURL).get();
            return insert;
        }
        else{
            return "Internal error while decompacting url";
        }
    }
}
