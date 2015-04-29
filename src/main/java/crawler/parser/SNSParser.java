package crawler.parser;

import java.util.Set;

import crawler.domain.Person;

/**
 * 用于解析所有SNS类型的HTML页面
 * @author lizeyu
 *
 */
public interface SNSParser
{
	/**
	 * 解析关注他的人
	 * @return
	 */
	public Set<Person> parseFollowers();
	
	
//	/**
//	 * 解析关注他的人
//	 * @return
//	 */
//	public Set<Person> parseFollowers();
//	
	

}
