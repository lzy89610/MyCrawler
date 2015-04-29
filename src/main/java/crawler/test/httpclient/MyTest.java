package crawler.test.httpclient;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.http.HeaderIterator;
import org.apache.http.HttpEntity;
import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.ParseException;
import org.apache.http.client.CookieStore;
import org.apache.http.client.config.CookieSpecs;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.config.Registry;
import org.apache.http.config.RegistryBuilder;
import org.apache.http.cookie.CookieSpecProvider;
import org.apache.http.impl.client.BasicCookieStore;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.cookie.BasicClientCookie;
import org.apache.http.impl.cookie.BestMatchSpecFactory;
import org.apache.http.impl.cookie.BrowserCompatSpecFactory;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.junit.Test;

public class MyTest
{
	// 创建CookieStore实例
		static CookieStore cookieStore = null;
		static HttpClientContext context = null;
		String loginUrl = "http://localhost:8080/testHttpClient/MyJsp.jsp";

		@Test
		public void testLogin() throws Exception
		{
			addCookie("z_c0","\"QUFDQUI4WWtBQUFYQUFBQVlRSlZUU0llYUZYaW1vOFF6UnF6YVpuakN5SlpFek0wemdrbG1RPT0=|1430294818|36ffcba9e78883a93851e8128a96400ac0f75907\"");
			addCookie("q_c1","5ae94ec98e1a49339fea4c5c102d1faf|1427703839000|1419339196000");
			addCookie("_za","3bfdf7ea-f2c5-4461-bda9-f413aa144b30");
			addCookie("_xsrf","a9528fc29be613e711f6475415f315e5");
			addCookie("__utmz","51854390.1430286529.11.4.utmcsr=zhihu.com|utmccn=(referral)|utmcmd=referral|utmcct=/people/wangbenrui/followers");
			addCookie("__utmv","51854390.100-1|2=registration_date=20140126=1^3=entry_date=20140126=1");
			addCookie("__utmt","1");
			addCookie("__utmd","1");
			addCookie("__utmc","51854390");
			addCookie("__utmb","51854390.16.10.1430295154");
			addCookie("__utma","51854390.2031312628.1429236274.1430286529.1430295154.12");
			
			//setContext
			context = HttpClientContext.create();
			Registry<CookieSpecProvider> registry = RegistryBuilder
					.<CookieSpecProvider> create()
					.register(CookieSpecs.BEST_MATCH, new BestMatchSpecFactory())
					.register(CookieSpecs.BROWSER_COMPATIBILITY,
							new BrowserCompatSpecFactory()).build();
			context.setCookieSpecRegistry(registry);
			context.setCookieStore(cookieStore);
			
			CloseableHttpClient client = HttpClients.createDefault();
			HttpGet httpGet = new HttpGet("http://www.zhihu.com/people/chenzhenhua/followers");
//			//execute post
//			HttpPost httpPost = new HttpPost(loginUrl);
//			Map<String, String> parameterMap = new HashMap<String, String>();
//			parameterMap.put("userName", "TEST001");
//			parameterMap.put("password", "123456");
//			UrlEncodedFormEntity postEntity = new UrlEncodedFormEntity(
//					getParam(parameterMap), "UTF-8");
//			httpPost.setEntity(postEntity);
			
			try
			{
				// 执行post请求
//				HttpResponse httpResponse = client.execute(httpPost, context);
				HttpResponse httpResponse = client.execute(httpGet, context);
				printResponse(httpResponse);

			}
			catch (IOException e)
			{
				e.printStackTrace();
			}
			finally
			{
				try
				{
					// 关闭流并释放资源
					client.close();
				}
				catch (IOException e)
				{
					e.printStackTrace();
				}
			}
		}
		
		
		public static List<NameValuePair> getParam(Map parameterMap)
		{
			List<NameValuePair> param = new ArrayList<NameValuePair>();
			Iterator it = parameterMap.entrySet().iterator();
			while (it.hasNext())
			{
				Entry parmEntry = (Entry) it.next();
				param.add(new BasicNameValuePair((String) parmEntry.getKey(),
						(String) parmEntry.getValue()));
			}
			return param;
		}
		
		public static void printResponse(HttpResponse httpResponse)
				throws ParseException, IOException
		{
			// 获取响应消息实体
			HttpEntity entity = httpResponse.getEntity();
			// 响应状态
			System.out.println("status:" + httpResponse.getStatusLine());
			System.out.println("headers:");
			HeaderIterator iterator = httpResponse.headerIterator();
			while (iterator.hasNext())
			{
				System.out.println("\t" + iterator.next());
			}
			// 判断响应实体是否为空
			if (entity != null)
			{
				String responseString = EntityUtils.toString(entity);
				System.out.println("response length:" + responseString.length());
				System.out.println("response content:"
						+ responseString.replace("\r\n", ""));
			}
		}
		
		public void addCookie(String id, String value)
		{
			cookieStore = new BasicCookieStore();
			BasicClientCookie cookie = new BasicClientCookie(id, value);
			cookie.setVersion(0);
			cookie.setDomain("www.zhihu.com");
			cookie.setPath("/");
			cookieStore.addCookie(cookie);
		}

}
