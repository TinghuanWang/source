package org.apache.jsp.include.crons;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.*;
import cn.jsprun.utils.Cache;
import cn.jsprun.utils.BeanFactory;
import cn.jsprun.utils.DataParse;
import cn.jsprun.utils.Mail;
import cn.jsprun.utils.ForumInit;
import cn.jsprun.utils.Common;
import cn.jsprun.dao.CronsDao;
import java.sql.Connection;
import org.apache.struts.util.MessageResources;
import java.util.Locale;

public final class birthdays_005fdaily_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

 
	private String tablepre = "jrun_"; 
	private CronsDao cronsDao = ((CronsDao)BeanFactory.getBean("cronsSetDao"));
	private DataParse dataParse = (DataParse) BeanFactory.getBean("dataParse");
	

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

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write('\r');
      out.write('\n');

	int timestamp=(Integer)request.getAttribute("timestamp");
	Connection connection = (Connection)request.getAttribute("connection");
	Map<String,String> settings=ForumInit.settings;
	int maxbdays=Integer.valueOf(settings.get("maxbdays"));
	if(maxbdays>0){
		Cache.updateCache("index");
	}
	int bdaystatus=Integer.valueOf(settings.get("bdaystatus"));
	if(bdaystatus>0){
		MessageResources mr = Common.getMessageResources(request);
		Locale locale = Common.getUserLocale(request);
		String boardurl = (String)session.getAttribute("boardurl");
		String timeoffset = settings.get("timeoffset");
		String today = Common.gmdate("MM-dd",timestamp,timeoffset);
		List<Map<String,String>> members = cronsDao.executeQuery(connection,"SELECT uid, username, email, bday FROM "+tablepre+"members WHERE RIGHT(bday, 5)='"+today+"' ORDER BY bday");
		if(members!=null&&members.size()>0){
			String bbname=settings.get("bbname");
			Map<String,String> mails=dataParse.characterParse(settings.get("mail"), false);
			Mail mail=new Mail(mails);
			for(Map<String,String> member:members){
				String countent =mr.getMessage(locale,"birthday_message",bbname,boardurl);
				mail.sendMessage(mails.get("from"),member.get("username")+" <"+member.get("email")+">",mr.getMessage(locale,"birthday_subject"),countent,null);
			}
		}
	}

	RequestDispatcher dispatcher = request.getRequestDispatcher("/include/crons/setNextrun.jsp");
	try {
		dispatcher.include(request, response);
	} catch (Exception e) {
		e.printStackTrace();
	} 
	Map<String,String> crons = (Map<String,String>)request.getAttribute("crons");
	if("0".equals(crons.get("available"))){
		cronsDao.execute(connection,"UPDATE "+tablepre+"crons SET available='0' WHERE cronid="+crons.get("cronid"));
	}else{
		cronsDao.execute(connection,"UPDATE "+tablepre+"crons SET lastrun='"+timestamp+"',nextrun='"+crons.get("nextrun")+"' WHERE cronid="+crons.get("cronid"));
	}

      out.write('\r');
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
