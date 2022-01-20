package src.main.javaFiles; 

import java.io.IOException;
import java.util.LinkedHashMap;

public interface LibraryFactoryFunctionally {
  public LinkedHashMap<String, Library> createLibraries() throws IOException;
}
