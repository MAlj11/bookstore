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
 * 用户模块的servlet
 * 
 * @author MA
 * 
 */
public class UserServlet extends BaseServlet {
    /**
     * 登录验证
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
	public void login(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		 userService us = new userServiceImpl();
		 //复制表单请求数据
		 Users user = WebUtil.copuRequestToBean(request, Users.class);
		 System.out.println(user);
		/**
		 * 验证码
		 */
		//拿到用户输入的验证码
	   String code = request.getParameter("code");
	   //拿到随机产生的是session域中的验证码
       HttpSession session = request.getSession(false);
       
       //两者做对比
       if(session!=null){
    	   String scode = (String)session.getAttribute("sCode");
    	   //System.out.println(scode);
    	   //System.out.println(code);
    	   if(!code.trim().equals(scode.trim())){
    		   request.setAttribute("msg", "验证码错误");
    		   request.getRequestDispatcher("/jsp/error.jsp").forward(request, response);
    		   return;
    	   }
       }
       
       /**
        * 用户名
        */
       
       System.out.println(user.getname());
       Users loginUser = us.login(user.getname());
       //System.out.println();
       if(loginUser!=null){
    	   String digestpassword = MD5Util.md5(user.getpassword());
    	   
    	   if(!loginUser.getpassword().equals(digestpassword)){
    		   request.setAttribute("msg", "用户名或密码错误");
    		   request.getRequestDispatcher("/jsp/error.jsp").forward(request, response);
    		   return;
    	   }
    	   else{
    		   //登录成功
				//把用户数据保存到session中
				session.setAttribute("user", loginUser);
				//清除当前session的验证码
				session.removeAttribute("sCode");
				//转到首页
				response.sendRedirect(request.getContextPath()+"/index?action=showIndex");
				return;
    	   }
    	   
       }
       else{
    	   request.setAttribute("msg", "用户名不存在");
		   request.getRequestDispatcher("/jsp/error.jsp").forward(request, response);
		   return;
       }
       /**
        * 密码
        */
        
	}
}
