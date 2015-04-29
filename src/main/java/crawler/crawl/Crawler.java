package crawler.crawl;

import java.util.HashSet;
import java.util.Set;

import crawler.domain.Person;


public class Crawler
{
	private Set<Person> allPerson = new HashSet<Person>();
	
	private Person seed;
	
	public static final int CRAWL_MAX_DEPTH = 1000;
	
	/**
	 * 用种子初始化队列
	 * @param person
	 */
	public void init(Person person)
	{
		seed = person;
		allPerson.add(seed);		
	}
	
	public Set<Person> startCrawl()
	{
		crawl(seed, allPerson, 0);
		return allPerson;
	}
	
	/**
	 * 深度优先遍历。如果在遍历过程中，发现已遍历过的，则跳过。否则，加入到队列中
	 * 如果depth大于或等于最大设定的最大深度（CRAWL_MAX_DEPTH），则将depth减1，并回退。
	 * @param person	
	 * @param allPerson  一个全局的set，用来存放所有遍历过的人
	 * @param depth      爬的深度
	 */
	public void crawl(Person person, Set<Person> allPerson, int depth)
	{
		Set<Person> followers = person.getFollowers();
		if(null==followers || depth>=CRAWL_MAX_DEPTH)
		{
			//如果depth大于或等于最大设定的最大深度（CRAWL_MAX_DEPTH），则将depth减1，并回退
			depth--;
			return;
		}
		else
		{
			for(Person p : followers)
			{
				//如果在遍历过程中，发现没有遍历过，加入到队列中
				if(!allPerson.contains(p))
				{
					allPerson.add(p);
					depth++;
					crawl(p, allPerson, depth);
				}
			}
		}
	}
	
	

}
