package MA.biz.front.index.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import MA.Util.BaseServlet;
import MA.biz.front.index.service.IndexService;
import MA.biz.front.index.service.IndexServiceImpl;
import MA.entity.Books;
import MA.entity.types;

/**
 * 首页的Servlet
 * @author MA
 *
 */
public class indexServlet extends BaseServlet {
	

	IndexService ise = new IndexServiceImpl();

	
	/**
	 * 主页信息
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void showIndex(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		//从IndexService中取出types的信息
		List<types> Type = ise.QueryTypes();
		//将Type传入到request域对象中
		request.setAttribute("Type", Type);
		
		//页面转发到前台
		request.getRequestDispatcher("/jsp/front/index/shopIndex.jsp").forward(request, response);
        
	}
	
  /**
   * 在主页上显示图书
   */
	public void ShowBook(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//String typeid = request.getParameter("typeid");
		List<Books> books =ise.QueryBooks(null);
		request.setAttribute("books", books);
		request.getRequestDispatcher("/jsp/front/book/list.jsp").forward(request, response);
	}
	
	
      /**
       * 每本书具体的信息
       * @param request
       * @param response
       * @throws ServletException
       * @throws IOException
       */
	public void queryBook(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	    String id = request.getParameter("id");	
		Books book = ise.queryBook(id);
		request.setAttribute("book", book);
		request.getRequestDispatcher("/jsp/front/book/detail.jsp").forward(request, response);
	}
	


}
