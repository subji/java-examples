import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class CalculateWeekOfMonth {

  public static void main(String[] args) {

    System.out.println(getWeekOfMonth(2020, 3, 1));
    
  }

  private static String getWeekOfMonth(int year, int month, int day) {
    Calendar calendar = Calendar.getInstance(Locale.KOREA);
    calendar.setFirstDayOfWeek(Calendar.MONDAY);
    calendar.set(year, month - 1, day);
    calendar.set(Calendar.DAY_OF_MONTH, 1);

    int dayOfWeekForFirstDayOfMonth = calendar.get(Calendar.DAY_OF_WEEK);
    int subValue = 0;

    if (dayOfWeekForFirstDayOfMonth > 5)  {
      subValue = 1;
    } else if (dayOfWeekForFirstDayOfMonth == 1)  {
      subValue = 1;
    } 
    
    calendar.set(year, month - 1, day);

    int newWeekOfMonth = (calendar.get(Calendar.WEEK_OF_MONTH) - subValue);

    if (newWeekOfMonth < 1) {
      calendar.add(Calendar.DATE, -1 * Math.abs(Calendar.THURSDAY - calendar.get(Calendar.DAY_OF_WEEK)));
      return getWeekOfMonth(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH) + 1, calendar.get(Calendar.DATE));
    } else {
      return (calendar.get(Calendar.MONTH) + 1) + "," + newWeekOfMonth;
    }
  }
}