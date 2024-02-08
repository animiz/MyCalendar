public class HebrewDate
{
    private int date;
    private int month;
    private int year;

    public HebrewDate(int date, String month, int year)
    {
        int monthNumber;
        if (isLeap(year))
        {
            switch (month)
            {
                case "Tishrei":
                    monthNumber = 1;
                    break;
                case "Heshvan":
                    monthNumber = 2;
                    break;
                case "Kislev":
                    monthNumber = 3;
                    break;
                case "Tevet":
                    monthNumber = 4;
                    break;
                case "Shvat":
                    monthNumber = 5;
                    break;
                case "Adar":
                case "Adar B":
                    monthNumber = 7;
                    break;
                case "Adar A":
                    monthNumber = 6;
                    break;
                case "Nisan":
                    monthNumber = 8;
                    break;
                case "Iyar":
                    monthNumber = 9;
                    break;
                case "Sivan":
                    monthNumber = 10;
                    break;
                case "Tamuz":
                    monthNumber = 11;
                    break;
                case "Av":
                    monthNumber = 12;
                    break;
                case "Elul":
                    monthNumber = 13;
                    break;
                default:
                    monthNumber = 1;
                    break;
            }
        }
        else
        {
            switch (month)
            {
                case "Tishrei":
                    monthNumber = 1;
                    break;
                case "Heshvan":
                    monthNumber = 2;
                    break;
                case "Kislev":
                    monthNumber = 3;
                    break;
                case "Tevet":
                    monthNumber = 4;
                    break;
                case "Shvat":
                    monthNumber = 5;
                    break;
                case "Adar":
                case "Adar A":
                case "Adar B":
                    monthNumber = 6;
                    break;
                case "Nisan":
                    monthNumber = 7;
                    break;
                case "Iyar":
                    monthNumber = 8;
                    break;
                case "Sivan":
                    monthNumber = 9;
                    break;
                case "Tamuz":
                    monthNumber = 10;
                    break;
                case "Av":
                    monthNumber = 11;
                    break;
                case "Elul":
                    monthNumber = 12;
                    break;
                default:
                    monthNumber = 1;
                    break;
            }
        }
        this.month = monthNumber;
        this.year = year;
        if (date > monthLength())
            date = monthLength();
        this.date = date;
    }

    public static boolean isLeap(int y)
    {
        int check = y % 19;
        switch (check)
        {
            case 0:
            case 3:
            case 6:
            case 8:
            case 11:
            case 14:
            case 17:
                return true;
        }
        return false;
    }

    public static int newYearDay(int y)
    {
        double my = 29 + ((double) 13753 / 25920);
        double mt = 2 + ((double) 134496 / 622080);
        double gtrd = (double) 238176 / 622080;
        double tkpt = (double) 402936 / 622080;
        int mnum = (235 * (y - 1) + 1) / 19;
        double molad = (mnum * my + mt) % 7;
        int nyday = (int) molad;
        if (molad - nyday > 0.75)
        {
            nyday++;
        }
        else if ((!isLeap(y)) && (nyday == 3) && (molad - nyday > gtrd))
        {
            nyday++;
        }
        else if ((isLeap(y - 1)) && (nyday == 2) && (molad - nyday > tkpt))
        {
            nyday++;
        }
        switch (nyday)
        {
            case 1:
            case 4:
            case 6:
                nyday++;
                break;
        }
        if (nyday == 7)
        {
            nyday = 0;
        }
        return nyday;
    }

    public static int yearType(int y)
    {
        int day1 = newYearDay(y);
        int day2 = newYearDay(y + 1);
        int dif = day2 - day1;
        if (dif < 0)
        {
            dif += 7;
        }
        if (isLeap(y))
        {
            switch (dif)
            {
                case 5:
                    return 1;
                case 6:
                    return 2;
                case 0:
                    return 3;
            }
        }
        else
        {
            switch (dif)
            {
                case 3:
                    return 1;
                case 4:
                    return 2;
                case 5:
                    return 3;
            }
        }
        return 0;
    }

    public String toString()
    {
        String monthName, dayName;
        if (isLeap(this.year))
        {
            switch (this.month)
            {
                case 1:
                    monthName = "Tishrei";
                    break;
                case 2:
                    monthName = "Heshvan";
                    break;
                case 3:
                    monthName = "Kislev";
                    break;
                case 4:
                    monthName = "Tevet";
                    break;
                case 5:
                    monthName = "Shvat";
                    break;
                case 6:
                    monthName = "Adar A";
                    break;
                case 7:
                    monthName = "Adar B";
                    break;
                case 8:
                    monthName = "Nisan";
                    break;
                case 9:
                    monthName = "Iyar";
                    break;
                case 10:
                    monthName = "Sivan";
                    break;
                case 11:
                    monthName = "Tamuz";
                    break;
                case 12:
                    monthName = "Av";
                    break;
                case 13:
                    monthName = "Elul";
                    break;
                default:
                    monthName = "";
            }
        }
        else
        {
            switch (this.month)
            {
                case 1:
                    monthName = "Tishrei";
                    break;
                case 2:
                    monthName = "Heshvan";
                    break;
                case 3:
                    monthName = "Kislev";
                    break;
                case 4:
                    monthName = "Tevet";
                    break;
                case 5:
                    monthName = "Shvat";
                    break;
                case 6:
                    monthName = "Adar";
                    break;
                case 7:
                    monthName = "Nisan";
                    break;
                case 8:
                    monthName = "Iyar";
                    break;
                case 9:
                    monthName = "Sivan";
                    break;
                case 10:
                    monthName = "Tamuz";
                    break;
                case 11:
                    monthName = "Av";
                    break;
                case 12:
                    monthName = "Elul";
                    break;
                default:
                    monthName = "";
            }
        }
        switch (this.weekDay())
        {
            case 0:
                dayName = "Sunday";
                break;
            case 1:
                dayName = "Monday";
                break;
            case 2:
                dayName = "Tuesday";
                break;
            case 3:
                dayName = "Wednesday";
                break;
            case 4:
                dayName = "Thursday";
                break;
            case 5:
                dayName = "Friday";
                break;
            case 6:
                dayName = "Saturday";
                break;
            default:
                dayName = "";
        }
        return dayName + ", " + this.date + " of " + monthName + " " + this.year;
    }

    public ForeignDate toForeignDate()
    {
        ForeignDate fini = new ForeignDate(1, 1, 1970);
        HebrewDate hini = new HebrewDate(23, "Tevet", 5730);
        while (!this.equals(hini))
        {
            if (this.isAfter(hini))
            {
                fini.dayForward();
                hini.dayForward();
            }
            else
            {
                fini.dayBackward();
                hini.dayBackward();
            }
        }
        return fini;
    }

    public int weekDay()
    {
        HebrewDate hini = new HebrewDate(23, "Tevet", 5730);
        int day = 4;
        while (!this.equals(hini))
        {
            if (this.isAfter(hini))
            {
                hini.dayForward();
                day++;
            }
            else
            {
                hini.dayBackward();
                day--;
            }
        }
        day %= 7;
        if (day < 0)
        {
            day += 7;
        }
        return day;
    }

    public int monthLength()
    {
        if (isLeap(this.year))
        {
            switch (this.month)
            {
                case 1:
                case 5:
                case 6:
                case 8:
                case 10:
                case 12:
                    return 30;
                case 4:
                case 7:
                case 9:
                case 11:
                case 13:
                    return 29;
                case 2:
                    if (yearType(this.year) == 3)
                    {
                        return 30;
                    }
                    else
                    {
                        return 29;
                    }
                case 3:
                    if (yearType(this.year) == 1)
                    {
                        return 29;
                    }
                    else
                    {
                        return 30;
                    }
            }
        }
        else
        {
            switch (this.month)
            {
                case 1:
                case 5:
                case 7:
                case 9:
                case 11:
                    return 30;
                case 4:
                case 6:
                case 8:
                case 10:
                case 12:
                    return 29;
                case 2:
                    if (yearType(this.year) == 3)
                    {
                        return 30;
                    }
                    else
                    {
                        return 29;
                    }
                case 3:
                    if (yearType(this.year) == 1)
                    {
                        return 29;
                    }
                    else
                    {
                        return 30;
                    }
            }
        }
        return 29;
    }

    public void dayForward()
    {
        if (this.date == monthLength())
        {
            if (((isLeap(this.year)) && (this.month == 13)) || ((!isLeap(this.year)) && (this.month == 12)))
            {
                this.year++;
                this.month = 1;
            }
            else
            {
                this.month++;
            }
            this.date = 1;
        }
        else
        {
            this.date++;
        }
    }

    public void dayBackward()
    {
        if (this.date == 1)
        {
            if (this.month == 1)
            {
                this.year--;
                if (isLeap(this.year))
                {
                    this.month = 13;
                }
                else
                {
                    this.month = 12;
                }
                this.date = 29;
            }
            else
            {
                this.month--;
                this.date = monthLength();
            }
        }
        else
        {
            this.date--;
        }
    }

    public boolean isAfter(HebrewDate d)
    {
        if (this.year > d.year)
        {
            return true;
        }
        if (this.year < d.year)
        {
            return false;
        }
        if (this.month > d.month)
        {
            return true;
        }
        if (this.month < d.month)
        {
            return false;
        }
        return this.date > d.date;
    }

    public boolean equals(HebrewDate d)
    {
        return ((this.date == d.date) && (this.month == d.month) && (this.year == d.year));
    }
}