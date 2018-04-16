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
 * ��ҳ��Servlet
 * @author MA
 *
 */
public class indexServlet extends BaseServlet {
	

	IndexService ise = new IndexServiceImpl();

	
	/**
	 * ��ҳ��Ϣ
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void showIndex(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		//��IndexService��ȡ��types����Ϣ
		List<types> Type = ise.QueryTypes();
		//��Type���뵽request�������
		request.setAttribute("Type", Type);
		
		//ҳ��ת����ǰ̨
		request.getRequestDispatcher("/jsp/front/index/shopIndex.jsp").forward(request, response);
        
	}
	
  /**
   * ����ҳ����ʾͼ��
   */
	public void ShowBook(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//String typeid = request.getParameter("typeid");
		List<Books> books =ise.QueryBooks(null);
		request.setAttribute("books", books);
		request.getRequestDispatcher("/jsp/front/book/list.jsp").forward(request, response);
	}
	
	
      /**
       * ÿ����������Ϣ
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
