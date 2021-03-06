package com.rain.servlet;

import com.rain.dao.TypeDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet implementation class AddplayerTypeServlet
 */
@WebServlet(urlPatterns = "/AddplayerTypeServlet")
public class AddplayerTypeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddplayerTypeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		doGet(request, response);
		//设置编码类型

		response.setContentType("text/html;charset=UTF-8");
		//获取图书分类的名称
		String name = request.getParameter("name");
		TypeDao typedao = new TypeDao();
		//调用函数存入图书分类信息
		typedao.addplayerType(name);
		response.sendRedirect("/pro4/admin_playertype.jsp");
	}

}
