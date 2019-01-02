package weiyi.service;

import java.io.IOException;
import java.io.PrintWriter;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import weiyi.dao.proxy.UserDAOProxy;
import weiyi.dao.vo.User;

/**
 * Servlet implementation class UserServiceImp
 */
/**
 * 实现登录的servlet类
 * @author 广辉
 *
 */
@WebServlet("/Login")
public class loginUserService extends HttpServlet{
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public loginUserService() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());\
		req.setCharacterEncoding("utf-8");
		resp.setCharacterEncoding("utf-8");
		UserDAOProxy userdao = null;
		String name=req.getParameter("username");
		String pass=req.getParameter("password");
		String al=req.getParameter("autoLogin");
		User user=new User();
		
		try {
			userdao = new UserDAOProxy();
			user=userdao.findByName(name);
			if(user==null) {
				System.out.println("登录失败1！");
				PrintWriter out=resp.getWriter();
				out.println("<html>");
				out.println("<head><title>登录失败页面</title>");
				out.println("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">");
				out.println("<link rel=\"stylesheet\" href=\"./css/form.css\" /></head>");
				out.println("<body>");
				out.println("<div class='container'><p class='title'>基于浏览器的身份验证登录系统</p>");
				out.println("<div class='box'>	<div id='register_box'>");
				out.println("<h2>登录失败！！！</h2><br>");
				out.println("<pre><a href='login.jsp'>返回登录页面</a></pre></div></div></div>");
				out.println("</body></html>");
				out.flush();
				out.close();
				//req.getRequestDispatcher("/login.jsp").forward(req, resp);
			}else {
				String md5=user.getPassword();
				if(!userdao.getMD5(pass).equals(md5) || md5==""){
					System.out.println("登录失败2！");
					PrintWriter out=resp.getWriter();
					out.println("<html>");
					out.println("<head><title>登录失败页面</title>");
					out.println("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">");
					out.println("<link rel=\"stylesheet\" href=\"./css/form.css\" /></head>");
					out.println("<body>");
					out.println("<div class='container'><p class='title'>基于浏览器的身份验证登录系统</p>");
					out.println("<div class='box'>	<div id='register_box'>");
					out.println("<h2>登录失败！！！</h2><br>");
					out.println("<pre><a href='login.jsp'>返回登录页面</a></pre></div></div></div>");
					out.println("</body></html>");
					out.flush();
					out.close();
					//req.getRequestDispatcher("/login.jsp").forward(req, resp);
				}
				else{
					//System.out.println("登陆成功！");
					if("save".equals(al)) {
						req.getSession().setAttribute("userSession", user.getUserName());
		                Cookie userCookie = new Cookie("userCookie",name+"#"+pass);
		                userCookie.setMaxAge(60 * 60 * 24); 
		                resp.addCookie(userCookie);
					}
					req.getRequestDispatcher("/user_page.jsp").forward(req, resp);
				}
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
}