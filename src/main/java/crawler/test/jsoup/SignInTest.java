package crawler.test.jsoup;

import java.io.IOException;

import org.jsoup.Connection;
import org.jsoup.Connection.Method;
import org.jsoup.Jsoup;

public class SignInTest
{
	public static void main(String[] args) throws IOException
	{
		Connection.Response res = Jsoup
				.connect("http://61.145.164.148:25000/uums/")
				.data("manageVo.loginName", "TEST001", "manageVo.password", "123456")
				.method(Method.POST).execute();

		// 这儿的SESSIONID需要根据要登录的目标网站设置的session Cookie名字而定
		String sessionId = res.cookie("SESSIONID");
		System.out.println(sessionId);

	}

}
