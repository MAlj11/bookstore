package MA.Filter;

/**
 * 装饰类
 * 装饰request中的getparameter方法
 * 目的：get方法的编码为utf—8
 */

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

public class MyResquest extends HttpServletRequestWrapper {

	private HttpServletRequest request;

	public MyResquest(HttpServletRequest request) {
		super(request);
		this.request = request;

	}

	@Override
	public String getParameter(String name) {
		try {
			String value = this.request.getParameter(name);
			if ("GET".equals(this.request.getMethod())) {
				value = new String(value.getBytes("iso-8859-1"), "utf-8");
			}
			return value;
		} catch (Exception e) {

			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
}
