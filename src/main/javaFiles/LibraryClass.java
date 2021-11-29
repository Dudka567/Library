package res.main.javaFiles;
import java.io.*;
import java.util.LinkedHashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

abstract public class LibraryClass implements ILibrary
{
    FileInputStream disc;
    BufferedReader in;      // потоки для записи/чтения
    BufferedWriter out;

    protected int typeLibrary;
    protected File fileDir;
    protected LinkedHashMap<String,String> dictionary;
    protected Pattern patternKey;
    protected Pattern patternValue;


    public LibraryClass(int argTypeLibrary, File argFileDir)
    {
        typeLibrary = argTypeLibrary;
        fileDir = argFileDir;
        dictionary = new LinkedHashMap<>();
        setPatterns();
    }

    abstract void setPatterns();

    @Override
    public Pattern getPatternKey() {
        return patternKey;
    }

    @Override
    public Pattern getPatternValue() {
        return patternValue;
    }

    @Override
    public LinkedHashMap<String, String> getDictionary() {
        return dictionary;
    }

    @Override
    public int getTypeLibrary() {
        return typeLibrary;
    }




    @Override
    public void readPairs(boolean isVisible)
    {
        try
        {
            disc = new FileInputStream(fileDir);
            disc.getChannel().position(0);
            in = new BufferedReader(new InputStreamReader(disc));
            String[] tempRead = new String[2];

            while (in.ready())
            {
                tempRead = in.readLine().split("-");
                dictionary.put(tempRead[0], tempRead[1]);
                if(isVisible)
                {System.out.println("Ключ:" + tempRead[0] + " Значение:" + tempRead[1]);}
            }
        }
        catch(IOException e)
        {
            System.out.println("Ошибка чтения фаила.");
        }
    }

    @Override
    public void deletePair(String key)
    {
        readPairs(false);
        dictionary.remove(key);
        try
        {
            out = new BufferedWriter(new FileWriter(fileDir));
            for(String elemKey : dictionary.keySet())
            {
                out.write(elemKey+"-"+dictionary.get(elemKey)+"\n");
                out.flush();
            }
        }
        catch(IOException e)
        {
            System.out.println("Ошибка чтения фаила.");
        }
    }

    @Override
    public String searchPair(String key)
    {
        readPairs(false);
        try
        {
            disc.getChannel().position(0);
            in = new BufferedReader(new InputStreamReader(disc));
            String[] tempRead = new String[2];
            while (in.ready())
            {
                tempRead = in.readLine().split("-");
                dictionary.put(tempRead[0], tempRead[1]);
                if(!tempRead[0].equals("null")&&tempRead[0].equals(key))
                    return tempRead[1];
            }

        }
        catch (NullPointerException | IOException e)
        {
            System.out.println("Пара отсутсвует в словаре.");
        }
        return "Пара отсутствует в словаре.";
    }

    @Override
    public void addPair(String key, String value)
    {
        Matcher matcherKey = patternKey.matcher(key);
        Matcher matcherValue = patternValue.matcher(value);
        readPairs(false);

        if( matcherKey.matches() && matcherValue.matches() )
        {
            dictionary.put(key,value);
            try
            {
                out = new BufferedWriter(new FileWriter(fileDir));
                for(String elemKey : dictionary.keySet())
                {
                    out.write(elemKey+"-"+dictionary.get(elemKey)+"\n");
                    out.flush();
                }
            }
            catch(IOException e)
            {
                System.out.println("Ошибка чтения фаила.");
            }
        }
        else if(!matcherKey.matches() && !matcherValue.matches()) System.out.println("Неправильный формат ключа и значения.");
        else  if( !matcherKey.matches() ) System.out.println("Неправильный формат ключа.");
        else if( !matcherValue.matches() ) System.out.println("Неправильный формат значения.");
    }

}
