package crawler.httpclient;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.http.HttpResponse;
import org.apache.http.ParseException;

public class test
{

	public static void main(String[] args) throws ParseException, IOException
	{
		Map<String, String> parameterMap = new HashMap<String, String>();
		parameterMap.put("userName", "TEST001");
		parameterMap.put("password", "123456");
		
		HttpClientUtil clientUtil = new HttpClientUtil();
		clientUtil.post("http://localhost:8080/testHttpClient/MyJsp.jsp", parameterMap);

	}

}
