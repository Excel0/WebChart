<%-- 
    Document   : register
    Created on : 2017-4-18, 22:07:21
    Author     : İ������
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
                <h1>ע�ᴰ��</h1>
                <form action="register_control.jsp" method="post">
                    <p><input type="text" name="username" onkeyup="value = value.replace(/[^\w\.\/\@]/g, '')" value="" placeholder="�û���"</p>
                    <p><input type="password" name="password1" value="" placeholder="����"></p>
                    <p><input type="password" name="password2" value="" placeholder="ȷ������"></p>
                    <p><input type="text" name="email" value="" placeholder="E-mail"</p>
                    <p class="login-help"><img alt="code..." name="randImage" id="randImage" src="image.jsp" width="200" height="50" border="1" align="absmiddle"><a href="javascript:loadimage();">ˢ��</a></p>
                    <p><input type="text" name="rand" placeholder="��֤��"></p>
                    <p class="submit"><input type="submit" name="commit" value="�ύ"></p>
                </form>
            </div>
            <div class="login-help">
                <p><a href="index.jsp">���ص�¼����</a></p>
            </div>
        </section>
    </body>
</html>
