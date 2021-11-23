import java.io.*;
import java.util.LinkedHashMap;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Library
{
    private Pattern patternKeyOne = Pattern.compile("[A-Za-z]{4}");;
    private Pattern patternValueOne = Pattern.compile("[а-яёА-ЯЁ]{4}");;
    private Pattern patternKeyTwo = Pattern.compile("[0-9]{5}");
    private Pattern patternValueTwo = Pattern.compile("[а-яёА-ЯЁ]{5}");

    private Matcher matcherKeyOne;
    private Matcher matcherValueOne;
    private Matcher matcherKeyTwo;
    private Matcher matcherValueTwo;
    private Matcher matcherKey;
    private Matcher matcherValue;

    private Scanner console = new Scanner(System.in);
    private LinkedHashMap<String,String> dictionary;
    private BufferedReader in;
    private BufferedWriter out;
    private FileInputStream disc;
    private String path;
    private String tempKey;
    private String tempValue;
    private String[] tempRead = new String[2];
    private boolean flagWork;
    private int consoleSelect;
    private int typeDictionary;
    public Library(String fileName, int typeDictionary) throws IOException
    {
        try
        {
            dictionary = new LinkedHashMap<>();
            path = fileName;
            this.typeDictionary = typeDictionary;
            disc = new FileInputStream(path);
            in = new BufferedReader(new InputStreamReader(disc));
            flagWork = true;
            consoleSelect = 0;
        }
        catch(IOException e)
        {
            System.out.println("Ошибка чтения фаила.");
        }
    }

    public void work() throws IOException {
        try
        {
        while (flagWork)
        {
            System.out.print("Что вы хотите:\n1.Показать содерижмое соваря\n2.Добавить запись\n3.Удалить запись\n4.Пойск записи по ключу\n" +
                    "5.Закончить работу с этим словарем\nВаш выбор:");

            consoleSelect = Integer.valueOf(console.next());


            switch (consoleSelect) {
                case 1: {
                    readPairs(true);
                    break;
                }
                case 2: {
                    System.out.print("Введите ключ:");
                    tempKey = console.next();
                    System.out.print("Введите значение:");
                    tempValue = console.next();
                    addPair(tempKey, tempValue);
                    break;
                    }
                case 3: {
                    System.out.print("Введите ключ:");
                    tempKey = console.next();
                    deletePair(tempKey);
                    break;
                }
                case 4: {
                    System.out.print("Введите ключ:");
                    tempKey = console.next();
                    System.out.println("Значение:"+searchPair(tempKey));
                    break;
                }
                case 5: {
                    flagWork = false;
                    break;
                }
                default: {
                    System.out.println("Такого варианта ответа не предусмотрено.\nПожалуйста повторите попытку ввода.");
                    break;
                }
            }
        }
        }
        catch (NumberFormatException e)
        {
            System.out.println("Неверный тип данных.");
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

    public LinkedHashMap<String, String> getDictionary() {
        return dictionary;
    }

    public void readPairs(boolean isVisible)
    {

        try{
            disc = new FileInputStream(path);
            disc.getChannel().position(0);
            in = new BufferedReader(new InputStreamReader(disc));
            while (in.ready())
            {
                    tempRead = in.readLine().split("-");
                Matcher matcherKey = null;
                Matcher matcherValue = null;
                if(typeDictionary==1)
                {
                    matcherKeyOne = patternKeyOne.matcher(tempRead[0]);
                    matcherValueOne = patternValueOne.matcher(tempRead[1]);
                    matcherKey = matcherKeyOne;
                    matcherValue = matcherValueOne;

                }
                else if(typeDictionary == 2)
                {
                    matcherKeyTwo = patternKeyTwo.matcher(tempRead[0]);
                    matcherValueTwo = patternValueTwo.matcher(tempRead[1]);
                    matcherKey = matcherKeyTwo;
                    matcherValue = matcherKeyTwo;
                }


                if( matcherKey.matches() && matcherValue.matches())
                {
                    dictionary.put(tempRead[0], tempRead[1]);
                    if(isVisible)
                    {System.out.println("Ключ:" + tempRead[0] + " Значение:" + tempRead[1]);}
                }
            }

        }
        catch(IOException e)
        {
            System.out.println("Ошибка чтения фаила.");
        }
    }


    public void deletePair(String key) throws IOException {
        readPairs(false);
        dictionary.remove(key);
        try
        {
            out = new BufferedWriter(new FileWriter(path));
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

    public String searchPair(String key)
    {
        try
        {
            disc.getChannel().position(0);
            in = new BufferedReader(new InputStreamReader(disc));
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

    public void addPair(String key, String value)
    {
        readPairs(false);
        if (typeDictionary == 1) {
            matcherKeyOne = patternKeyOne.matcher(key);
            matcherValueOne = patternValueOne.matcher(value);
            matcherKey = matcherKeyOne;
            matcherValue = matcherValueOne;
        } else if (typeDictionary == 2) {
            matcherKeyTwo = patternKeyTwo.matcher(key);
            matcherValueTwo = patternValueTwo.matcher(value);
            matcherKey = matcherKeyTwo;
            matcherValue = matcherValueTwo;
        }

        if( matcherKey.matches() && matcherValue.matches() )
        {
            dictionary.put(key,value);
            try
            {
                out = new BufferedWriter(new FileWriter(path));
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
