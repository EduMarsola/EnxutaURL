package com.EnxutaURL.EnxutaURL.URL;

import java.util.Optional;
import com.EnxutaURL.EnxutaURL.InternalFeatures.Compactor;
import com.EnxutaURL.EnxutaURL.Persistence;

public class URLController {
    public Optional<String> Compact(String originalURL){
        return Optional.of(Compactor.compact(originalURL));
    }

    public Optional<String> DeCompact(String compactURL){
        return Optional.of(Persistence.Out(compactURL));
    }
}
