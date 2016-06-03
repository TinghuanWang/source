package org.apache.jsp.include.crons;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.*;
import cn.jsprun.utils.BeanFactory;
import cn.jsprun.dao.OtherSetDao;
import cn.jsprun.domain.Magics;
import cn.jsprun.dao.CronsDao;
import java.sql.Connection;
import cn.jsprun.utils.Common;
import cn.jsprun.utils.ForumInit;

public final class magics_005fdaily_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {


	private String tablepre = "jrun_"; 
	private CronsDao cronsDao = ((CronsDao)BeanFactory.getBean("cronsSetDao"));
	private OtherSetDao osDao = (OtherSetDao) BeanFactory.getBean("otherSetDao");
	

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
      out.write('\r');
      out.write('\n');

	int timestamp=(Integer)request.getAttribute("timestamp");
	Connection connection = (Connection)request.getAttribute("connection");
	List<Magics> magicOperationList = new ArrayList<Magics>();
	List<Magics> magicsList = osDao.getAvailableMagics();
	if(magicsList!=null){
		for(int i = 0;i<magicsList.size();i++){
			Magics magics = magicsList.get(i);
			if(magics!=null&&magics.getSupplytype()!=0&&magics.getSupplynum()!=0&&magics.getNum()==0){
				magicOperationList.add(magics);
			}
		}
	}
	Calendar calendar = Common.getCalendar(ForumInit.settings.get("timeoffset"));
	Integer dayOfMonth = calendar.get(Calendar.DAY_OF_MONTH);
	Integer dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
	for(int i = 0;i<magicOperationList.size();i++){
		Magics magics = magicOperationList.get(i);
		boolean autosupply = false;
		if(magics.getSupplytype() == 1) {
				autosupply = true;
		} else if(magics.getSupplytype() == 2 && dayOfWeek==1){
				autosupply = true;
		} else if(magics.getSupplytype() == 3 && dayOfMonth==1){
				autosupply = true;
		}
		if(!autosupply) {
			magics.setNum(magics.getNum()+magics.getSupplynum());
		}
	}
	osDao.updateMagics(magicOperationList);

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
