package org.apache.jsp.include.crons;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.*;
import cn.jsprun.utils.BeanFactory;
import cn.jsprun.dao.CronsDao;
import java.sql.Connection;
import java.sql.SQLException;
import cn.jsprun.utils.ForumInit;

public final class todayposts_005fdaily_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

 
	private final String tablepre = "jrun_";
	private CronsDao cronsDao = ((CronsDao)BeanFactory.getBean("cronsSetDao"));
	
	private String getValue(String sql,String field,Connection connection) throws SQLException{
		List<Map<String,String>> tempList = cronsDao.executeQuery(connection,sql);
		if(tempList!=null&&tempList.size()>0){
			return tempList.get(0).get(field);
		}
		return null;
	}

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
      out.write('\r');
      out.write('\n');
	
	int timestamp=(Integer)request.getAttribute("timestamp");
	Connection connection = (Connection)request.getAttribute("connection");
	
	String yesterdayposts =getValue("SELECT sum(todayposts) yesterdayposts FROM "+tablepre+"forums","yesterdayposts",connection);
	if(yesterdayposts == null){
		yesterdayposts = "0";
	}
	
	String historyposts = getValue("SELECT value FROM "+tablepre+"settings WHERE variable='historyposts'","value",connection);
	String[] hpostarray = null;
	if(historyposts==null){
		hpostarray=new String[]{"0","0"};
	}else{
		hpostarray = historyposts.split("\t");
		if(hpostarray==null||hpostarray.length<2){
			hpostarray=new String[]{"0","0"};
		}
	}
	historyposts = Integer.valueOf(hpostarray[1])<Integer.valueOf(yesterdayposts)?yesterdayposts+"\t"+yesterdayposts:yesterdayposts+"\t"+hpostarray[1];
	cronsDao.execute(connection,"UPDATE "+tablepre+"settings SET value='"+historyposts+"' WHERE variable ='historyposts'");
	cronsDao.execute(connection,"UPDATE "+tablepre+"forums SET todayposts='0'");
	ForumInit.settings.put("historyposts",historyposts);
	
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
