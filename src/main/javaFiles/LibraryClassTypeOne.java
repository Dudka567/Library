package res.main.javaFiles; 
import java.io.*;
import java.util.regex.Pattern;

public class LibraryClassTypeOne extends LibraryClass implements ILibrary
{
    public LibraryClassTypeOne(int argTypeLibrary, File argFileDir)
    {
        super(argTypeLibrary,argFileDir);
    }

    @Override
    void setPatterns()
    {
        patternKey = Pattern.compile("[A-Za-z]{4}");
        patternValue = Pattern.compile("[а-яёА-ЯЁ]{4}");;
    }

}
