/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

var websocket = null;
var mymessage = "";
var flag = false;
//判断当前浏览器是否支持WebSocket
if ('WebSocket' in window) {
    websocket = new WebSocket("ws://localhost:8080/MyLoginWeb/websocket");
} else {
    alert('当前浏览器 Not support websocket')
}

//连接发生错误的回调方法
websocket.onerror = function () {
    setMessageInnerHTML("WebSocket连接发生错误");
};

//连接成功建立的回调方法
websocket.onopen = function () {
    setMessageInnerHTML("WebSocket连接成功");
}

//        //接收到消息的回调方法
websocket.onmessage = function (event) {
    setMessageInnerHTML(event.data);
}

//连接关闭的回调方法
websocket.onclose = function () {
    setMessageInnerHTML("WebSocket连接关闭");
}

//监听窗口关闭事件，当窗口关闭时，主动去关闭websocket连接，防止连接还没断开就关闭窗口，server端会抛异常。
window.onbeforeunload = function () {
    closeWebSocket();
    self.location = 'quit.jsp';
}

//将消息显示在网页上
function setMessageInnerHTML(innerHTML) {
    var msg = JSON.parse(innerHTML);
    var name = msg.name;
    var message = msg.message;
    var username = document.getElementById('hid').value;
    if (message == mymessage) {
        var dispatch = "<div class='dispatch-message'>";
        var disMsg = "<div class='dis-main-message'>" + message + "</div>";
        var disName = "<div class='dis-username'>" + name + "</div>";
        var disHead = "<img class='dis-head-picture' src='./images/" + name + ".png'/>"
        document.getElementById('message').innerHTML += dispatch + disMsg + disName + disHead;
    } else if (username != name) {
        var receive = "<div class='receive-message'>";
        var recHead = "<img class='rec-head-picture' src='./images/" + name + ".png'/>";
        var recName = "<div class='rec-username'>" + name + "</div>";
        var recMsg = "<div class='rec-main-message'>" + message + "</div>";
        document.getElementById('message').innerHTML += receive + recHead + recName + recMsg;
    }
}

//关闭WebSocket连接
function closeWebSocket() {
    websocket.close();
}

//发送消息
function send() {
    mymessage = document.getElementById('msgInput').innerHTML;
    var name = document.getElementById('hid').value;
    var msg = {
        name: "", message: ""
    };
    msg.name = name;
    msg.message = mymessage;
    console.log(JSON.stringify(msg));
    websocket.send(JSON.stringify(msg));
    document.getElementById('msgInput').innerHTML = "";
}

//离线消息下载
function download() {
    //发送特殊消息至后台，使后台查询离线消息并发送至前端
    if (!flag) {
        var name = document.getElementById('hid').value;
        var msg = {
            name: "", message: ""
        };
        msg.name = name;
        msg.message = "/zzy/初始信息/2017/6/22";
        console.log("下载离线消息" + JSON.stringify(msg));
        websocket.send(JSON.stringify(msg));
        flag=true;
    }

}