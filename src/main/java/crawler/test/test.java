package crawler.test;

import java.util.Set;

import crawler.crawl.Crawler;
import crawler.domain.Person;


public class test
{
	public static void main(String[] args)
	{
		Person caozheng = new Person("caozheng");
		Person weiyixiao = new Person("weiyixiao");
		Person wenguobing = new Person("wenguobing");
		Person vczh = new Person("vczh");

		caozheng.addFollowers(wenguobing).addFollowers(weiyixiao);
		weiyixiao.addFollowers(wenguobing).addFollowers(vczh);
		vczh.addFollowers(caozheng).addFollowers(wenguobing);
		
		Crawler crawler = new Crawler();
		crawler.init(vczh);
		Set<Person> followees = crawler.startCrawl();
		
		for(Person p : followees)
		{
			System.out.println(p.getName());
		}
		
	}
	
	

}
