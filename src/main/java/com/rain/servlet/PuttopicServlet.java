package com.rain.servlet;


import com.rain.bean.AdminBean;
import com.rain.dao.AdminDao;
import com.rain.dao.TopicDao;
import com.rain.dao.TopicDao;

import javax.jms.Topic;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Servlet implementation class AddTopicServlet
 */
@WebServlet(urlPatterns = "/PuttopicServlet")
public class PuttopicServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public PuttopicServlet() {
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

        
        TopicDao Topicdao = new TopicDao();


            HttpSession session = request.getSession();
            AdminBean admin = new AdminBean();
            //获取到存入session的用户id
            String aid = (String)session.getAttribute("aid");
            String content = request.getParameter("content");
            AdminDao admindao = new AdminDao();
            //通过aid获取到读者的信息
            admin = admindao.get_AidInfo2(aid);
            //将借阅记录存入数据表
            int id=admin.getAid();
            String username=admin.getUsername();
            String name=admin.getName();
            Topicdao.addTopic(id,username,name,content);
            response.sendRedirect("/pro4/put.jsp");

    }

}
