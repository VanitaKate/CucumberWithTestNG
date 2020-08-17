package Utilities;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.testng.annotations.Test;
//import java.time.format.DateTimeFormatter;

public class DateTimeStamp {
	public String getTimeStamp() {
		LocalDateTime timestamp= LocalDateTime.now();
		return timestamp.toString();
	}
}
