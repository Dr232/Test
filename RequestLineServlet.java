package com.dms.request;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class RequestLineServlet extends HttpServlet {
    /*
    String getMethod()	该方法用于获取 HTTP 请求消息中的请求方式（如 GET、POST 等）

    String getRequestURI()	该方法用于获取请求行中的资源名称部分即位于 URL 的主机和端门之后
    参数部分之前的部分

    String getQueryString()	该方法用于获取请求行中的参数部分，也就是资源路径后问号（？）
    以后的所有内容

    String getContextPath()	该方法用于获取请求 URL 中属于 Web 应用程序的路径，
    这个路径以 / 开头，表示相对于整个 Web 站点的根目录，路径结尾不含 /。
    如果请求 URL 属于 Web 站点的根目录，那么返回结果为空字符串（""）

    String getServletPath()	该方法用于获取 Servlet 的名称或 Servlet 所映射的路径

    String getRemoteAddr()	该方法用于获取请求客户端的 IP 地址，其格式类似于 192.168.0.3

    String getRemoteHost()	该方法用于获取请求客户端的完整主机名，其格式类似于 pcl.mengma.com。
    需要注意的是，如果无法解析出客户机的完整主机名，那么该方法将会返回客户端的 IP 地址

    int getRemotePort()	该方法用于获取请求客户端网络连接的端口号

    String getLocaIAddr()	该方法用于获取 Web 服务器上接收当前请求网络连接的 IP 地址

    String getLocalName()
    该方法用于获取 Web 服务器上接收当前网络连接 IP 所对应的主机名

    int getLocalPort()	该方法用于获取 Web 服务器上接收当前网络连接的端口号

    String getServerName()	该方法用于获取当前请求所指向的主机名，
    即 HTTP 请求消息中 Host 头字段所对应的主机名部分

    int gctServcrPort()	该方法用于获取当前请求所连接的服务器端口号，
    即 HTTP 请求消息中 Host 头字段所对应的端口号部分

    StringBuffcr getRequestURL()该方法用于获取客户端发出请求时的完整 URL，
    包括协议、服务器名、端口号、 资源路径等信息，但不包括后面的査询参数部分。
    注意，getRequcstURL() 方法返冋的结果是 StringBuffer 类型，而不是 String 类型
    这样更便于对结果进行修改
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();
        // 获取请求行的相关信息

        out.println("getMethod : " + request.getMethod());
        out.println("getRequestURI:" + request.getRequestURL());
        out.println("getQueryString:" + request.getQueryString());
        out.println("getContextPath:" + request.getContextPath());
        out.println("getServletPath:" + request.getServletPath());
        out.println("getRemoteAddr : " + request.getRemoteAddr());
        out.println("getRemoteHost : " + request.getRemoteHost());
        out.println("getRemotePort : " + request.getRemotePort());
        out.println("getLocalAddr : " + request.getLocalAddr());
        out.println("getLocalName : " + request.getLocalName());
        out.println("getLocalPort : " + request.getLocalPort());
        out.println("getServerName : " + request.getServerName());
        out.println("getServerPort : " + request.getServerPort());
        out.println("getRequestURL : " + request.getRequestURL());
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }
}
