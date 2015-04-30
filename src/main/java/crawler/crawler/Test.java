package crawler.crawler;


import java.io.File;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import crawler.config.ConfigManager;
import crawler.domain.Page;
import crawler.utils.UrlHelper;

public class Test
{
	final int PASSEDPAGES_INITIAL_CAPACITY = ConfigManager.PASSEDPAGES_INITIAL_CAPACITY;
	static final String SEED_PATH = ConfigManager.SEED_PATH;
	
	public static void main(String[] args) throws IOException, InterruptedException
	{
//		Page seedPage = new Page("http://www.zhihu.com/people/be5invis");
//		Crawler crawler = new Crawler(seedPage);
//		crawler.start();
		
		final int PASSEDPAGES_INITIAL_CAPACITY = ConfigManager.PASSEDPAGES_INITIAL_CAPACITY;
		Set<Page> passedPages = new HashSet<Page>(PASSEDPAGES_INITIAL_CAPACITY);
		
		String[] seedFile = getSeeds();
		int threadsNum = seedFile.length;
		Page[] seeds = new Page[threadsNum];
		
		for(int i=0; i<threadsNum; i++)
		{
			seeds[i] = new Page(UrlHelper.parseFileNameToUrl(seedFile[i]));
		}
		
		ExecutorService service = Executors.newFixedThreadPool(threadsNum);
		for (int i = 0; i < threadsNum; i++)
		{
			Runnable crawler = new Crawler(seeds[i], passedPages);
			service.execute(crawler);
		}
		service.shutdown();
		service.awaitTermination(Long.MAX_VALUE, TimeUnit.DAYS);
		System.out.println("all thread complete");
	}
	
	private static String[] getSeeds()
	{
		File file = new File(SEED_PATH);
		
		if(file.isDirectory())
		{
			String[] fileNames = file.list();
			return fileNames;
		}
		else
		{
			return null;
		}
	}

}
