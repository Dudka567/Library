package res.main.javaFiles; 
import java.io.*;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FileManager {
    protected ILibrary library;
    protected String[] tempRead = new String[2];
    protected Matcher matcherKey;
    protected Matcher matcherValue;
    protected Pattern patternKey;
    protected Pattern patternValue;

    public FileManager(ILibrary argLibrary) throws IOException {
        library = argLibrary;
        initPatterns();
    }

    public void initPatterns()
    {
        patternKey = library.getPatternKey();          // инициализация шаблонов для анализа фаилов
        patternValue = library.getPatternValue();
    }


    public boolean checkFile(File file) throws IOException
    {
        try
        {
            FileInputStream disc = new FileInputStream(file.getPath()); // создаем дискриптор на фаил и указываем позицию считывания в его начале
            disc.getChannel().position(0);
            BufferedReader in = new BufferedReader(new InputStreamReader(disc));

                tempRead = in.readLine().split("-"); // считываем строку
                matcherKey = patternKey.matcher(tempRead[0]);
                matcherValue = patternValue.matcher(tempRead[1]);
                if( matcherKey.matches() && matcherValue.matches()) // если строка соответсвует шаблонку конкретного словаря, то возвращаем true
                {
                    return true;
                }


        }
        catch(IOException e)
        {
            System.out.println("Ошибка чтения фаила.");
        }
            return false;
    }

    public File searchLibrary() throws IOException
    {

                File dir = new File("src/main/resources"); //path указывает на директорию
                ArrayList<File> listFilesInDirectory = new ArrayList<>();
                for (File file : dir.listFiles())
                {
                    if (file.isFile())
                        listFilesInDirectory.add(file); // идет поиск именно фаилов, а не директорий
                }

                for(File file : listFilesInDirectory)
                {
                    if(checkFile(file))
                    {
                        return file;  // возращаем ссылку на словарь, для работы с ним
                    }
                }
        File file = new File( "src/main/resources/TempFileLibraryType"+library.getTypeLibrary()+".txt"); // если словарь указанного типа не найден, создаем его
        FileWriter writer = new FileWriter (file);
        return file;
    }

}
