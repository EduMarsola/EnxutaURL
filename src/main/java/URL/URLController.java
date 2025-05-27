package URL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Optional;
import InternalFeatures.Compactor;

public class URLController {
    public void teste(){

    }

    public Optional<String> Compact(String originalURL){
        Optional<String> response;
        response = Optional.of(Compactor.compact(originalURL));
        return response;
    }
}
