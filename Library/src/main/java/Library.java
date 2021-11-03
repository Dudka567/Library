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

    private Scanner console = new Scanner(System.in);
    private LinkedHashMap<String,String> dictionary;
    private BufferedReader in;
    private BufferedWriter out;
    private FileInputStream disc;
    private String path;
    String[] tempRead = new String[2];
    public Library(String fileName, int typeDictionary) throws IOException {
        dictionary = new LinkedHashMap<>();
        path = fileName;
        try
        {
            disc = new FileInputStream(path);
            in = new BufferedReader(new InputStreamReader(disc));
            boolean flagWork = true;
            int consoleSelect = 0;
            String tempKey;
            String tempValue;


            while (flagWork)
            {
                System.out.print("Что вы хотите:\n1.Показать содерижмое соваря\n2.Добавить запись\n3.Удалить запись\n4.Пойск записи по ключу\n" +
                        "5.Закончить работу с этим словарем\nВаш выбор:");

                    consoleSelect = Integer.valueOf(console.next());


                switch (consoleSelect)
                {
                    case 1:{readPairs(typeDictionary);break;}
                    case 2:
                    {
                        System.out.print("Введите ключ:");
                        tempKey = console.next();
                        System.out.print("Введите значение:");
                        tempValue = console.next();

                        if(typeDictionary==1)
                        {
                            matcherKeyOne = patternKeyOne.matcher(tempKey);
                            matcherValueOne = patternValueOne.matcher(tempValue);
                            addPair(tempKey,tempValue,matcherKeyOne,matcherValueOne);
                        }
                        else if(typeDictionary == 2)
                        {
                            matcherKeyTwo = patternKeyTwo.matcher(tempKey);
                            matcherValueTwo = patternValueTwo.matcher(tempValue);
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

    public void readPairs(int typeDictionary)
    {

        try{
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
                    System.out.println("Ключ:" + tempRead[0] + " Значение:" + tempRead[1]);
                }
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

    public void searchPair(String key)
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
                {System.out.println("Значение:"+tempRead[1]);break;}
            }

        }
        catch (NullPointerException | IOException e)
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
