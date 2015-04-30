package crawler.domain;

public class Answer
{
	private String question;
	
	private String url;
	
	private String author;
	
	private String content;
	
	private int voteCount;
	
	private int commentCount;

	public String getQuestion()
	{
		return question;
	}

	public void setQuestion(String question)
	{
		this.question = question;
	}

	public String getAuthor()
	{
		return author;
	}

	public void setAuthor(String author)
	{
		this.author = author;
	}

	public String getContent()
	{
		return content;
	}

	public void setContent(String content)
	{
		this.content = content;
	}

	public int getVoteCount()
	{
		return voteCount;
	}

	public void setVoteCount(int voteCount)
	{
		this.voteCount = voteCount;
	}

	public int getCommentCount()
	{
		return commentCount;
	}

	public void setCommentCount(int commentCount)
	{
		this.commentCount = commentCount;
	}

	public String getUrl()
	{
		return url;
	}

	public void setUrl(String url)
	{
		this.url = url;
	}



	
	

}
