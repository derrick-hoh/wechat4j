package org.hoh.wechat4j.menu;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

import org.hoh.wechat4j.cache.impl.AccessTokenCache;
import org.hoh.wechat4j.enums.EventType;
import org.sword.lang.HttpUtils;

import com.google.gson.Gson;

/**
 * 
 * @ClassName: MenuService
 * @Description: TODO(微信自定义菜单创建接口)
 * @author 385327450@qq.com
 * @date 2016年3月19日 上午9:35:41
 * 
 */
public class MenuManager {
	private final static Gson gson = new Gson();
	private static final String CREATE_MENU = "https://api.weixin.qq.com/cgi-bin/menu/create?access_token=";// 创建自定义菜单
	private static final String DELETE_MENU = "https://api.weixin.qq.com/cgi-bin/menu/delete?access_token=";// 删除自定义菜单
	private static final String QUERY_MENU = "https://api.weixin.qq.com/cgi-bin/menu/get?access_token=";// 查询自定义菜单

	/**
	 * @return
	 * @throws Exception
	 * 
	 * @Title: create
	 * @Description: TODO(创建自定义菜单)
	 * @param 设定文件
	 * @return void 返回类型
	 * @throws
	 */
	@SuppressWarnings("unchecked")
	public static boolean create() throws Exception {
		String access_token = AccessTokenCache.getInstance().getAccessToken();
		Collection<Button> buttons = new ArrayList<Button>(3);
		Button a = new Button();
		a.setType(EventType.view.name());
		a.setName("微商城");
		a.setUrl("http://trzm.xhand.cn");

		/*
		 * Button c = new Button(); c.setType(MenuEvent.CLICK.getEvent());
		 * c.setName("生成二维码"); c.setKey("SPREAD_POSTER");
		 */

		Button b = new Button();
		b.setName("生成二维码");
		b.setType(EventType.SCAN.name());
		b.setKey("POSTER");

		Button c = new Button();
		c.setName("企业介绍");
		c.setType(EventType.view.name());
		c.setUrl("http://www.juuzhe.com");

		buttons.add(a);
		buttons.add(b);
		buttons.add(c);

		JsonMenu menu = new JsonMenu();
		menu.setButton(buttons);
		String jsonMenu = gson.toJson(menu);
		String result = HttpUtils.post(CREATE_MENU.concat(access_token), jsonMenu);
		Map<String, Object> map = gson.fromJson(result, Map.class);
		return "ok".equals(map.get("errmsg").toString());
	}

	/**
	 * 
	 * @Title: delete
	 * @Description: TODO(自定义菜单删除接口)
	 * @param @return
	 * @param @throws Exception 设定文件
	 * @return boolean 返回类型
	 * @throws
	 */
	@SuppressWarnings("unchecked")
	public static boolean delete() throws Exception {
		String access_token = AccessTokenCache.getInstance().getAccessToken();
		String result = HttpUtils.get(DELETE_MENU.concat(access_token));
		Map<String, Object> map = gson.fromJson(result, Map.class);
		return "ok".equals(map.get("errmsg").toString());
	}

	/**
	 * 
	 * @Title: query
	 * @Description: TODO(自定义菜单查询接口)
	 * @param @return
	 * @param @throws Exception 设定文件
	 * @return String 返回类型
	 * @throws
	 */
	public static String query() throws Exception {
		String access_token = AccessTokenCache.getInstance().getAccessToken();
		String result = HttpUtils.get(QUERY_MENU.concat(access_token));
		return result;
	}

	public static void main(String args[]) throws Exception {
		System.out.println(create());
	}
}
