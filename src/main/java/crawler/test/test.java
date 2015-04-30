package crawler.test;

import java.util.HashSet;
import java.util.Set;

import crawler.crawl.Crawler;
import crawler.domain.Page;
import crawler.domain.Person;


public class test
{
	public static void main(String[] args)
	{
//		Person caozheng = new Person("caozheng");
//		Person weiyixiao = new Person("weiyixiao");
//		Person wenguobing = new Person("wenguobing");
//		Person vczh = new Person("vczh");
//
//		caozheng.addFollowers(wenguobing).addFollowers(weiyixiao);
//		weiyixiao.addFollowers(wenguobing).addFollowers(vczh);
//		vczh.addFollowers(caozheng).addFollowers(wenguobing);
//		
//		Crawler crawler = new Crawler();
//		crawler.init(vczh);
//		Set<Person> followees = crawler.startCrawl();
//		
//		for(Person p : followees)
//		{
//			System.out.println(p.getName());
//		}
//		
		
//		String s = "http://www.zhihu.com/people/be5invis";
//		
//		System.out.println(s.substring(s.indexOf("com")+3, s.length()));
		
		Set<Page> toPages = new HashSet<Page>();
		Set<Page> toRemovedPages = new HashSet<Page>();
		
		Page p1 = new Page("1");
		Page p2 = new Page("2");
		Page p3 = new Page("3");
		Page p4 = new Page("4");
		
		toPages.add(p1);
		toPages.add(p2);
		toPages.add(p3);
		toPages.add(p4);
		
		toRemovedPages.add(p1);
		toRemovedPages.add(p4);
		
		removeOverlapped(toRemovedPages, toPages);
		
		for(Page p : toPages)
		{
			System.out.println(p.getUrl());
		}
		
	}
	
	private static void removeOverlapped(Set<Page> toRemovedPages, Set<Page> toPages)
	{
		for(Page p : toRemovedPages)
		{
			toPages.remove(p);
		}
		toRemovedPages.clear();
	}
	
	

}
