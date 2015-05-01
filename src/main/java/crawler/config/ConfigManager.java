package crawler.config;

public class ConfigManager
{
	/**
	 * 工作空间目录
	 */
	public static final String BASE_PATH = "F:\\crawlerworkspace\\";
	
	/**
	 * 存放种子文件的目录
	 */
	public static final String SEED_PATH = BASE_PATH + "seeds\\";
	
	/**
	 * 要爬的网站的域名
	 */
	public static final String DOMAIN = "http://www.zhihu.com/";
	
	/**
	 * URI的前缀
	 */
	public static final String URI_PREFIX = "people/";
	
	
	/**
	 * 已爬过的空间的初始容量
	 */
	public static final int PASSEDPAGES_INITIAL_CAPACITY = 8192;
	
	/**
	 * 待爬空间的初始容量
	 */
	public static final int TOPAGES_INITIAL_CAPACITY = 4096;
	
	

}
