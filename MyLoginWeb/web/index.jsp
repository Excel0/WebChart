<%-- 
    Document   : index
    Created on : 2017-4-18, 21:07:56
    Author     : 陌上心殇
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
                <h1>用户登录</h1>
                <form action="login_control.jsp" method="post">
                    <p><input type="text" name="login" value="" placeholder="用户名"></p>
                    <p><input type="password" name="password" value="" placeholder="密码"></p>
                    <p class="remember_me">
                        <label>
                            <input type="checkbox" name="remember_me" id="remember_me">
                            记住密码
                        </label>
                    </p>
                    <p class="submit"><input type="submit" name="commit" value="登录"></p>
                </form>
            </div>
            <div class="login-help">
                <p><a href="register.jsp">注册新用户</a></p>
            </div>
        </section>
    </body>
</html>
