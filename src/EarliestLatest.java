import java.util.*;
public class EarliestLatest
{
    static Scanner reader = new Scanner(System.in);
    public static void main (String[] args)
    {
        System.out.println("For earliest type 1, for latest type 2");
        int choice = reader.nextInt();
        ForeignDate el;
        System.out.println("Enter hebrew date");
        int date = reader.nextInt();
        reader.nextLine();
        String month = reader.nextLine();
        System.out.println("Enter year range");
        int start = reader.nextInt() + 3760;
        int end = reader.nextInt() + 3760;
        el = new HebrewDate(date, month, start).toForeignDate();
        if (choice == 1)
        {
            for (int i = start + 1; i < end + 1 ; i++)
            {
                HebrewDate hd = new HebrewDate(date, month, i);
                ForeignDate fd = hd.toForeignDate();
                if (!fd.isDateAfter(el))
                    el = fd;
            }
            System.out.println(el);
        }
        if (choice == 2)
        {
            for (int i = start + 1; i < end + 1 ; i++)
            {
                HebrewDate hd = new HebrewDate(date, month, i);
                ForeignDate fd = hd.toForeignDate();
                if (fd.isDateAfter(el))
                    el = fd;
            }
            System.out.println(el);
        }
    }
}
