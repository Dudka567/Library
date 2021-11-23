import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.util.LinkedHashMap;

public class LibraryTest {



    @Test
    public void testReadPairs1() throws IOException
    {
        Library testLibrary = new Library("src/main/resources/map.txt", 1);
        LinkedHashMap<String,String> expected = new LinkedHashMap<>();
        expected.put("aris","подн");
        expected.put("awak","проб");
        expected.put("befd","быть");
        expected.put("bear","пере");
        expected.put("beat","бить");
        expected.put("beco","стан");
        expected.put("begi","начи");
        expected.put("bend","накл");
        expected.put("beth","закл");
        expected.put("bind","связ");
        expected.put("bite","куса");
        expected.put("blee","кров");
        expected.put("blow","дуть");
        expected.put("brea","лома");
        expected.put("bree","разв");
        expected.put("brin","прин");
        expected.put("buil","стро");
        expected.put("buys","поку");
        expected.put("catc","лови");
        expected.put("test","лонг");
        testLibrary.readPairs(false);
        Assert.assertEquals(expected, testLibrary.getDictionary());
    }

    @Test
    public void testReadPairs2() throws IOException
    {
        Library testLibrary = new Library("src/main/resources/map1.txt", 2);
        LinkedHashMap<String,String> expected = new LinkedHashMap<>();
        expected.put("23131","авыва");
        expected.put("12445","авыви");
        expected.put("64653","имсрн");
        expected.put("76545","опааи");
        expected.put("23473","ьипап");
        expected.put("75475","апрап");
        expected.put("25266","ашввв");
        testLibrary.readPairs(false);
        Assert.assertEquals(expected, testLibrary.getDictionary());
    }

    @Test
    public void testReadPairs3() throws IOException
    {
        Library testLibrary = new Library("src/main/resources/map1.txt", 1);
        LinkedHashMap<String,String> expected = new LinkedHashMap<>();
        testLibrary.readPairs(false);
        Assert.assertEquals(expected, testLibrary.getDictionary());
    }

    @Test
    public void testReadPairs4() throws IOException
    {
        Library testLibrary = new Library("src/main/resources/map.txt", 2);
        LinkedHashMap<String,String> expected = new LinkedHashMap<>();
        testLibrary.readPairs(false);
        Assert.assertEquals(expected, testLibrary.getDictionary());
    }

    @Test
    public void testReadPairs5() throws IOException
    {
        Library testLibrary = new Library("src/main/resources/map1Test.txt", 2);
        LinkedHashMap<String,String> expected = new LinkedHashMap<>();
        expected.put("23131","авыва");
        expected.put("12445","авыви");
        expected.put("64653","имсрн");
        expected.put("76545","опааи");
        expected.put("23473","ьипап");
        expected.put("75475","апрап");
        expected.put("25266","ашввв");
        testLibrary.readPairs(false);
        Assert.assertEquals(expected, testLibrary.getDictionary());
    }


    @Test
    public void testSearchPair1() throws IOException
    {
        Library testLibrary = new Library("src/main/resources/map.txt", 1);
        String actual = testLibrary.searchPair("beco");
        String expected = "стан";
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void testSearchPair2() throws IOException
    {
        Library testLibrary = new Library("src/main/resources/map.txt", 1);
        String actual = testLibrary.searchPair("becoм");
        String expected = "Пара отсутствует в словаре.";
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void testAddPair1() throws IOException
    {
        Library testLibrary = new Library("src/main/resources/mapTest.txt", 1);
        LinkedHashMap<String,String> expected = new LinkedHashMap<>();
        expected.put("aris","подн");
        expected.put("awak","проб");
        expected.put("befd","быть");
        expected.put("bear","пере");
        expected.put("beat","бить");
        expected.put("beco","стан");
        expected.put("begi","начи");
        expected.put("bend","накл");
        expected.put("beth","закл");
        expected.put("bind","связ");
        expected.put("bite","куса");
        expected.put("blee","кров");
        expected.put("blow","дуть");
        expected.put("brea","лома");
        expected.put("bree","разв");
        expected.put("brin","прин");
        expected.put("buil","стро");
        expected.put("buys","поку");
        expected.put("catc","лови");
        expected.put("test","лонг");
        expected.put("inpu","инпу");
        testLibrary.addPair("inpu","инпу");
        Assert.assertEquals(expected,testLibrary.getDictionary());
    }

    @Test
    public void testAddPair2() throws IOException
    {
        Library testLibrary = new Library("src/main/resources/map1Test.txt", 2);
        LinkedHashMap<String,String> expected = new LinkedHashMap<>();
        expected.put("23131","авыва");
        expected.put("12445","авыви");
        expected.put("64653","имсрн");
        expected.put("76545","опааи");
        expected.put("23473","ьипап");
        expected.put("75475","апрап");
        expected.put("25266","ашввв");
        testLibrary.addPair("2411","инпу");
        Assert.assertEquals(expected,testLibrary.getDictionary());
    }

    @Test
    public void testAddPair3() throws IOException
    {
        Library testLibrary = new Library("src/main/resources/map1Test.txt", 2);
        LinkedHashMap<String,String> expected = new LinkedHashMap<>();
        expected.put("23131","авыва");
        expected.put("12445","авыви");
        expected.put("64653","имсрн");
        expected.put("76545","опааи");
        expected.put("23473","ьипап");
        expected.put("75475","апрап");
        expected.put("25266","ашввв");
        testLibrary.addPair("asce","инпу");
        Assert.assertEquals(expected,testLibrary.getDictionary());
    }

    @Test
    public void testDeletePair1() throws IOException
    {
        Library testLibrary = new Library("src/main/resources/mapTest.txt", 1);
        LinkedHashMap<String,String> expected = new LinkedHashMap<>();
        expected.put("aris","подн");
        expected.put("awak","проб");
        expected.put("befd","быть");
        expected.put("bear","пере");
        expected.put("beat","бить");
        expected.put("beco","стан");
        expected.put("begi","начи");
        expected.put("bend","накл");
        expected.put("beth","закл");
        expected.put("bind","связ");
        expected.put("bite","куса");
        expected.put("blee","кров");
        expected.put("blow","дуть");
        expected.put("brea","лома");
        expected.put("bree","разв");
        expected.put("brin","прин");
        expected.put("buil","стро");
        expected.put("buys","поку");
        expected.put("catc","лови");
        expected.put("test","лонг");
        testLibrary.deletePair("inpu");
        Assert.assertEquals(expected,testLibrary.getDictionary());
    }

}
