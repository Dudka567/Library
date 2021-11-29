package res.main.javaFiles; 
import java.io.IOException;
import java.util.Scanner;

public class ConsoleApp
{
    private boolean exitMainMenu = false;
    private boolean exitLibraryMenu = false;
    private int userSelect = 0;
    private FileManager manager;
    private Scanner user = new Scanner(System.in);

    public void work() throws IOException
    {
        while (!exitMainMenu)
        {

            System.out.print("С каким типом словаря вы хотите работать?\n1.Язык латинских букв\n2.Язык цифр\n3.Закрыть приложение\nВведите цифру соответствующую вашему выбору:");
            try {
                userSelect = Integer.valueOf(user.next());

                switch (userSelect) {
                    case 1: {
                        manager = new FileManager(new LibraryClassTypeOne(1,null));
                        workWithLibrary(new LibraryClassTypeOne(1, manager.searchLibrary()));break;// вызывается интерфейс работы со словарем
                    }                                                                                    // и идет поиск обьекта словаря нужного типа
                    case 2: {                                                                            // после, результат поиска - файл, передается в функцию работы со словарем
                        manager = new FileManager(new LibraryClassTypeTwo(2,null));  // (Файл - только что созданный, или уже существоваший)
                        workWithLibrary(new LibraryClassTypeOne(2, manager.searchLibrary()));break;
                    }
                    case 3: {
                        exitMainMenu = true;
                        break;
                    }
                    default: {
                        System.out.println("Такого варианта ответа не предусмотрено.\nПожалуйста повторите попытку ввода.");
                        break;
                    }
                }
            } catch (NumberFormatException e) {
                System.out.println("Неверный тип данных.");
            } catch (NullPointerException e) {
                System.out.println("Неправильное имя фаила.");
            }

        }
    }

        public void workWithLibrary(ILibrary library) throws IOException {
            while (!exitLibraryMenu) {

                System.out.print("Какую операцию со словарем вы хотите произвести?\n1.Показать содерижмое соваря\n2.Добавить запись\n3.Удалить запись\n4.Пойск записи по ключу\n" +
                        "5.Закончить работу с этим словарем\nВаш выбор:");
                try {
                    userSelect = Integer.valueOf(user.next());

                    switch (userSelect) {
                        case 1:
                        {
                            library.readPairs(true);break;
                        }
                        case 2:
                        {
                            System.out.print("Введите ключ:");
                            String tempKey = user.next();
                            System.out.print("Введите значение:");
                            String tempValue = user.next();
                            library.addPair(tempKey, tempValue);break;
                        }
                        case 3:
                        {
                            System.out.print("Введите ключ:");
                            String tempKey = user.next();
                            library.deletePair(tempKey);break;
                        }
                        case 4:
                        {
                            System.out.print("Введите ключ:");
                            String tempKey = user.next();
                            System.out.println(library.searchPair(tempKey));break;
                        }
                        case 5:
                        {
                            exitLibraryMenu = true;
                            break;
                        }
                        default:
                        {
                            System.out.println("Такого варианта ответа не предусмотрено.\nПожалуйста повторите попытку ввода.");
                            break;
                        }
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Неверный тип данных.");
                } catch (NullPointerException e) {
                    System.out.println("Неправильное имя фаила.");
                }


            }
            exitLibraryMenu = false;
        }
}
