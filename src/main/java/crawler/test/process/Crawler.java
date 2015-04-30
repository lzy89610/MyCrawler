package crawler.test.process;

import java.util.HashSet;
import java.util.Set;


import crawler.config.ConfigManager;

public class Crawler
{
	private Set<Page> passedPages = new HashSet<Page>();
	
	private Set<Page> toPages = new HashSet<Page>();
	
	private Page seed;
	
	public static final String BASE_PATH = ConfigManager.BASE_PATH;
	
	public Crawler(Page seed)
	{
		this.seed = seed;
	}
	
	public void start()
	{
		toPages.add(seed);
		
		for(Page p : toPages)
		{
			crawl(p);
		}
	}
	
	public void crawl(Page page)
	{
		Set<Page> pages = getPagesInPage(page);
		toPages.addAll(pages);
		toPages.remove(page);
		passedPages.add(page);
		
		for(Page p : toPages)
		{
			if(!passedPages.contains(p))
			{
				System.out.println(p.getUrl());
				crawl(p);
			}
		}
	}
	
	public Set<Page> getPagesInPage(Page page)
	{
		return page.getContainPages();
	}
	

}
