package crawler.test;

import org.htmlparser.NodeFilter;
import org.htmlparser.Parser;
import org.htmlparser.filters.NodeClassFilter;
import org.htmlparser.tags.Span;
import org.htmlparser.util.NodeList;

public class testHtmlParser
{
	public static void main(String[] args)
	{
		try
		{
			NodeFilter filter = new NodeClassFilter(Span.class);
			// NodeFilter filter = new TagNameFilter("LINK");
			Parser parser = new Parser();
			parser.setURL("http://www.zhihu.com/people/lexdene/followers");
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
	}

}
