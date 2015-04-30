package crawler.test.process;

import java.util.Set;


public class Page
{
	private Integer url;
	
	private Set<Page> containPages;
	
	public Page(Integer url)
	{
		super();
		this.url = url;
	}
	
	public Set<Page> getContainPages()
	{
		return containPages;
	}


	public void setContainPages(Set<Page> containPages)
	{
		this.containPages = containPages;
	}


	public Integer getUrl()
	{
		return url;
	}

	public void setUrl(Integer url)
	{
		this.url = url;
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
