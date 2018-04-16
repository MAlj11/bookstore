package MA.biz.front.user.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import MA.Util.BaseServlet;
import MA.Util.MD5Util;
import MA.Util.WebUtil;
import MA.biz.front.user.service.userService;
import MA.biz.front.user.service.userServiceImpl;
import MA.entity.Users;

/**
 * �û�ģ���servlet
 * 
 * @author MA
 * 
 */
public class UserServlet extends BaseServlet {
    /**
     * ��¼��֤
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
	public void login(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		 userService us = new userServiceImpl();
		 //���Ʊ���������
		 Users user = WebUtil.copuRequestToBean(request, Users.class);
		 System.out.println(user);
		/**
		 * ��֤��
		 */
		//�õ��û��������֤��
	   String code = request.getParameter("code");
	   //�õ������������session���е���֤��
       HttpSession session = request.getSession(false);
       
       //�������Ա�
       if(session!=null){
    	   String scode = (String)session.getAttribute("sCode");
    	   //System.out.println(scode);
    	   //System.out.println(code);
    	   if(!code.trim().equals(scode.trim())){
    		   request.setAttribute("msg", "��֤�����");
    		   request.getRequestDispatcher("/jsp/error.jsp").forward(request, response);
    		   return;
    	   }
       }
       
       /**
        * �û���
        */
       
       System.out.println(user.getname());
       Users loginUser = us.login(user.getname());
       //System.out.println();
       if(loginUser!=null){
    	   String digestpassword = MD5Util.md5(user.getpassword());
    	   
    	   if(!loginUser.getpassword().equals(digestpassword)){
    		   request.setAttribute("msg", "�û������������");
    		   request.getRequestDispatcher("/jsp/error.jsp").forward(request, response);
    		   return;
    	   }
    	   else{
    		   //��¼�ɹ�
				//���û����ݱ��浽session��
				session.setAttribute("user", loginUser);
				//�����ǰsession����֤��
				session.removeAttribute("sCode");
				//ת����ҳ
				response.sendRedirect(request.getContextPath()+"/index?action=showIndex");
				return;
    	   }
    	   
       }
       else{
    	   request.setAttribute("msg", "�û���������");
		   request.getRequestDispatcher("/jsp/error.jsp").forward(request, response);
		   return;
       }
       /**
        * ����
        */
        
	}
}
