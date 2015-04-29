package crawler.parser;

import java.util.Set;

import org.htmlparser.NodeFilter;
import org.htmlparser.Parser;
import org.htmlparser.filters.NodeClassFilter;
import org.htmlparser.tags.Span;
import org.htmlparser.util.NodeList;

import crawler.domain.Person;

public class ZhihuParser implements SNSParser
{
	private String curPageURL;
	

	public Set<Person> parseFollowers()
	{
		try
		{
			NodeFilter filter = new NodeClassFilter(Span.class);
			Parser parser = new Parser();
			parser.setURL("http://www.zhihu.com/people/wentasy");
			parser.setEncoding(parser.getEncoding());
			NodeList list = parser.extractAllNodesThatMatch(filter);
			for (int i = 0; i < list.size(); i++)
			{
				Span node = (Span) list.elementAt(i);
				System.out.println(node.getAttribute("class"));
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		
		return null;
		
	}
	
	private Person parseFollower()
	{
		
		
		return null;
	}
	
	private int parseFollowerNum()
	{
		
		
		return 0;
		
	}
	
	

}
