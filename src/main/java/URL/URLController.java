package URL;

import java.util.Optional;
import InternalFeatures.Compactor;

public class URLController {
    public void teste(){
        System.out.println("Testado");
    }
    public Optional<String> Compact(String originalURL){
        Optional<String> response;
        response = Optional.of(Compactor.compact(originalURL));
        return response;
    }
}
