package com.rain.servlet;

import com.rain.bean.TopicBean;
import com.rain.dao.TopicDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet implementation class borrowServlet
 */
@WebServlet(urlPatterns = "/jubaServlet")
public class jubaServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public jubaServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
        //设置编码

         response.setContentType("text/html;charset=UTF-8");
         TopicDao Topicdao = new TopicDao();

         String id=request.getParameter("tid");


         int tid = 0;
         if(id!=null){
             tid = Integer.parseInt(id);
         }

         System.out.println(tid);
         TopicBean topic=Topicdao.get_Topicinfo(tid);
        Topicdao.addjb(tid,topic);
         response.sendRedirect("/pro4/put.jsp");

    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        doGet(request, response);

    }

}
