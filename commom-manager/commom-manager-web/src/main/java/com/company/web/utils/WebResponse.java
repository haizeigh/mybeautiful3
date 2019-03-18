package com.company.web.utils;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by v-leiyu on 2018/3/30.
 */
public class WebResponse {
	public static void notifyReturn(HttpServletResponse response,String value){
		try {
			response.setCharacterEncoding("utf-8");
			response.setContentType("text/xml");
			response.getWriter().print(value);
			response.getWriter().flush();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}
