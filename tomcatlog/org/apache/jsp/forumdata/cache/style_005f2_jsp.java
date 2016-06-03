package org.apache.jsp.forumdata.cache;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.*;

public final class style_005f2_jsp extends org.apache.jasper.runtime.HttpJspBase
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

Map<String,String> _DCACHE_styles= new HashMap<String,String>();
_DCACHE_styles.put("BORDERWIDTH","1px");
_DCACHE_styles.put("POSTMINHEIGHT","120");
_DCACHE_styles.put("BGCODE","background: #FFF");
_DCACHE_styles.put("SMFONTSIZE","0.83em");
_DCACHE_styles.put("BORDERCOLOR","#9DB3C5");
_DCACHE_styles.put("HEADERMENU","#FFF");
_DCACHE_styles.put("MAINTABLEWIDTH","98%");
_DCACHE_styles.put("COMMONBOXBORDER","#E8E8E8");
_DCACHE_styles.put("IMGDIR","images/Classic");
_DCACHE_styles.put("STYLEID","2");
_DCACHE_styles.put("HEADERCOLOR","#2F589C");
_DCACHE_styles.put("TPLDIR","./templates/Classic");
_DCACHE_styles.put("MSGBIGSIZE","16px");
_DCACHE_styles.put("BOXSPACE","10px");
_DCACHE_styles.put("NAME","经典风格");
_DCACHE_styles.put("MSGFONTSIZE","14px");
_DCACHE_styles.put("BOLD","bold");
_DCACHE_styles.put("BOARDIMG","images/Classic/logo.gif");
_DCACHE_styles.put("FONTSIZE","12px");
_DCACHE_styles.put("STYPEID","1");
_DCACHE_styles.put("HEADERTEXT","#FFF");
_DCACHE_styles.put("FONT","Helvetica, Arial, sans-serif");
_DCACHE_styles.put("CATCOLOR","#E8F3FD");
_DCACHE_styles.put("CATBGCODE","background: #E8F3FD url(\"images/Classic/cat_bg.gif\")");
_DCACHE_styles.put("HEADERMENUBGCODE","background: #FFF url(\"images/Classic/menu_bg.gif\")");
_DCACHE_styles.put("HEADERMENUTEXT","#333");
_DCACHE_styles.put("TABLEBG","#FFF");
_DCACHE_styles.put("NOTICEBG","#FFFFF2");
_DCACHE_styles.put("NOTICETEXT","#090");
_DCACHE_styles.put("NOTICEBORDER","#EDEDCE");
_DCACHE_styles.put("CATBORDER","#CAD9EA");
_DCACHE_styles.put("LINK","#000");
_DCACHE_styles.put("TEXT","#666");
_DCACHE_styles.put("LIGHTTEXT","#999");
_DCACHE_styles.put("BGBORDER","#CAD9EA");
_DCACHE_styles.put("PORTALBOXBGCODE","background: #FFF url(\"images/Classic/portalbox_bg.gif\")");
_DCACHE_styles.put("TABLESPACE","1px");
_DCACHE_styles.put("BGCOLOR","#FFF");
_DCACHE_styles.put("MAXSIGROWS","100");
_DCACHE_styles.put("ALTBG1","#F5FAFE");
_DCACHE_styles.put("ALTBG2","#E8F3FD");
_DCACHE_styles.put("AVAILABLE","");
_DCACHE_styles.put("MSGSMALLSIZE","12px");
_DCACHE_styles.put("SMFONT","Verdana, Arial, Helvetica, sans-serif");
_DCACHE_styles.put("TABLETEXT","#000");
_DCACHE_styles.put("FRAMEBGCOLOR","frame_bg.gif");
_DCACHE_styles.put("TEMPLATEID","2");
_DCACHE_styles.put("INPUTBORDER","#DDD");
_DCACHE_styles.put("BOARDLOGO","<img src=\"images/Classic/logo.gif\" border=\"0\" />");
_DCACHE_styles.put("HEADERBGCODE","background: #2F589C url(\"images/Classic/header_bg.gif\")");
_DCACHE_styles.put("HIGHLIGHTLINK","#069");
_DCACHE_styles.put("COMMONBOXBG","#F7F7F7");
request.setAttribute("styles",_DCACHE_styles);

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
