package model;

import java.util.Map;

public interface Storage {
    void readStorage(Map<String, String> library);

    void writeStorage(Map<String, String> library);

    String searchStorage(String expectedNameFile);

}
