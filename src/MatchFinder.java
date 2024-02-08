import java.util.*;

class MatchFinder
{
    static Scanner reader = new Scanner(System.in);

    public static void main(String[] args)
    {
        System.out.println("Enter foreign date");
        int fdate = reader.nextInt();
        int fmonth = reader.nextInt();
        System.out.println("Enter hebrew date");
        int hdate = reader.nextInt();
        reader.nextLine();
        String hmonth = reader.nextLine();
        System.out.println("Enter year range");
        int start = reader.nextInt();
        int end = reader.nextInt();
        ForeignDate fd;
        HebrewDate hd1, hd2, hd3;
        for (int i = start; i < end +1 ; i++)
        {
            fd = new ForeignDate(fdate, fmonth, i);
            hd1 = new HebrewDate(hdate, hmonth, i + 3760);
            hd2 = new HebrewDate(hdate, hmonth, i + 3761);
            hd3 = fd.toHebrewDate();
            if ((hd3.equals(hd1)) || (hd3.equals(hd2)))
            {
                System.out.println(fd);
            }
        }
    }
}