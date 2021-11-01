import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;


public class Main
{
    public static void main(String[] args) throws IOException
    {
        boolean exit = false;
        String fileName;
        int userSelect = 0;
        Scanner user = new Scanner(System.in);

        while (!exit)
        {

            System.out.print("С каким типом словаря вы хотите работать?\n1.Язык латинских букв\n2.Язык цифр\n3.Закрыть приложение\nВведите цифру соответствующую вашему выбору:");
            try
            {

                if(user.hasNextInt())
                {
                    userSelect = user.nextInt();
                }

                switch (userSelect)
                {
                    case 1:
                    {
                        System.out.print("Введите название файла, содержащий латинские буквы:");
                        fileName = "src/main/resources/"+user.next();
                        Library library1 = new Library(fileName, userSelect);
                        break;
                    }
                    case 2:
                    {
                        System.out.print("Введите название файла, содержащий цифры:");
                        fileName = "src/main/resources/"+user.next();
                        Library library2 = new Library(fileName, userSelect);
                        break;
                    }
                    case 3:
                    {
                        exit = true;
                        break;
                    }
                    default:
                    {
                        System.out.println("Такого варианта ответа не предусмотрено.\nПожалуйста повторите попытку ввода.");
                        break;
                    }
                }
            }
            catch (InputMismatchException e)
            {
                System.out.println("Неверный тип данных.");
            }
            catch(NullPointerException e)
            {
                System.out.println("Неправильное имя фаила.");
            }


        }
    }
}
