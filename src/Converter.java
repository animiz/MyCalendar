import java.util.*;

public class Converter
{
    static Scanner reader = new Scanner(System.in);

    public static void main(String[] args)
    {
        System.out.println("For foreign to hebrew type 1, for hebrew to foreign type 2");
        int choice = reader.nextInt();
        if (choice == 1)
        {
            System.out.println("Enter foreign date");
            ForeignDate fd = new ForeignDate(reader.nextInt(), reader.nextInt(), reader.nextInt());
            System.out.println(fd.toHebrewDate());
        }
        if (choice == 2)
        {
            System.out.println("Enter hebrew date");
            int date = reader.nextInt();
            reader.nextLine();
            String month = reader.nextLine();
            int year = reader.nextInt();
            HebrewDate hd = new HebrewDate(date, month, year);
            System.out.println(hd.toForeignDate());
        }
    }
}
