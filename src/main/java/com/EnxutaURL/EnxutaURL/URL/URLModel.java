package com.EnxutaURL.EnxutaURL.URL;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("URL")
public class URLModel {

    @GetMapping("/test")
    public String teste(){
        return "testado";
    }
    @GetMapping("/generateCompact/")
    public String GenerateCompact(@RequestParam("originalURL") String originalURL){
        URLController urlController = new URLController();
        if(urlController.Compact(originalURL).isPresent()){
            return urlController.Compact(originalURL).get();
        }
        else{
            return "Internal error while compacting";
        }
    }

    @GetMapping("/get/")
    public void Get(@RequestParam("compactURL") String compactURL){

    }
}
