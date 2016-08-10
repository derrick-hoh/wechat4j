package org.hoh.wechat4j.menu;

import java.io.Serializable;
import java.util.Collection;

public class JsonMenu implements Serializable {

	/** 
	* @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么) 
	*/ 
	private static final long serialVersionUID = -9168664038602006173L;
	 private Collection<Button> button;
	public Collection<Button> getButton() {
		return button;
	}
	public void setButton(Collection<Button> button) {
		this.button = button;
	}
	 

}
