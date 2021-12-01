package com.dms.request;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
public class RequestForwardServlet extends HttpServlet {
    /*
    RequestDispatcher getRequestDispatcher (String path)	返回封装了某条路径所指定资源的 RequestDispatcher 对象。
    其中，参数 path 必须以“/”开头，用于表示当前 Web 应用的根目录。需要注意的是，WEB-INF 目录中的内容对 RequestDispatcher
    对象也是可见的。因此，传递给 getRequestDispatcher(String path) 方法的资源可以是 WEB-INF 目录中的文件


    forward(ServletRequest request,ServletResponse response)该方法用于将请求从一个 Servlet 传递给另一个 Web 资源
    在 Servlet 中，可以对请求做一个初步处理，然后通过调用这个方法，将请求传递给其他资源进行响应。需要注意的是，该方法必须在响应
    提交给客户端之前被调用，否则将抛出 IllegalStateException 异常
    include(ServletRequest request,ServletResponse response)该方法用于将其他的资源作为当前响应内容包含进来
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=utf-8");
        req.setAttribute("username", "张三");    // 将数据存储到request对象中
        RequestDispatcher dispatcher = req.getRequestDispatcher("/ResultServlet");
        dispatcher.forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }
}
/*
地址栏中显示的仍然是 RequestForwardServlet 的请求路径，但是浏览器却显示出了 ResultServlet 中要输出的内容。
因为请求转发是发生在服务器内部的行为，从 RequestForwardServlet 到 ResultServlet 属于一次请求，
在一次请求中是可以使用 request 属性进行数据共享的。
 */