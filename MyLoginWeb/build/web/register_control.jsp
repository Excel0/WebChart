<%-- 
    Document   : register_control
    Created on : 2017-4-18, 22:18:34
    Author     : Ä°ÉÏÐÄéä
--%>

<%@page import="javabean.TimeBean"%>
<%@page contentType="text/html;charset=gb2312"%>
<%@page import="javabean.BusinessBean" %>
<%
    String username = request.getParameter("username");
    String password1 = request.getParameter("password1");
    String password2 = request.getParameter("password2");
    String email = request.getParameter("email");
    String rand = (String) session.getAttribute("rand");
    String input = request.getParameter("rand");
    if (username.equals("") || password1.equals("") || password2.equals("") || ! password1.equals(password2) || ! rand.equals(input)) {
        response.sendRedirect("register.jsp");
    } else {
        BusinessBean businessBean = new BusinessBean();
        boolean isExist = businessBean.isExist(username);
        if (isExist == false) {
            businessBean.add(username, password1, email);
            
            String time=new java.sql.Timestamp(System.currentTimeMillis()).toString();
            TimeBean timeBean=new TimeBean();
            timeBean.Add(username, time, time);
            
            response.sendRedirect("index.jsp");
        } else {
            response.sendRedirect("register.jsp");
        }
    }
%>