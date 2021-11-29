package res.main.javaFiles; 
import java.io.File;
import java.util.regex.Pattern;

public class TestLibraryClassTypeThird extends LibraryClass
{
    public TestLibraryClassTypeThird(int argTypeLibrary, File argFileDir) {
        super(argTypeLibrary, argFileDir);
    }

    @Override
    void setPatterns() {
        patternKey = Pattern.compile("[A]{4}");
        patternValue = Pattern.compile("[Ё]{4}");;
    }
}
