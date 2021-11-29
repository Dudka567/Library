package res.main.javaFiles; 
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.regex.Pattern;

public interface ILibrary
{
    public Pattern getPatternKey();
    public Pattern getPatternValue();
    public LinkedHashMap<String,String> getDictionary();
    public int getTypeLibrary();

    public void readPairs(boolean isVisible) throws IOException;
    public void deletePair(String key);
    public String searchPair(String key);
    public void addPair(String key, String value);

}
