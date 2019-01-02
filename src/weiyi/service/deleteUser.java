package weiyi.service;

import java.io.IOException;
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
 * Servlet implementation class deleteUser
 */
/**
 * 实现删除的servlet类
 * @author 广辉
 *
 */
@WebServlet("/DeleteUser")
public class deleteUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public deleteUser() {
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
			user.setUserName(req.getParameter("username"));		
			if(userdao.doRemove(user)){
				//System.out.println("删除成功！");
				req.getRequestDispatcher("/user_page.jsp");
			}
			else{
				System.out.println("删除失败！");
				req.getRequestDispatcher("/deleteinfopage.jsp").forward(req, resp);
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
