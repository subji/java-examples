import java.text.SimpleDateFormat;
import java.util.Calendar;

public class CalculateWeekOfMonth {

  public static void main(String[] args) {

    SimpleDateFormat format = new SimpleDateFormat("yyyy.MM.dd");
    System.out.println("asdfasdf");
    Calendar c = Calendar.getInstance();
    c.set(2020, 7, 1);
    c.set(Calendar.DAY_OF_MONTH, 1);

    int dayOfWeekFirstDayOfMonth = c.get(Calendar.DAY_OF_WEEK);

    System.out.println(dayOfWeekFirstDayOfMonth);

    Calendar cal = Calendar.getInstance();
    cal.set(2020, 7, 1);

    int weekNumber = cal.get(Calendar.WEEK_OF_MONTH) - (dayOfWeekFirstDayOfMonth > 5 ? 1 : 0);

    if (weekNumber == 0)  {
      cal.add(Calendar.DATE, -1);
    }
    
    System.out.println(cal.get(Calendar.WEEK_OF_MONTH));
    System.out.println(format.format(cal.getTime()));
  }
}