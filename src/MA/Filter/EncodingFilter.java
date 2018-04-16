package MA.Filter;
/**
 * 过滤器类
 */

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

public class EncodingFilter implements Filter {

	public void destroy() {
		// TODO Auto-generated method stub

	}

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
        //修改post、get的编码为utf—8
		
		//post方式
		request.setCharacterEncoding("utf-8");
		//get方式
		MyResquest myrequest = new MyResquest((HttpServletRequest) request);

		chain.doFilter(myrequest, response);

	}

	public void init(FilterConfig arg0) throws ServletException {
	

	}

}
