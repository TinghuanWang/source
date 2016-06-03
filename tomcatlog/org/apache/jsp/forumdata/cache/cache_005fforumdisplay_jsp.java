package org.apache.jsp.forumdata.cache;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.*;

public final class cache_005fforumdisplay_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List _jspx_dependants;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.AnnotationProcessor _jsp_annotationprocessor;

  public Object getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_annotationprocessor = (org.apache.AnnotationProcessor) getServletConfig().getServletContext().getAttribute(org.apache.AnnotationProcessor.class.getName());
  }

  public void _jspDestroy() {
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

      out.write('\n');
      out.write('\n');

Map<String,String> _DCACHE_announcements= new HashMap<String,String>();
_DCACHE_announcements.put("announcements","N;");
request.setAttribute("announcements",_DCACHE_announcements);

      out.write('\n');

Map<String,String> _DCACHE_announcement= new HashMap<String,String>();
request.setAttribute("announcement",_DCACHE_announcement);

      out.write('\n');

Map<String,String> _DCACHE_globalstick= new HashMap<String,String>();
_DCACHE_globalstick.put("globalstick","N;");
request.setAttribute("globalstick",_DCACHE_globalstick);

      out.write('\n');

Map<String,String> _DCACHE_onlinelist= new HashMap<String,String>();
_DCACHE_onlinelist.put("3","online_moderator.gif");
_DCACHE_onlinelist.put("2","online_supermod.gif");
_DCACHE_onlinelist.put("1","online_admin.gif");
_DCACHE_onlinelist.put("0","online_member.gif");
_DCACHE_onlinelist.put("legend","<img src=\"images/common/online_admin.gif\" alt=\"\" /> 管理员 &nbsp; &nbsp; &nbsp; <img src=\"images/common/online_supermod.gif\" alt=\"\" /> 超级版主 &nbsp; &nbsp; &nbsp; <img src=\"images/common/online_moderator.gif\" alt=\"\" /> 版主 &nbsp; &nbsp; &nbsp; <img src=\"images/common/online_member.gif\" alt=\"\" /> 会员 &nbsp; &nbsp; &nbsp; ");
request.setAttribute("onlinelist",_DCACHE_onlinelist);

      out.write('\n');

Map<String,String> _DCACHE_advs= new HashMap<String,String>();
_DCACHE_advs.put("advs","");
request.setAttribute("advs",_DCACHE_advs);

      out.write('\n');
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try { out.clearBuffer(); } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else log(t.getMessage(), t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
