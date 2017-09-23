<%-- 
    Document   : quit
    Created on : 2017-6-22, 8:23:54
    Author     : 陌上心殇
--%>

<%@page import="javabean.TimeBean"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
    TimeBean tb=new TimeBean();
    String time=new java.sql.Timestamp(System.currentTimeMillis()).toString();
    String name=(String)session.getAttribute("username");
    if(tb.Update(name, time, "downtime")){
        System.out.println("下线时间更新");
        response.sendRedirect("index.jsp");
    }else{
        response.sendRedirect("TheChatRoom.jsp");
    }   
%>