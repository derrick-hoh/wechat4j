package org.hoh.wechat4j.menu;

import java.io.Serializable;
import java.util.Collection;

/**
 * 
* @ClassName: Button 
* @Description: TODO(菜单按钮) 
* @author derrick_hoh@163.com
* @date 2016年8月10日 上午10:09:22 
*
 */
public class Button implements Serializable {

	/** 
	* @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么) 
	*/
	private static final long serialVersionUID = -4375197536307899799L;
	private String type;
	private String name;
	private String key;
	private String url;
	private String media_id;
	private Collection<SubButton> sub_button;

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

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getMedia_id() {
		return media_id;
	}

	public void setMedia_id(String media_id) {
		this.media_id = media_id;
	}

	public Collection<SubButton> getSub_button() {
		return sub_button;
	}

	public void setSub_button(Collection<SubButton> sub_button) {
		this.sub_button = sub_button;
	}

}
