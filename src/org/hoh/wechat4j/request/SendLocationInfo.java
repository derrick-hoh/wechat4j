/**
 * 
 */
package org.hoh.wechat4j.request;

import javax.xml.bind.annotation.XmlElement;
/**
 * 
* @ClassName: SendLocationInfo 
* @Description: TODO(发送地理位置信息实体类) 
* @author derrick_hoh@163.com
* @date 2016年7月27日 上午10:19:10 
*
 */
public class SendLocationInfo {
	private String Location_X;
	private String Location_Y;
	private String Scale;
	private String Label;
	private String Poiname;

	@XmlElement(name="Location_X")
	public String getLocation_X() {
		return Location_X;
	}
	public void setLocation_X(String location_X) {
		Location_X = location_X;
	}
	@XmlElement(name="Location_Y")
	public String getLocation_Y() {
		return Location_Y;
	}
	public void setLocation_Y(String location_Y) {
		Location_Y = location_Y;
	}
	@XmlElement(name="Scale")
	public String getScale() {
		return Scale;
	}
	public void setScale(String scale) {
		Scale = scale;
	}
	@XmlElement(name="Label")
	public String getLabel() {
		return Label;
	}
	public void setLabel(String label) {
		Label = label;
	}
	@XmlElement(name="Poiname")
	public String getPoiname() {
		return Poiname;
	}
	public void setPoiname(String poiname) {
		Poiname = poiname;
	}
	
	
	
	
}
