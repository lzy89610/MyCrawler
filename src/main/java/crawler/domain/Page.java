package crawler.domain;

import crawler.config.ConfigManager;

/**
 * url的抽象。
 * 其中对应localPath和URI两个概念
 * URI是URL去掉domain后的值
 * localPath是对URI处理后的相对路径
 * @author lizeyu
 *
 */
public class Page
{
	private String url;
	
	public Page(String url)
	{
		super();
		this.url = url;
	}

	public String getUrl()
	{
		return url;
	}

	public void setUrl(String url)
	{
		this.url = url;
	}

	public String getLocalpath()
	{
		return ConfigManager.BASE_PATH + 
				url.substring(url.lastIndexOf('/')+1, url.length()) + 
				".html";
	}
	
	public String getURI()
	{
		return url.substring(url.indexOf("com")+3, url.length());
		
	}

	@Override
	public boolean equals(Object o)
	{
		Page p = (Page)o;
		return url.equals(p.getUrl());
	}

	@Override
	public int hashCode()
	{
		return url.hashCode();
	}
	
	
	
	

	
	
	

}
