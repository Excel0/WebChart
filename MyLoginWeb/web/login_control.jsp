<%-- 
    Document   : login_control
    Created on : 2017-4-18, 21:28:07
    Author     : 陌上心殇
--%>

<%@page import="javabean.TimeBean"%>
<%@page import="javax.swing.JOptionPane"%>
<%@page contentType="text/html;charset=gb2312"%>
<%@page import="javabean.BusinessBean" %>
<%
    String username=request.getParameter("login");
    String password=request.getParameter("password");
    if(username==null||password==null){
        response.sendRedirect("index.jsp");
    }        
    else{
        BusinessBean businessBean=new BusinessBean();
        boolean isValid=businessBean.valid(username, password);
        out.print(isValid);
        if(isValid){
            session.setAttribute("username", username);
            TimeBean tb=new TimeBean();
            String time=new java.sql.Timestamp(System.currentTimeMillis()).toString();
            if(tb.Update(username, time, "ontime")){
                response.sendRedirect("TheChatRoom.jsp");
                System.out.println("上线时间更新");
            }
            
        }else
            response.sendRedirect("index.jsp");
    }

%>