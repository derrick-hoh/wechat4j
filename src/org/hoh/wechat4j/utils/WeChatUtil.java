package org.hoh.wechat4j.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;
import org.hoh.wechat4j.exception.WeChatException;
import org.hoh.wechat4j.exception.WeChatReturnCode;

import com.alibaba.fastjson.JSONObject;

/**
 * 
* @ClassName: WeChatUtil 
* @Description: TODO(微信工具类) 
* @author derrick_hoh@163.com
* @date 2016年8月10日 下午6:41:10 
*
 */
public class WeChatUtil {
	/**
	 * 
	* @Title: isSuccess 
	* @Description: TODO(判断是否请求成功) 
	* @param @param resultStr
	* @param @throws WeChatException    设定文件 
	* @return void    返回类型 
	* @throws
	 */
	public static void isSuccess(String resultStr) throws WeChatException {
		JSONObject jsonObject = JSONObject.parseObject(resultStr);
		Integer errCode = jsonObject.getIntValue("errcode");
		if (errCode != null && errCode != 0) {
			String errMsg = WeChatReturnCode.getMsg(errCode);
			if (errMsg.equals("")) {
				errMsg = jsonObject.getString("errmsg");
			}
			throw new WeChatException("异常码:" + errCode + ";异常说明:" + errMsg);
		}
	}

	/**
	 * 
	* @Title: isWeiXin 
	* @Description: TODO(判断是否微信打开) 
	* @param @param request
	* @param @return    设定文件 
	* @return boolean    返回类型 
	* @throws
	 */
	public static boolean isWeiXin(HttpServletRequest request) {
		String userAgent = request.getHeader("User-Agent");
		if (StringUtils.isNotBlank(userAgent)) {
			Pattern p = Pattern.compile("MicroMessenger/(\\d+).+");
			Matcher m = p.matcher(userAgent);
			String version = null;
			if (m.find()) {
				version = m.group(1);
			}
			return (version != null) && (NumberUtils.toInt(version) >= 5);
		}
		return false;
	}
}
