package res.main.javaFiles; 
import java.io.*;
import java.util.regex.Pattern;

public class LibraryClassTypeTwo extends LibraryClass implements ILibrary
{
    public LibraryClassTypeTwo(int argTypeLibrary, File argFileDir)
    {
        super(argTypeLibrary,argFileDir);
    }


    @Override
    void setPatterns()
    {
        patternKey = Pattern.compile("[0-9]{5}");
        patternValue = Pattern.compile("[а-яёА-ЯЁ]{5}");
    }


}
