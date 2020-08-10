package firstQuestion;

import java.util.Calendar;

public class Trial {
	public static void main(String[] args) {
		Calendar calendar = Calendar.getInstance();
		int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
		System.out.println(dayOfWeek);
	}
}
