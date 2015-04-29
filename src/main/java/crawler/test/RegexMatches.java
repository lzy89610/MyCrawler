package crawler.test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexMatches
{
	public static void main(String args[])
	{

		// 按指定模式在字符串查找
		String line = "people/shun-feng-zhuang-bi-ni-feng-gua-ji";
		String pattern = "^people/";

		// 创建 Pattern 对象
		Pattern r = Pattern.compile(pattern);

		// 现在创建 matcher 对象
		Matcher m = r.matcher(line);
		if (m.find())
		{
			System.out.println("Found value: " + m.group(0));
		}
		else
		{
			System.out.println("NO MATCH");
		}
	}
}
