package crawler.utils;

import crawler.config.ConfigManager;

public class UrlHelper
{
	public static final String DOMAIN = ConfigManager.DOMAIN;
	public static final String URI_PREFIX = ConfigManager.URI_PREFIX;
	
	public static String parseFileNameToUrl(String fileName)
	{
		String s = fileName.substring(0, fileName.indexOf('.'));
		return DOMAIN + URI_PREFIX + s;
	}
	
	public static void main(String[] args)
	{
		String s = "hello.html";
		String s2 = parseFileNameToUrl(s);
		System.out.println(s2);
	}


}
