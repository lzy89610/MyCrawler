package crawler.httpclient;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.http.HeaderIterator;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.ParseException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

public class HttpClientUtil
{
	public HttpResponse post(String url, Map<String, String> parameterMap) throws UnsupportedEncodingException
	{
		HttpResponse httpResponse = null;
		
		CloseableHttpClient client = HttpClients.createDefault();
		HttpPost httpPost = new HttpPost(url);
		UrlEncodedFormEntity postEntity = new UrlEncodedFormEntity(
					getParam(parameterMap), "UTF-8");
		httpPost.setEntity(postEntity);
		
		try
		{
			// 执行post请求
			//HttpResponse httpResponse = client.execute(httpPost, context);
			httpResponse = client.execute(httpPost);
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
		
		return httpResponse;
		
	}
	
	private List<NameValuePair> getParam(Map parameterMap)
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
	
	public void printResponse(HttpResponse httpResponse)
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
	

}
