package com.jbk.owu.util;

public class Configuration {
	
	public static String qaurl = PropertyManager.getInstance().getQaurl();
	public static String uaturl = PropertyManager.getInstance().getSuite();
	public static String suit = PropertyManager.getInstance().getSuite();
	
		public static String getURL()
		{
			String URL_INFO = null;
			System.out.println(" QA URL >>>"+qaurl);
			if(suit.equalsIgnoreCase("SmokeTest"))
			{
				URL_INFO = qaurl;
				System.out.println(" QA URL >>>"+qaurl);
			}
			if(suit.equalsIgnoreCase("UATTest"))
			{
				URL_INFO = uaturl;
				System.out.println(" QA URL >>>"+uaturl);
			}
			return URL_INFO;
		}
			
		}
	
		
	
	
			


