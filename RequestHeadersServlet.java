package com.dms.request;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

public class RequestHeadersServlet extends HttpServlet {
    /*
    String getHeader(String name)该方法用于获取一个指定头字段的值，如果请求消息中没有包含指定的
    头字段，则 getHeader() 方法返回 null；如果请求消息中包含多个指定名称的头字段，
    则 getHeader() 方法返回其中第一个头字段的值

    Enumeration getHeaders(String name)
    该方法返回一个 Enumeration 集合对象，该集合对象由请求消息中出现的某个指定名称的所有头字段值组成。
    在多数情况下，一个头字段名在请求消息中只出现一次，但有时可能会出现多次

    Enumeration getHeaderNames()	该方法用于获取一个包含所有请求头字段的 Enumeration 对象

    int getIntHeader(String name)	该方法用于获取指定名称的头字段，并且将其值转为 int 类型。
    需要注意的是，如果指定名称的头字段不存在，则返回值为 -1；如果获取到的头字段的值不能转为 int 类型，
    则将发生 NumberFormatException 异常

    long getDateHeader(String name)	该方法用于获取指定头字段的值，并将其按 GMT 时间格式转换为
    一个代表日期/时间的长整数，该长整数是自 1970 年 1 月 1 日 0 时 0 分 0 秒
    算起的以毫秒为单位的时间值

    String getContentType()	该方法用于获取 Content-Type 头字段的值，结果为 String 类型

    int getContentLength()	该方法用于获取 Content-Length 头字段的值，结果为 int 类型

    String getCharacterEncoding()	该方法用于返回请求消息的实体部分的字符集编码，
    通常是从 Content-Type 头字段中进行提取，结果为 String 类型
     */
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        // 获取请求消息中的所有头字段
        Enumeration headerNames = request.getHeaderNames();
        //用循环遍历所有请求头，并通过 getHeader() 方法获取一个指定名称的头字段
        while (headerNames.hasMoreElements()) {
            String headerName = (String) headerNames.nextElement();
            out.print(headerName + ":" + request.getHeader(headerName)
                    + "<br />");
        }
    }
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}
