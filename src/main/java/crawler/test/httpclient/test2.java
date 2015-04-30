package crawler.test.httpclient;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import org.apache.http.HttpEntity;
import org.apache.http.ParseException;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

public class test2
{

	public static void main(String[] args)
	{
		CloseableHttpClient httpclient = null;
		CloseableHttpResponse response = null;
		FileOutputStream out = null;
		int byteRead = 0;
		
		try
		{
			httpclient = HttpClients.createDefault();
			HttpGet httpget = new HttpGet("http://www.zhihu.com/people/be5invis");
			response = httpclient.execute(httpget);
			
			HttpEntity entity = response.getEntity();
			if (entity != null)
			{
				InputStream in = entity.getContent();
				out = new FileOutputStream("E:\\crawlerworkspace\\test3.html");
				byte[] buf = new byte[1024];

				while ((byteRead = in.read(buf)) != -1)
				{
					out.write(buf, 0, byteRead);
				}
			}
		}
		catch (ClientProtocolException e)
		{
			e.printStackTrace();
		}
		catch (ParseException e)
		{
			e.printStackTrace();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		finally
		{
			// 关闭连接,释放资源
			try
			{
				out.close();
				response.close();
				httpclient.close();
			}
			catch (IOException e)
			{
				e.printStackTrace();
			}
		}
	}

}
