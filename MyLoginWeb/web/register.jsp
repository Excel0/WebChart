<%-- 
    Document   : register
    Created on : 2017-4-18, 22:07:21
    Author     : 陌上心殇
--%>

<%@page contentType="text/html;charset=gb2312"%>
<%@page import="java.util.*" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Register Page</title>
        <script language="javascript">
            function loadimage() {
                document.getElementById("randImage").src = "image.jsp?" + Math.random();
            }
        </script>
        <link rel="stylesheet" href="css/style.css">
    </head>
    <body>
        <section class="container">
            <div class="login">
                <h1>注册窗口</h1>
                <form action="register_control.jsp" method="post">
                    <p><input type="text" name="username" onkeyup="value = value.replace(/[^\w\.\/\@]/g, '')" value="" placeholder="用户名"</p>
                    <p><input type="password" name="password1" value="" placeholder="密码"></p>
                    <p><input type="password" name="password2" value="" placeholder="确认密码"></p>
                    <p><input type="text" name="email" value="" placeholder="E-mail"</p>
                    <p class="login-help"><img alt="code..." name="randImage" id="randImage" src="image.jsp" width="200" height="50" border="1" align="absmiddle"><a href="javascript:loadimage();">刷新</a></p>
                    <p><input type="text" name="rand" placeholder="验证码"></p>
                    <p class="submit"><input type="submit" name="commit" value="提交"></p>
                </form>
            </div>
            <div class="login-help">
                <p><a href="index.jsp">返回登录界面</a></p>
            </div>
        </section>
    </body>
</html>
