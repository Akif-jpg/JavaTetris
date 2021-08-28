package bago.bLogging;

import java.util.Date;


public abstract class Logger {

	protected Class<?> class1;

	private static class LoggerSelf extends Logger{
		
	}
	public static Logger getLogger(Class<?> class1){
		LoggerSelf loggerSelf = new LoggerSelf();
		loggerSelf.class1 = class1;
		return loggerSelf;
	}
	private Date date = new Date();
	public void warn(String message) {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("[");
		stringBuilder.append(date.getHours());
		stringBuilder.append(":");
		stringBuilder.append(date.getMinutes());
		stringBuilder.append(" ");
		stringBuilder.append(class1.getName());
		stringBuilder.append("] Warn: ");
		stringBuilder.append(message);
		System.out.println(stringBuilder.toString());
	}
	public void error(String message) {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("[");
		stringBuilder.append(date.getHours());
		stringBuilder.append(":");
		stringBuilder.append(date.getMinutes());
		stringBuilder.append(" ");
		stringBuilder.append(class1.getName());
		stringBuilder.append("] Error: ");
		stringBuilder.append(message);
		System.err.println(stringBuilder.toString());
	}
	public void trace(String message) {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("[");
		stringBuilder.append(date.getHours());
		stringBuilder.append(":");
		stringBuilder.append(date.getMinutes());
		stringBuilder.append(" ");
		stringBuilder.append(class1.getName());
		stringBuilder.append("] Trace: ");
		stringBuilder.append(message);
		System.out.println(stringBuilder.toString());
	}
	
	public void info(String message) {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("[");
		stringBuilder.append(date.getHours());
		stringBuilder.append(":");
		stringBuilder.append(date.getMinutes());
		stringBuilder.append(" ");
		stringBuilder.append(class1.getName());
		stringBuilder.append("] Info: ");
		stringBuilder.append(message);
		System.out.println(stringBuilder.toString());
	}

}
