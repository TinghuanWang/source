package org.apache.jsp.forumdata.cache;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.*;

public final class usergroup_005f10_jsp extends org.apache.jasper.runtime.HttpJspBase
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

Map<String,String> _DCACHE_usergroups= new HashMap<String,String>();
_DCACHE_usergroups.put("maxsizeperday","0");
_DCACHE_usergroups.put("allowmoduser","0");
_DCACHE_usergroups.put("maxmagicsweight","40");
_DCACHE_usergroups.put("attachextensions","chm, pdf, zip, rar, tar, gz, bzip2, gif, jpg, jpeg, png");
_DCACHE_usergroups.put("readaccess","10");
_DCACHE_usergroups.put("allowmassprune","0");
_DCACHE_usergroups.put("type","member");
_DCACHE_usergroups.put("allowinvisible","0");
_DCACHE_usergroups.put("allowhidecode","0");
_DCACHE_usergroups.put("raterange","");
_DCACHE_usergroups.put("allowcensorword","0");
_DCACHE_usergroups.put("allowinvite","0");
_DCACHE_usergroups.put("minrewardprice","1");
_DCACHE_usergroups.put("allowviewip","0");
_DCACHE_usergroups.put("maxattachsize","0");
_DCACHE_usergroups.put("groupid","10");
_DCACHE_usergroups.put("allowpostreward","0");
_DCACHE_usergroups.put("allowviewlog","0");
_DCACHE_usergroups.put("allowpostattach","0");
_DCACHE_usergroups.put("maxtradeprice","0");
_DCACHE_usergroups.put("allowgetattach","1");
_DCACHE_usergroups.put("alloweditpost","0");
_DCACHE_usergroups.put("reasonpm","0");
_DCACHE_usergroups.put("allowmodpost","0");
_DCACHE_usergroups.put("allowdelpost","0");
_DCACHE_usergroups.put("allowsigimgcode","0");
_DCACHE_usergroups.put("allowsetreadperm","0");
_DCACHE_usergroups.put("maxprice","0");
_DCACHE_usergroups.put("radminid","0");
_DCACHE_usergroups.put("grouptitle","新手上路");
_DCACHE_usergroups.put("system","private");
_DCACHE_usergroups.put("allowpostactivity","0");
_DCACHE_usergroups.put("allownickname","0");
_DCACHE_usergroups.put("creditshigher","0");
_DCACHE_usergroups.put("allowvote","0");
_DCACHE_usergroups.put("allowviewstats","0");
_DCACHE_usergroups.put("stars","1");
_DCACHE_usergroups.put("allowbanpost","0");
_DCACHE_usergroups.put("allowpostannounce","0");
_DCACHE_usergroups.put("maxrewardprice","0");
_DCACHE_usergroups.put("allowviewpro","1");
_DCACHE_usergroups.put("maxpostsperhour","0");
_DCACHE_usergroups.put("allowedituser","0");
_DCACHE_usergroups.put("allowbioimgcode","1");
_DCACHE_usergroups.put("allowmagics","1");
_DCACHE_usergroups.put("groupavatar","");
_DCACHE_usergroups.put("allowviewdigest","0");
_DCACHE_usergroups.put("tradestick","5");
_DCACHE_usergroups.put("maxpmnum","20");
_DCACHE_usergroups.put("allowbiobbcode","1");
_DCACHE_usergroups.put("allowsetattachperm","0");
_DCACHE_usergroups.put("allowuseblog","0");
_DCACHE_usergroups.put("alloweditpoll","0");
_DCACHE_usergroups.put("maxbiosize","0");
_DCACHE_usergroups.put("admingid","0");
_DCACHE_usergroups.put("disablepostctrl","0");
_DCACHE_usergroups.put("allowsigbbcode","1");
_DCACHE_usergroups.put("creditslower","50");
_DCACHE_usergroups.put("maxinviteday","0");
_DCACHE_usergroups.put("allowcusbbcode","0");
_DCACHE_usergroups.put("allowanonymous","0");
_DCACHE_usergroups.put("allowpost","1");
_DCACHE_usergroups.put("maxsigsize","80");
_DCACHE_usergroups.put("allowstickthread","0");
_DCACHE_usergroups.put("mintradeprice","1");
_DCACHE_usergroups.put("allowtransfer","0");
_DCACHE_usergroups.put("allowdirectpost","3");
_DCACHE_usergroups.put("allowmailinvite","0");
_DCACHE_usergroups.put("allowpostvideo","0");
_DCACHE_usergroups.put("allowreply","1");
_DCACHE_usergroups.put("inviteprice","0");
_DCACHE_usergroups.put("maxinvitenum","0");
_DCACHE_usergroups.put("allowbanuser","0");
_DCACHE_usergroups.put("allowmultigroups","0");
_DCACHE_usergroups.put("allowpostpoll","0");
_DCACHE_usergroups.put("allowcstatus","0");
_DCACHE_usergroups.put("allowpostdebate","1");
_DCACHE_usergroups.put("allowavatar","0");
_DCACHE_usergroups.put("allowbanip","0");
_DCACHE_usergroups.put("color","");
_DCACHE_usergroups.put("allowrefund","0");
_DCACHE_usergroups.put("disableperiodctrl","0");
_DCACHE_usergroups.put("allowhtml","0");
_DCACHE_usergroups.put("magicsdiscount","0");
_DCACHE_usergroups.put("allowsearch","1");
_DCACHE_usergroups.put("allowposttrade","1");
_DCACHE_usergroups.put("allowvisit","1");
request.setAttribute("usergroups",_DCACHE_usergroups);

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
