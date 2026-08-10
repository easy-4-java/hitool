package hitool.lrc4j.tar;

/**
 * 
 * @className	： AbstractTar
 * 标签 <p> 其格式为"[标识名:值]"。大小写等价 </p>
 * @author <a href="https://github.com/loong10k">Loong Wan</a>
 * 
 */
public abstract class AbstractTar implements Tar {
	
	private String value;

	@Override
	public String getValue() {
		return value;
	}

	@Override
	public void setValue(String value) {
		this.value = value;
	}

	@Override
	public abstract String getName();

}
