package org.apache.jsp.include.crons;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.*;
import cn.jsprun.utils.BeanFactory;
import cn.jsprun.utils.Mail;
import cn.jsprun.utils.DataParse;
import cn.jsprun.utils.ForumInit;
import java.text.SimpleDateFormat;
import cn.jsprun.utils.Common;
import cn.jsprun.dao.CronsDao;
import java.sql.Connection;
import org.apache.struts.util.MessageResources;
import java.util.Locale;

public final class notify_005fdaily_jsp extends org.apache.jasper.runtime.HttpJspBase
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
	String timeoffset = (String)settings.get("timeoffset");
	SimpleDateFormat dateFormat = Common.getSimpleDateFormat("yyyy-MM-dd : HH:mm",timeoffset);
	String bbname =settings.get("bbname");
	String boardurl = (String)session.getAttribute("boardurl");
	List<Map<String, String>> subscriptions = cronsDao.executeQuery(connection,"SELECT t.tid, t.subject, t.author, t.lastpost, t.lastposter, t.views, t.replies, m.username, m.email FROM "+ tablepre+ "subscriptions s, "+ tablepre+ "members m, "+ tablepre+ "threads t WHERE s.lastpost>s.lastnotify AND m.uid=s.uid AND t.tid=s.tid");
	if (subscriptions != null && subscriptions.size() > 0) {
		MessageResources mr = Common.getMessageResources(request);
		Locale locale = Common.getUserLocale(request);
		Map<String,String> mails=dataParse.characterParse(settings.get("mail"), false);
		Mail mail=new Mail(mails);
		for(Map<String, String> subscription:subscriptions){
			String context = mr.getMessage(locale,"email_notify_message",new String[]{bbname,boardurl,subscription.get("tid"),subscription.get("subject"),subscription.get("author"),subscription.get("views"),subscription.get("replies"),subscription.get("lastposter"),Common.gmdate(dateFormat,Integer.parseInt(subscription.get("lastpost")))});
			mail.sendMessage(mails.get("from"),subscription.get("username")+" <"+subscription.get("email")+">",mr.getMessage(locale,"email_notify_subject",subscription.get("subject")),context,null);
		}
	}
	cronsDao.execute(connection,"UPDATE "+tablepre+"subscriptions SET lastnotify='"+timestamp+"' WHERE lastpost>lastnotify");
			
	
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

      out.write("\r\n");
      out.write("\r\n");
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
