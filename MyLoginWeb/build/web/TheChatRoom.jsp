<%-- 
    Document   : TheChatRoom
    Created on : 2017-6-14, 10:51:01
    Author     : 陌上心殇
--%>

<%@page contentType="text/html" pageEncoding="UTF-8" language="java"%>
<%@page import="websocket.WebSocket" %>
<!DOCTYPE html>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>ChatRoom</title>
        <link rel="stylesheet" href="css/chat.css">
        <script type="text/javascript" src="./js/websocket.js"></script>
        <script type="text/javascript" src="./js/emojibutton.js"></script>
        <script type="text/javascript" src="./js/imagebutton.js"></script>
        <script type="text/javascript" src="./js/quitChatRoom.js"></script>
        <script src="./js/jquery-2.1.4.min.js"></script>
    </head>
    <body>
        <div id="container">
            <div id="header">
                <img id="headImg" src="<%=request.getContextPath()%>/images/kn.jpg">
                <div id="personalNote"> We are waiting for you ~ </div>
                <div id="peopleOnline">当前在线人数：<%out.print(WebSocket.getOnlineCount()+1);%></div> 
            </div>
            <!--<div id="content">-->
                <div id="message">
<!--                    <div class="receive-message">
                        <img class="rec-head-picture" src="<%=request.getContextPath()%>/images/theone.jpg"/>
                        <div class="rec-username">Theone</div>
                        <div class="rec-main-message">消息主体</div>
                    </div>
                    <div class="dispatch-message">
                        <div class="dis-main-message">消息主体</div>
                        <div class="dis-username">Theone</div>
                        <img class="dis-head-picture" src="<%=request.getContextPath()%>/images/Excel.png"/>
                    </div>
                    <div class="receive-message">
                        <img class="rec-head-picture" src="<%=request.getContextPath()%>/images/kn.jpg"/>
                        <div class="rec-username">Theone</div>
                        <div class="rec-main-message">消息主体</div>
                    </div>-->
                </div>
                <!--                <div id="userPanel">
                                    <div id="userBanner">当前在线用户数：</div>
                                    <div id="userList"></div>
                                </div>-->
            <!--</div>-->

            <div id="buttonPanel">
                <div id="emojiButton"><img class="functionButton" onclick="emoji()" src="<%=request.getContextPath()%>/images/timg.jpg"></div>
                <div id="pictureButton"><img class="functionButton" onclick="image()" src="<%=request.getContextPath()%>/images/tp.jpg"></div>
                <div id="messageButton"><img class="functionButton" onclick="download()" src="<%=request.getContextPath()%>/images/download.png"></div>
                <input type="file" id="imagefile" style="display: none" onchange="jsReadFiles(this.files)"/>
            </div>
            <div id="footer">
                <div id="msgInput"  contentEditable="true"></div>
                <div id="quitButton"><img class="functionButton" onclick="quitChatRoom()" src="<%=request.getContextPath()%>/images/quit.png"></div>
                <div id="sendButton"><img class="functionButton" onclick="send()" value="<%=(String)session.getAttribute("username")%>" src="<%=request.getContextPath()%>/images/send.png"></div>
            </div>
            <div id="emojiWrapper"></div>
            <input type="hidden" id="hid" value="<%=(String)session.getAttribute("username")%>"/>
        </div>
    </body>
</html>
