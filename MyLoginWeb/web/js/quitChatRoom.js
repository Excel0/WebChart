/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

function quitChatRoom(){
    closeWebSocket();
    //location="http://localhost:8080/MyLoginWeb/";
    self.location='quit.jsp';
}
