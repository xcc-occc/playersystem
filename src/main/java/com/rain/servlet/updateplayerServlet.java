package com.rain.servlet;

import com.rain.dao.PlayerDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet implementation class updateplayerServlet
 */
@WebServlet(urlPatterns = "/updateplayerServlet")
public class updateplayerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public updateplayerServlet() {
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
		//修改图书信息

		response.setContentType("text/html;charset=UTF-8");
		String card = request.getParameter("card");
		String name = request.getParameter("name");
		String type = request.getParameter("type");
		String autho = request.getParameter("autho");
		String press = request.getParameter("press");
		int num = Integer.parseInt(request.getParameter("num"));
		int bid = Integer.parseInt(request.getParameter("updatebid"));

		PlayerDao playerdao = new PlayerDao();
		playerdao.updateplayer(bid,card,name,type,autho,press,num);
		response.sendRedirect("/pro4/admin_player.jsp");
	}

}
