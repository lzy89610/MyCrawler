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
import crawler.utils.HttpClientUtil;

/**
 * 爬虫主任务类，实现爬虫逻辑。
 * 爬虫在爬行时，将已访问过的page放到passedPages中，待访问的page放到toPages中。其中，passedPages是全局的。
 * 在每一次取出toPages中的page时，都检查一次该page是否存在于passedPages中，如果已存在，则不访问，并将其标记到toRemovedPages中。
 * 在本次循环结束时，将toRemovedPages中的所有pages从toPages中删除。
 * 具体代码逻辑见crawl方法
 * 
 * @author lizeyu
 *
 */
public class Crawler implements Runnable
{
	/**
	 * 已访问过的page set。由主线程中传入，全局共享
	 */
	private Set<Page> passedPages;
	
	/**
	 * 待访问的page set。线程私有
	 */
	private Set<Page> toPages = new HashSet<Page>(ConfigManager.TOPAGES_INITIAL_CAPACITY);
	
	/**
	 * 用于暂存toPages和passedPages中重叠的page
	 */
	private Set<Page> toRemovedPages = new HashSet<Page>();
	
	/**
	 * 种子
	 */
	private Page seed;
	
	/**
	 * 工作空间的主目录
	 */
	public static final String BASE_PATH = ConfigManager.BASE_PATH;
	
	public Crawler(Page seed, Set<Page> passedPages)
	{
		this.seed = seed;
		this.passedPages = passedPages;
	}
	
	@Override
	/**
	 * 将种子添加到toPages中，递归调用toPages方法
	 */
	public void run()
	{
		toPages.add(seed);
		
		for(Page p : toPages)
		{
			crawl(p);
		}
	}
	
	/**
	 * 爬虫的主方法
	 * @param page
	 */
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
				//System.out.println(p.getUrl() + " " + Thread.currentThread());
				HttpClientUtil.downloadPage(p);
				crawl(p);
			}
		}
		
		//清除toPages和passedPages中重叠的page
		removeOverlapped();
	}
	
	/**
	 * 利用Jsoup解析已下载好的文件，并返回其中所有符合条件的url
	 * @param page
	 * @return
	 */
	private Set<Page> getPagesInPage(Page page)
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
