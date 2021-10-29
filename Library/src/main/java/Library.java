import java.io.*;
import java.util.LinkedHashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Library
{
    private LinkedHashMap<String,String> dictionary;
    private BufferedReader in;
    private BufferedWriter out;
    private String path;
    public Library(String fileName,InputStreamReader user) throws IOException {
        dictionary = new LinkedHashMap<>();
        path = fileName;
        try
        {
            in = new BufferedReader(new InputStreamReader(new FileInputStream(path)));
            out = new BufferedWriter(new FileWriter(path,true));

            readPairs();
            showDictionary();
            addPair("fds","аыв");
            addPair("fds","1234");
            addPair("123","авм");
            addPair("","");
            showDictionary();

        }
        catch(FileNotFoundException e)
        {
            System.out.println("Файл с таким именем не найден.");
        }
        catch(IOException e)
        {
            System.out.println("Ошибка чтения фаила.");
        }
        finally {
            in.close();
            out.close();
        }
    }

    public void readPairs()
    {
        String[] tempRead = new String[2];
        try{
            while (in.ready())
            {
                tempRead = in.readLine().split("-");
                dictionary.put(tempRead[0],tempRead[1]);
            }
        }
        catch(IOException e)
        {
            System.out.println("Ошибка чтения фаила.");
        }
    }

    public void deletePair(String key)
    {
        dictionary.remove(key);
        try
        {
            for(String elemKey : dictionary.keySet())
            {
                out.write(elemKey+"-"+dictionary.get(elemKey));
            }
        }
        catch(IOException e)
        {
            System.out.println("Ошибка чтения фаила.");
        }
    }

    public void searchPair(String key)
    {
        try
        {
            String result = dictionary.get(key);
            if(!result.equals("null")) System.out.println(result);
        }
        catch (NullPointerException e)
        {
            System.out.println("Пара отсутсвует в словаре.");
        }

    }

    public void addPair(String key, String value)
    {
        Pattern patternKey = Pattern.compile("[A-Za-z]");
        Pattern patternValue = Pattern.compile("[А-Яа-я]");
        Matcher matcherKey = patternKey.matcher(key);
        Matcher matcherValue = patternValue.matcher(value);

        if( matcherKey.matches() && matcherValue.matches() )
        {
            dictionary.put(key,value);
            try
            {
                    out.write(key+"-"+value);
            }
            catch(IOException e)
            {
                System.out.println("Ошибка чтения фаила.");
            }
        }
        else  if( !matcherKey.matches() ) System.out.println("Неправильный формат ключа.");
        else if( !matcherValue.matches() ) System.out.println("Неправильный формат значения.");
        else if(!matcherKey.matches() && !matcherValue.matches()) System.out.println("Неправильный формат ключа и значения.");

    }

    public void showDictionary()
    {
       System.out.print(dictionary.keySet()+"\n");
       System.out.print(dictionary.values()+"\n");
    }
// BufferedWriter out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(fileName)));
}
