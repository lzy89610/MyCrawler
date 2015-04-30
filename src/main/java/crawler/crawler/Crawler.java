package crawler.crawler;

import java.io.File;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import crawler.config.ConfigManager;
import crawler.domain.Page;
import crawler.httpclient.HttpClientUtil;

public class Crawler implements Runnable
{
	private Set<Page> passedPages;
	
	private Set<Page> toPages = new HashSet<Page>(ConfigManager.TOPAGES_INITIAL_CAPACITY);
	
	//用于暂存toPages和passedPages中重叠的page
	private Set<Page> toRemovedPages = new HashSet<Page>();
	
	private Page seed;
	
	public static final String BASE_PATH = ConfigManager.BASE_PATH;
	
	public Crawler(Page seed, Set<Page> passedPages)
	{
		this.seed = seed;
		this.passedPages = passedPages;
	}
	
	public void start()
	{
		toPages.add(seed);
		
		for(Page p : toPages)
		{
			crawl(p);
		}
	}
	
	@Override
	public void run()
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
		synchronized (this)
		{
			passedPages.add(page);	
		}
		
		for(Page p : toPages)
		{
			if(passedPages.contains(p))
			{
				toRemovedPages.add(p);
			}
			else
			{
				//显示已经爬了哪些url
				System.out.println(p.getUrl() + " " + Thread.currentThread());
				HttpClientUtil.downloadPage(p);
				crawl(p);
			}
		}
		
		//清除toPages和passedPages中重叠的page
		removeOverlapped();
	}
	
	public Set<Page> getPagesInPage(Page page)
	{
		Set<Page> pageList = new HashSet<Page>();
		Document doc = null;
		
		try
		{
			File in = new File(page.getLocalpath());
			doc = Jsoup.parse(in, "utf-8");
			Elements ele = doc.select("a[href]");
			for (Element e : ele)
			{
				if(e.hasAttr("data-tip"))
				{
					String s = e.attr("href");
					if(s.startsWith("/people"))
					{
						if(!s.equals(page.getURI()))
							pageList.add(new Page("http://www.zhihu.com" + s));
					}
					else if(s.startsWith("http://www.zhihu.com/people/"))
					{
						if(!s.equals(page.getUrl()))
							pageList.add(new Page(s));
					}
					else
					{
						continue;
					}
				}
			}
		}
		catch(IOException e)
		{
			//e.printStackTrace();
		}
		
		return pageList;
	}
	
	/**
	 * 清除toPages和passedPages中重叠的page
	 */
	private void removeOverlapped()
	{
		for(Page p : toRemovedPages)
		{
			toPages.remove(p);
		}
		toRemovedPages.clear();
	}
	
	

}
