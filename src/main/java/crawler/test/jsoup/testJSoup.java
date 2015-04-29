package crawler.test.jsoup;

import java.io.File;
import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class testJSoup
{
	public static void main(String[] args) throws IOException
	{
//		String  html="<p><a href=\"a.html\">abcd</a></p><p> 文本</p>";
		File input  = new File("d:\\input3.html");
        Document doc = Jsoup.parse(input, "UTF-8", "http://www.zhihu.com");
//		Document doc = Jsoup.connect("http://www.zhihu.com/question/29949648").get();
        
//        Elements ele = doc.getElementsByTag("h3");
        Elements ele = doc.getElementsByClass("zm-profile-section-item");
        for(Element e : ele)
        {
//        	System.out.println(e.text() + " " + e.attr("htef"));
//        	System.out.println(e.);
        	
        }
		
	}

}
