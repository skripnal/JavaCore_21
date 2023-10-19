package task;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.lang.reflect.Field;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;

public class Application {

	public static void main(String[] args) {
		
		getAnnotation(Human.class);
		writeAnnotation(Human.class, "123.txt");
		System.out.println("----------------------------------");
		DateConverter dc = new DateConverter();
		Date date = new Date();
		LocalDate localDate = dc.dateToLocalDate(date);
		LocalTime localTime = dc.dateToLocalTime(date);
		LocalDateTime localDateTime = dc.dateToLocalDateTime(date);
		
		System.out.println("Date = " + date);
		System.out.println("LocalDate = " + localDate);
		System.out.println("LocalTime = " + localTime);
		System.out.println("LocalDateTime = " + localDateTime);
	}

	public static void getAnnotation(Class<?> customClass) {
		Field[] fields = customClass.getDeclaredFields();
		
		for (int i = 0; i < fields.length; i++) {
			Field field = fields[i];
			
			if(field.getAnnotation(myAnotation.class) instanceof myAnotation) {
				System.out.print(field.getName() + " --- ");
				System.out.println("value = " + field.getAnnotation(myAnotation.class).params());
			}
		}
	}
	
	public static void writeAnnotation(Class<?> customClass, String fileName) {
		Field[] fields = customClass.getDeclaredFields();
		BufferedWriter writer;
		try {
			writer = new BufferedWriter(new FileWriter(fileName));
			for (int i = 0; i < fields.length; i++) {
				Field field = fields[i];
				if(field.getAnnotation(myAnotation.class) instanceof myAnotation) {
						writer.write(field.getName() + " --- " + "value = " + field.getAnnotation(myAnotation.class).params());
						writer.newLine();
				}
			}
			writer.close();
		} catch (IOException e) { 
			e.printStackTrace();
		}	
	}
	
}
