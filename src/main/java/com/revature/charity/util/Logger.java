package com.revature.charity.util;

public final class Logger {
	
	public static final String level = "DEBUG";
	
	public static void debug(Object message)
	{
//		if(level == "DEBUG")
//		{
			System.out.println(message);
//		}
	}
	
	public static void error(Object message)
	{
//		if(level == "ERROR")
//		{
			System.out.println(message);
//		}
	}
	
	public static void info(Object message)
	{
//		if(level == "INFO")
//		{
			System.out.println(message);
//		}
	}

}
