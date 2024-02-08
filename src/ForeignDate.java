public class ForeignDate
{
    private int date;
    private int month;
    private int year;

    public ForeignDate(int date, int month, int year)
    {
        switch (month)
        {
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                if (date > 31)
                {
                    date = 31;
                }
                break;
            case 2:
                if ((isLeap(year)) && (date > 29))
                {
                    date = 29;
                }
                if ((!isLeap(year)) && (date > 28))
                {
                    date = 28;
                }
                break;
            case 4:
            case 6:
            case 9:
            case 11:
                if (date > 30)
                {
                    date = 30;
                }
                break;
            default:
                month = 1;
                if (date > 31)
                {
                    date = 31;
                }
        }
        this.date = date;
        this.month = month;
        this.year = year;
    }

    public static boolean isLeap(int y)
    {
        return (((y % 4 == 0) && (y % 100 != 0)) || (y % 400 == 0));
    }

    public String toString()
    {
        String monthName, dayName;
        switch (this.month)
        {
            case 1:
                monthName = "January";
                break;
            case 2:
                monthName = "February";
                break;
            case 3:
                monthName = "March";
                break;
            case 4:
                monthName = "April";
                break;
            case 5:
                monthName = "May";
                break;
            case 6:
                monthName = "June";
                break;
            case 7:
                monthName = "July";
                break;
            case 8:
                monthName = "August";
                break;
            case 9:
                monthName = "September";
                break;
            case 10:
                monthName = "October";
                break;
            case 11:
                monthName = "November";
                break;
            case 12:
                monthName = "December";
                break;
            default:
                monthName = "";
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

    public HebrewDate toHebrewDate()
    {
        ForeignDate fini = new ForeignDate(1, 1, 1970);
        HebrewDate hini = new HebrewDate(23, "Tevet", 5730);
        while (!this.equals(fini))
        {
            if (this.isAfter(fini))
            {
                hini.dayForward();
                fini.dayForward();
            }
            else
            {
                hini.dayBackward();
                fini.dayBackward();
            }
        }
        return hini;
    }

    public int weekDay()
    {
        ForeignDate fini = new ForeignDate(1, 1, 1970);
        int day = 4;
        while (!this.equals(fini))
        {
            if (this.isAfter(fini))
            {
                fini.dayForward();
                day++;
            }
            else
            {
                fini.dayBackward();
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
        switch (this.month)
        {
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                return 31;
            case 2:
                if (isLeap(this.year))
                {
                    return 29;
                }
                return 28;
            case 4:
            case 6:
            case 9:
            case 11:
                return 30;
        }
        return 31;
    }

    public void dayForward()
    {
        if (this.date == monthLength())
        {
            if (this.month == 12)
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
                this.month = 12;
                this.date = 31;
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

    public boolean isAfter(ForeignDate d)
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

    public boolean equals(ForeignDate d)
    {
        return ((this.date == d.date) && (this.month == d.month) && (this.year == d.year));
    }

    public boolean isDateAfter(ForeignDate d)
    {
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

    public boolean dateEquals(ForeignDate d)
    {
        return ((this.date == d.date) && (this.month == d.month));
    }
}