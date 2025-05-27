package com.EnxutaURL.EnxutaURL.URL;

import java.util.Optional;
import com.EnxutaURL.EnxutaURL.InternalFeatures.Compactor;

public class URLController {
    public void teste(){

    }

    public Optional<String> Compact(String originalURL){
        Optional<String> response;
        response = Optional.of(Compactor.compact(originalURL));
        return response;
    }
}
