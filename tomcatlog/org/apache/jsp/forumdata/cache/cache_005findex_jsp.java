package org.apache.jsp.forumdata.cache;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.*;

public final class cache_005findex_jsp extends org.apache.jasper.runtime.HttpJspBase
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
request.setAttribute("announcements",_DCACHE_announcements);

      out.write('\n');

Map<String,String> _DCACHE_forumlinks= new HashMap<String,String>();
_DCACHE_forumlinks.put("forumlinks","a:1:{i:1;a:3:{s:7:\"content\";s:151:\"<h5><a href=\'http://www.JspRun.net\' target=\'_blank\'>JspRun! 官方论坛</a></h5><p>提供最新 JspRun! 产品新闻、软件下载与技术交流</p>\";s:4:\"logo\";s:15:\"images/logo.gif\";s:4:\"type\";s:1:\"1\";}}");
request.setAttribute("forumlinks",_DCACHE_forumlinks);

      out.write('\n');

Map<String,String> _DCACHE_advs= new HashMap<String,String>();
_DCACHE_advs.put("advs","");
request.setAttribute("advs",_DCACHE_advs);

      out.write('\n');

Map<String,String> _DCACHE_onlinelist= new HashMap<String,String>();
_DCACHE_onlinelist.put("3","online_moderator.gif");
_DCACHE_onlinelist.put("2","online_supermod.gif");
_DCACHE_onlinelist.put("1","online_admin.gif");
_DCACHE_onlinelist.put("0","online_member.gif");
_DCACHE_onlinelist.put("legend","<img src=\"images/common/online_admin.gif\" alt=\"\" /> 管理员 &nbsp; &nbsp; &nbsp; <img src=\"images/common/online_supermod.gif\" alt=\"\" /> 超级版主 &nbsp; &nbsp; &nbsp; <img src=\"images/common/online_moderator.gif\" alt=\"\" /> 版主 &nbsp; &nbsp; &nbsp; <img src=\"images/common/online_member.gif\" alt=\"\" /> 会员 &nbsp; &nbsp; &nbsp; ");
request.setAttribute("onlinelist",_DCACHE_onlinelist);

      out.write('\n');

Map<String,String> _DCACHE_tags= new HashMap<String,String>();
request.setAttribute("tags",_DCACHE_tags);

      out.write('\n');

Map<String,String> _DCACHE_birthdays_index= new HashMap<String,String>();
_DCACHE_birthdays_index.put("todaysbdays","");
request.setAttribute("birthdays_index",_DCACHE_birthdays_index);

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
