import java.io.*;
import java.util.LinkedHashMap;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Library
{
    private Scanner console = new Scanner(System.in);
    private LinkedHashMap<String,String> dictionary;
    private BufferedReader in;
    private BufferedWriter out;
    private String path;
    String[] tempRead = new String[2];
    public Library(String fileName, int typeDictionary) throws IOException {
        dictionary = new LinkedHashMap<>();
        path = fileName;
        try
        {
            in = new BufferedReader(new InputStreamReader(new FileInputStream(path)));
            out = new BufferedWriter(new FileWriter(path,true));
            readPairs();
            boolean flagWork = true;
            int consoleSelect = 0;
            String tempKey;
            String tempValue;


            while (flagWork)
            {
                System.out.print("Что вы хотите:\n1.Показать содерижмое соваря\n2.Добавить запись\n3.Удалить запись\n4.Пойск записи по ключу\n" +
                        "5.Закончить работу с этим словарем\nВаш выбор:");
                if(console.hasNextInt())
                {
                    consoleSelect = console.nextInt();
                }

                switch (consoleSelect)
                {
                    case 1:{showDictionary();break;}
                    case 2:
                    {
                        System.out.print("Введите ключ:");
                        tempKey = console.next();
                        System.out.print("Введите значение:");
                        tempValue = console.next();

                        if(typeDictionary==1)
                        {
                            Pattern patternKeyOne = Pattern.compile("[A-Za-z]{4}");
                            Matcher matcherKeyOne = patternKeyOne.matcher(tempKey);
                            Pattern patternValueOne = Pattern.compile("[а-яёА-ЯЁ]{4}");
                            Matcher matcherValueOne = patternValueOne.matcher(tempValue);
                            addPair(tempKey,tempValue,matcherKeyOne,matcherValueOne);
                        }
                        else if(typeDictionary == 2)
                        {
                            Pattern patternKeyTwo = Pattern.compile("[0-9]{5}");
                            Matcher matcherKeyTwo = patternKeyTwo.matcher(tempKey);
                            Pattern patternValueTwo = Pattern.compile("[а-яёА-ЯЁ]{5}");
                            Matcher matcherValueTwo = patternValueTwo.matcher(tempValue);
                            addPair(tempKey,tempValue,matcherKeyTwo,matcherValueTwo);
                        }
                        break;
                    }
                    case 3:
                    {
                        System.out.print("Введите ключ:");
                        tempKey = console.next();
                        deletePair(tempKey);
                        break;
                    }
                    case 4:
                    {
                        System.out.print("Введите ключ:");
                        tempKey = console.next();
                        searchPair(tempKey);
                        break;
                    }
                    case 5:{flagWork = false;break;}
                    default:{System.out.println("Такого варианта ответа не предусмотрено.\nПожалуйста повторите попытку ввода.");break;}
                }

            }

        }
        catch(FileNotFoundException e)
        {
            System.out.println("Файл с таким именем не найден.");
        }
        catch(IOException e)
        {
            System.out.println("Ошибка чтения фаила.");
        }
        catch(NullPointerException e)
        {
            System.out.println("Неправильное имя фаила.");
        }
        finally {
            in.close();
            out.close();
        }
    }

    public void readPairs()
    {
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


    public void deletePair(String key) throws IOException {
        dictionary.remove(key);
        try
        {
            for(String elemKey : dictionary.keySet())
            {
                if(elemKey.equals(key))
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

    public void addPair(String key, String value, Matcher matcherKey, Matcher matcherValue)
    {

        if( matcherKey.matches() && matcherValue.matches() )
        {
            dictionary.put(key,value);
            try
            {
                    out.write("\n"+key+"-"+value);
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

    public void showDictionary()
    {
       System.out.print(dictionary.keySet()+"\n");
       System.out.print(dictionary.values()+"\n");
    }

}
