package weiyi.service;

import java.io.IOException;
import java.io.PrintWriter;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import weiyi.dao.proxy.UserDAOProxy;
import weiyi.dao.vo.User;

/**
 * Servlet implementation class getUserNameservice
 */
/**
 * 创建获取用户的servlet类
 * @author 广辉
 *
 */
@WebServlet("/GetUserName")
public class getUserNameservice extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public getUserNameservice() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		req.setCharacterEncoding("utf-8");
		resp.setCharacterEncoding("utf-8");
		UserDAOProxy userdao = null;

		try {
			userdao = new UserDAOProxy();	
			User user=new User();
			user.setEmail(req.getParameter("email"));
			String username;
			username=userdao.getUserName(user);
			
			if(username.isEmpty()){
				System.out.println("查找失败！");
				req.getRequestDispatcher("/foundmm.jsp").forward(req, resp);
			}
			else{
				//System.out.println("查找成功！");
				PrintWriter out=resp.getWriter();
				out.println("<html>");
				out.println("<head><title>找回密码</title>");
				out.println("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">");
				out.println("<link rel=\"stylesheet\" href=\"./css/form.css\" /></head>");
				out.println("<body>");
				out.println("<div class='container'><p class='title'>基于浏览器的身份验证登录系统</p>");
				out.println("<div class='box'>	<div id='register_box'>");
				out.println("<h2>您的登录名是："+username+"!</h2><br><h2>邮件已发送！请注意查看！！！</h2><br>");
				out.println("<pre><a href='login.jsp'>返回登录页面</a></pre></div></div></div>");
				out.println("</body></html>");
				out.flush();
				out.close();
				//req.getRequestDispatcher("/test.jsp").forward(req, resp);
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
