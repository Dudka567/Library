package src.main.java.model;

import lombok.NonNull;

import java.util.Map;

public interface Storage {
    void readStorage(@NonNull Map<String, String> library);

    void writeStorage(@NonNull Map<String, String> library);

    String searchStorage(String expectedNameFile);

}
