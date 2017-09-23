package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import websocket.WebSocket;

public final class TheChatRoom_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>ChatRoom</title>\n");
      out.write("        <link rel=\"stylesheet\" href=\"css/chat.css\">\n");
      out.write("        <script type=\"text/javascript\" src=\"./js/websocket.js\"></script>\n");
      out.write("        <script type=\"text/javascript\" src=\"./js/emojibutton.js\"></script>\n");
      out.write("        <script type=\"text/javascript\" src=\"./js/imagebutton.js\"></script>\n");
      out.write("        <script type=\"text/javascript\" src=\"./js/quitChatRoom.js\"></script>\n");
      out.write("        <script src=\"./js/jquery-2.1.4.min.js\"></script>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <div id=\"container\">\n");
      out.write("            <div id=\"header\">\n");
      out.write("                <img id=\"headImg\" src=\"");
      out.print(request.getContextPath());
      out.write("/images/kn.jpg\">\n");
      out.write("                <div id=\"personalNote\"> We are waiting for you ~ </div>\n");
      out.write("                <div id=\"peopleOnline\">当前在线人数：");
out.print(WebSocket.getOnlineCount()+1);
      out.write("</div> \n");
      out.write("            </div>\n");
      out.write("            <!--<div id=\"content\">-->\n");
      out.write("                <div id=\"message\">\n");
      out.write("<!--                    <div class=\"receive-message\">\n");
      out.write("                        <img class=\"rec-head-picture\" src=\"");
      out.print(request.getContextPath());
      out.write("/images/theone.jpg\"/>\n");
      out.write("                        <div class=\"rec-username\">Theone</div>\n");
      out.write("                        <div class=\"rec-main-message\">消息主体</div>\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"dispatch-message\">\n");
      out.write("                        <div class=\"dis-main-message\">消息主体</div>\n");
      out.write("                        <div class=\"dis-username\">Theone</div>\n");
      out.write("                        <img class=\"dis-head-picture\" src=\"");
      out.print(request.getContextPath());
      out.write("/images/Excel.png\"/>\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"receive-message\">\n");
      out.write("                        <img class=\"rec-head-picture\" src=\"");
      out.print(request.getContextPath());
      out.write("/images/kn.jpg\"/>\n");
      out.write("                        <div class=\"rec-username\">Theone</div>\n");
      out.write("                        <div class=\"rec-main-message\">消息主体</div>\n");
      out.write("                    </div>-->\n");
      out.write("                </div>\n");
      out.write("                <!--                <div id=\"userPanel\">\n");
      out.write("                                    <div id=\"userBanner\">当前在线用户数：</div>\n");
      out.write("                                    <div id=\"userList\"></div>\n");
      out.write("                                </div>-->\n");
      out.write("            <!--</div>-->\n");
      out.write("\n");
      out.write("            <div id=\"buttonPanel\">\n");
      out.write("                <div id=\"emojiButton\"><img class=\"functionButton\" onclick=\"emoji()\" src=\"");
      out.print(request.getContextPath());
      out.write("/images/timg.jpg\"></div>\n");
      out.write("                <div id=\"pictureButton\"><img class=\"functionButton\" onclick=\"image()\" src=\"");
      out.print(request.getContextPath());
      out.write("/images/tp.jpg\"></div>\n");
      out.write("                <div id=\"messageButton\"><img class=\"functionButton\" src=\"");
      out.print(request.getContextPath());
      out.write("/images/download.png\"></div>\n");
      out.write("                <input type=\"file\" id=\"imagefile\" style=\"display: none\" onchange=\"jsReadFiles(this.files)\"/>\n");
      out.write("            </div>\n");
      out.write("            <div id=\"footer\">\n");
      out.write("                <div id=\"msgInput\"  contentEditable=\"true\"></div>\n");
      out.write("                <div id=\"quitButton\"><img class=\"functionButton\" onclick=\"quitChatRoom()\" src=\"");
      out.print(request.getContextPath());
      out.write("/images/quit.png\"></div>\n");
      out.write("                <div id=\"sendButton\"><img class=\"functionButton\" onclick=\"send()\" value=\"");
      out.print((String)session.getAttribute("username"));
      out.write("\" src=\"");
      out.print(request.getContextPath());
      out.write("/images/send.png\"></div>\n");
      out.write("            </div>\n");
      out.write("            <div id=\"emojiWrapper\"></div>\n");
      out.write("            <input type=\"hidden\" id=\"hid\" value=\"");
      out.print((String)session.getAttribute("username"));
      out.write("\"/>\n");
      out.write("        </div>\n");
      out.write("    </body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
