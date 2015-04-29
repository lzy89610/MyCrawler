package crawler.domain;

import java.util.HashSet;
import java.util.Set;

public class Person
{
	private int id;
	
	/**
	 * 名字
	 */
	private String name;
	
	/**
	 * url
	 */
	private String url;
	
	/**
	 * 他关注的人总数
	 */
	private int followerNum;
	
	/**
	 * 关注他的人的总数
	 */
	private int followeeNum;
	
	/**
	 * 关注他的人
	 */
	private Set<Person> followers = new HashSet<Person>();
	
	private Set<Question> questions;
	
	private Set<Answer> answers;
	
	@Override
	public boolean equals(Object obj)
	{
		Person p = (Person)obj;
		String objName = p.getName();
		if(objName.equals(this.name))
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	

	public Person(String name)
	{
		super();
		this.name = name;
	}
	
	public Person addFollowers(Person person)
	{
		this.followers.add(person);
		return this;
	}

	public int getId()
	{
		return id;
	}

	public void setId(int id)
	{
		this.id = id;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public String getUrl()
	{
		return url;
	}

	public void setUrl(String url)
	{
		this.url = url;
	}

	public int getFollowerNum()
	{
		return followerNum;
	}

	public void setFollowerNum(int followerNum)
	{
		this.followerNum = followerNum;
	}

	public int getFolloweeNum()
	{
		return followeeNum;
	}

	public void setFolloweeNum(int followeeNum)
	{
		this.followeeNum = followeeNum;
	}

	public Set<Person> getFollowers()
	{
		return followers;
	}


	public void setFollowers(Set<Person> followers)
	{
		this.followers = followers;
	}


	public Set<Question> getQuestions()
	{
		return questions;
	}

	public void setQuestions(Set<Question> questions)
	{
		this.questions = questions;
	}

	public Set<Answer> getAnswers()
	{
		return answers;
	}

	public void setAnswers(Set<Answer> answers)
	{
		this.answers = answers;
	}
	
	
	

}
