package crawler.crawler;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class JsoupTest
{
	public static void main(String[] args) throws IOException
	{
//		File input = new File("F:\\crawlerworkspace\\test.html");
		//Document doc = Jsoup.parse(input, "UTF-8");
		
		Document doc = Jsoup.connect("http://www.zhihu.com/people/be5invis").get();

		Elements ele = doc.select("a[href]");
		for (Element e : ele)
		{
			if(e.hasAttr("data-tip"))
			{
				String s = e.attr("href");
				if(s.startsWith("/people"))
				{
					s = "http://www.zhihu.com" + s;
				}
				System.out.println(s);
			}
				

		}

	}

}