package com.dms.request;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
/*
1）setAttribute() 方法
该方法用于将一个对象与一个名称关联后存储到 ServletRequest 对象中

2）getAttribute() 方法
该方法用于从 ServletRequest 对象中返回指定名称的属性对象

3）removeAttribute() 方法
该方法用于从 ServletRequest 对象中删除指定名称的属性

4）getAttributeNames() 方法
该方法用于返回一个包含 ServletRequest 对象中的所有属性名的 Enumeration 对象

 */
public class RequestParamsServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取请求参数
        String name = req.getParameter("username");
        String password = req.getParameter("password");
        System.out.println("用户名" + name);
        System.out.println("密码" + password);
        // 获取参数名为"hobby"的值
        String[] hobbys = req.getParameterValues("hobby");
        System.out.println("爱好:");
        for (int i = 0; i < hobbys.length; i++) {
            System.out.println(hobbys[i] + ",");

        }
    }
}