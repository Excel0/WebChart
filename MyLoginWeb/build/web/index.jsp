<%-- 
    Document   : index
    Created on : 2017-4-18, 21:07:56
    Author     : İ������
--%>

<%@page contentType="text/html;charset=gb2312" %>
<%@page import="java.util.*"%>
<%@page language="java" import="java.sql.*" errorPage="" %> 
<!DOCTYPE html>
<html>
    <head>
        <title>Login Page</title>
        <link rel="stylesheet" href="css/style.css">
    </head>
    <body>
        <section class="container">
            <div class="login">
                <h1>�û���¼</h1>
                <form action="login_control.jsp" method="post">
                    <p><input type="text" name="login" value="" placeholder="�û���"></p>
                    <p><input type="password" name="password" value="" placeholder="����"></p>
                    <p class="remember_me">
                        <label>
                            <input type="checkbox" name="remember_me" id="remember_me">
                            ��ס����
                        </label>
                    </p>
                    <p class="submit"><input type="submit" name="commit" value="��¼"></p>
                </form>
            </div>
            <div class="login-help">
                <p><a href="register.jsp">ע�����û�</a></p>
            </div>
        </section>
    </body>
</html>
