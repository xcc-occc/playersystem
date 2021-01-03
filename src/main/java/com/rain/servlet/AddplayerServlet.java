package com.rain.servlet;

import com.rain.dao.PlayerDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet implementation class AddplayerServlet
 */
@WebServlet(urlPatterns = "/AddplayerServlet")
public class AddplayerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddplayerServlet() {
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
		//获取要添加图书的信息
		String card = request.getParameter("card");
		String name = request.getParameter("name");
		String type = request.getParameter("type");
		String autho = request.getParameter("autho");
		String press = request.getParameter("press");
		int num = Integer.parseInt(request.getParameter("num"));
		PlayerDao playerdao = new PlayerDao();
		//调用函数，存入图书
		playerdao.addplayer(card,name,type,autho,press,num);
		response.sendRedirect("/pro4/admin_player.jsp");
	}

}
