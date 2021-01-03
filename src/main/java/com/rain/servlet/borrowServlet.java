package com.rain.servlet;

import com.rain.bean.AdminBean;
import com.rain.dao.AdminDao;
import com.rain.dao.PlayerDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Servlet implementation class borrowServlet
 */
@WebServlet(urlPatterns = "/borrowServlet")
public class borrowServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public borrowServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		//设置编码类型

		response.setContentType("text/html;charset=UTF-8");
		PlayerDao playerdao = new PlayerDao();
			//获取图书id
			int bid = Integer.parseInt(request.getParameter("bid"));
			HttpSession session = request.getSession();
			AdminBean admin = new AdminBean();
			//获取到存入session的aid读者id
			String aid = (String) session.getAttribute("aid");
			AdminDao admindao = new AdminDao();
			//通过aid获取到用户的信息
			admin = admindao.get_AidInfo2(aid);
			//将收藏记录存入数据表
			playerdao.borrowplayer(bid, admin);
			response.sendRedirect("/pro4/select.jsp");


		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
