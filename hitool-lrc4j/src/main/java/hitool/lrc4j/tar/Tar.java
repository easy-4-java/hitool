package hitool.lrc4j.tar;

/**
 * 
 * @className ： Tar
 * 标签
 * @author <a href="https://github.com/loong10k">Loong Wan</a>
 * 
 */
public interface Tar {
	/**
	 * 
	 * 得标签值
	 * @author <a href="https://github.com/loong10k">Loong Wan</a>
	 * 
	 * @return
	 */
	public String getValue();

	/**
	 * 
	 * 设置标签值
	 * @author <a href="https://github.com/loong10k">Loong Wan</a>
	 * 
	 * @param value
	 */
	public void setValue(String value);

	/**
	 * 
	 * 得标签名
	 * @author <a href="https://github.com/loong10k">Loong Wan</a>
	 * 
	 * @return
	 */
	public abstract String getName();
}
