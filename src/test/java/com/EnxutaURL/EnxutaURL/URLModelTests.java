package com.EnxutaURL.EnxutaURL;

import com.EnxutaURL.EnxutaURL.URL.URLController;
import com.EnxutaURL.EnxutaURL.URL.URLModel;
import com.mysql.cj.util.SaslPrep;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.hamcrest.Matchers.instanceOf;
import static org.hamcrest.Matchers.isA;
import static org.junit.jupiter.api.Assertions.*;

public class URLModelTests {
    URLModel urModel = new URLModel();
    URLController urController = new URLController();
    String example = "example";
    @Test
    void Test_generateCompact(){
        assertEquals(String.class, urModel.GenerateCompact(example).getClass());
    }

    @Test
    void Test_get(){
        String res = urController.Compact(example).get();
        //assertEquals("example", urModel.Get(res));
    }

    @Test
    void Test_eraser(){
        Persistence.Delete(example);
        assertEquals("", Persistence.Out(example));
    }
}
