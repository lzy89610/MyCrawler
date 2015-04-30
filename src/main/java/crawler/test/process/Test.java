package crawler.test.process;


import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class Test
{
	public static void main(String[] args) throws IOException, InterruptedException
	{
		Page[] seedPage = new Page[10];
		
		for(int i=0; i<10; i++)
		{
			seedPage[i] = new Page(i);
		}
		
		Set<Page> pages1 = new HashSet<Page>();
		pages1.add(seedPage[3]);
		pages1.add(seedPage[1]);
		pages1.add(seedPage[2]);
		seedPage[0].setContainPages(pages1);
		
		Set<Page> pages2 = new HashSet<Page>();
		pages2.add(seedPage[4]);
		pages2.add(seedPage[5]);
		pages2.add(seedPage[6]);
		seedPage[1].setContainPages(pages2);
		
		Set<Page> pages3 = new HashSet<Page>();
		pages3.add(seedPage[7]);
		pages3.add(seedPage[8]);
		pages3.add(seedPage[9]);
		seedPage[2].setContainPages(pages2);
		
//		Set<Page> pages4 = new HashSet<Page>();
//		pages4.add(seedPage[7]);
//		pages4.add(seedPage[8]);
//		pages4.add(seedPage[9]);
//		seedPage[3].setContainPages(pages3);
		
		Crawler crawler = new Crawler(seedPage[0]);
		crawler.start();
		
		
		
	}

}
