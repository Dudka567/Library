package src.main.javaFiles;
import java.io.*;
import java.util.LinkedHashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Library
{
    public static final String ZERO = "null";
    public static final String REGEX_CHAR = ",";
    public static final String SPLIT_CHAR = "-";
    public static final String PAIR_MISSING = "The pair is missing from the dictionary.";
    public static final String INCORRECT_KEY_AND_VALUE_FORMAT = "Incorrect key and value format.";
    public static final String INCORRECT_KEY_FORMAT = "Incorrect key format.";
    public static final String INCORRECT_VALUE_FORMAT = "Incorrect value format.";
    public static final String PAIR_ADDED = "The pair has been added to the dictionary.";

    protected String nameLibrary;
    protected String typeLibrary;
    protected File fileDir;
    protected LinkedHashMap<String,String> dictionary;
    protected Pattern patternKey;
    protected Pattern patternValue;
    protected FileManager manager;

    public Library(String argTypeLibrary,String argNameLibrary, String key, String value, FileManager manager)
    {
        this.manager = manager;
        typeLibrary = argTypeLibrary;
        nameLibrary = argNameLibrary;
        dictionary = new LinkedHashMap<>();
        patternKey = Pattern.compile(key);
        patternValue = Pattern.compile(value);
    }


    public void setFileDir(File fileDir) {this.fileDir = fileDir;}

    public LinkedHashMap<String, String> getDictionary() {
        return dictionary;
    }

    public String getNameLibrary() {return nameLibrary;}


    public void readPairs() throws IOException {
        manager.readFile(this);
    }

    public void deletePair(String key) throws IOException {
        manager.readFile(this);
        dictionary.remove(key);
        manager.writeFile(this);
    }

    public String searchPair(String key) throws IOException {
        manager.readFile(this);
        if(!dictionary.get(key).equals(ZERO))
            return ConsoleApp.VALUE+dictionary.get(key);
        return PAIR_MISSING;
    }

    public String addPair(String key, String value) throws IOException
    {
        Matcher matcherKey = patternKey.matcher(key);
        Matcher matcherValue = patternValue.matcher(value);
        manager.readFile(this);

        if( matcherKey.matches() && matcherValue.matches() )
        {
            dictionary.put(key,value);
                manager.writeFile(this);

        }
        else if(!matcherKey.matches() && !matcherValue.matches()) return INCORRECT_KEY_AND_VALUE_FORMAT;
        else  if( !matcherKey.matches() ) return INCORRECT_KEY_FORMAT;
        else if( !matcherValue.matches() ) return INCORRECT_VALUE_FORMAT;

         return PAIR_ADDED;
    }

}
