package digital.quintino.gerguardapi.utility;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtility {
	
	private static final String FORMAT_DDMMYYY_HHMMSS = "dd/MM/YYYY HH:mm:ss";
	
	public static String formatarData(Date date) {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(FORMAT_DDMMYYY_HHMMSS);
		return simpleDateFormat.format(new Date());
	}

}
