package crawler.domain;

public class Person
{
	
	private String name;  //<span class="name">	url截取地址
	
	private String chineseName;		//即显示出来的名字
	
	private String url;
	
	private String weibo;   //class="zm-profile-header-user-weibo"
	
	private String jianjie; //<span class="bio" title="炼金术士">
	
	private String location;	//<span class="location item"
	
	private String business;	//<span class="business item" 
	
	private String employment;	//<span class="employment item"
	
	private String position;	//<span class="position item"
	
	private String education;	//<span class="education item"
	
	private String educationExtra;	//<span class="education-extra item"
	
	private int agreeCounts;	//<span class="zm-profile-header-user-agree">
	
	private int thanksCounts;	//<span class="zm-profile-header-user-thanks">
	
	private int asksCounts;
	
	private int answersCounts;
	
	private int postsCounts;
	
	private int collectionsCounts;
	
	private int logsCounts;
	
	private int followeeCounts;
	
	public Person(String url)
	{
		this.url = url;
	}
	
	public String getName()
	{
		return url.substring(url.lastIndexOf('/')+1, url.length());
	}
	public String getWeibo()
	{
		return weibo;
	}
	public void setWeibo(String weibo)
	{
		this.weibo = weibo;
	}
	public String getJianjie()
	{
		return jianjie;
	}
	public void setJianjie(String jianjie)
	{
		this.jianjie = jianjie;
	}
	public String getLocation()
	{
		return location;
	}
	public void setLocation(String location)
	{
		this.location = location;
	}
	public String getBusiness()
	{
		return business;
	}
	public void setBusiness(String business)
	{
		this.business = business;
	}
	public String getEmployment()
	{
		return employment;
	}
	public void setEmployment(String employment)
	{
		this.employment = employment;
	}
	public String getPosition()
	{
		return position;
	}
	public void setPosition(String position)
	{
		this.position = position;
	}
	public String getEducation()
	{
		return education;
	}
	public void setEducation(String education)
	{
		this.education = education;
	}
	public String getEducationExtra()
	{
		return educationExtra;
	}
	public void setEducationExtra(String educationExtra)
	{
		this.educationExtra = educationExtra;
	}
	public int getAgreeCounts()
	{
		return agreeCounts;
	}
	public void setAgreeCounts(int agreeCounts)
	{
		this.agreeCounts = agreeCounts;
	}
	public int getThanksCounts()
	{
		return thanksCounts;
	}
	public void setThanksCounts(int thanksCounts)
	{
		this.thanksCounts = thanksCounts;
	}
	public int getAsksCounts()
	{
		return asksCounts;
	}
	public void setAsksCounts(int asksCounts)
	{
		this.asksCounts = asksCounts;
	}
	public int getAnswersCounts()
	{
		return answersCounts;
	}
	public void setAnswersCounts(int answersCounts)
	{
		this.answersCounts = answersCounts;
	}
	public int getPostsCounts()
	{
		return postsCounts;
	}
	public void setPostsCounts(int postsCounts)
	{
		this.postsCounts = postsCounts;
	}
	public int getCollectionsCounts()
	{
		return collectionsCounts;
	}
	public void setCollectionsCounts(int collectionsCounts)
	{
		this.collectionsCounts = collectionsCounts;
	}
	public int getLogsCounts()
	{
		return logsCounts;
	}
	public void setLogsCounts(int logsCounts)
	{
		this.logsCounts = logsCounts;
	}
	public int getFolloweeCounts()
	{
		return followeeCounts;
	}
	public void setFolloweeCounts(int followeeCounts)
	{
		this.followeeCounts = followeeCounts;
	}

	public String getChineseName()
	{
		return chineseName;
	}

	public void setChineseName(String chineseName)
	{
		this.chineseName = chineseName;
	}

	public String getUrl()
	{
		return url;
	}

	public void setUrl(String url)
	{
		this.url = url;
	}

	public void setName(String name)
	{
		this.name = name;
	}
	

}
