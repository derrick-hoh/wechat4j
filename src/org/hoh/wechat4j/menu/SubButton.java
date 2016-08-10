package org.hoh.wechat4j.menu;

import java.io.Serializable;
/**
 * 
* @ClassName: SubButton 
* @Description: TODO(子菜单) 
* @author derrick_hoh@163.com
* @date 2016年8月10日 上午10:08:55 
*
 */
public class SubButton implements Serializable {

	/** 
	* @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么) 
	*/
	private static final long serialVersionUID = -2332318265645568862L;
	private String type;
	private String name;
	private String url;
	private String key;

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

}
