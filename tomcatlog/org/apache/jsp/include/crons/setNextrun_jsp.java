package org.apache.jsp.include.crons;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.*;
import cn.jsprun.utils.Common;
import cn.jsprun.utils.ForumInit;

public final class setNextrun_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");

	Map<String,String> crons = (Map<String,String>)request.getAttribute("crons");
	String minute = crons.get("minute"); 
	if(minute.equals("")){
		crons.put("available","0");
		return ;
	}
	short hour = Short.parseShort(crons.get("hour"));
	short day = Short.parseShort(crons.get("day"));
	byte weekDay = Byte.parseByte(crons.get("weekday"));
	Calendar calendar = Common.getCalendar(ForumInit.settings.get("timeoffset"));
	calendar.set(Calendar.SECOND, 0);
	Date date = calendar.getTime();
	
	String[] minuteArray = minute.split("\t");
	int minuteLengh = minuteArray.length;
	int[] minuteIntArray = new int[minuteLengh];
	for(int i = 0;i<minuteLengh;i++){
		minuteIntArray[i] = Integer.parseInt(minuteArray[i]);
	}
	Arrays.sort(minuteIntArray);
	int nowMinute = calendar.get(Calendar.MINUTE);
	int minMinute = 0;
	int maxMinute = 0;
	int nextRunM = 0;
	if(minuteLengh>0){
		minMinute=minuteIntArray[0];
		maxMinute=minuteIntArray[minuteLengh-1];
	}
	if(nowMinute>=maxMinute){
		nextRunM = minMinute;
		if(hour==-1){
			calendar.add(Calendar.HOUR_OF_DAY, 1);
		}
	}else{
		for(int tempMinute : minuteIntArray){
			if(tempMinute>nowMinute){
				nextRunM = tempMinute;
				break;
			}
		}
	}
	calendar.set(Calendar.MINUTE, nextRunM);
	
	
	if(hour>-1){
		calendar.set(Calendar.HOUR_OF_DAY, hour);
		
		if(!calendar.getTime().after(date)&&weekDay == -1&&day == -1){
			calendar.add(Calendar.DAY_OF_YEAR, 1);
		}
	}
	
	
	if (weekDay > -1) {
		calendar.set(Calendar.DAY_OF_WEEK, weekDay+1);
		
		if(!calendar.getTime().after(date)){
			calendar.add(Calendar.WEEK_OF_MONTH, 1);
		}
	} else {
		if (day > -1) {
			calendar.set(Calendar.DAY_OF_MONTH, day);
			
			if(!calendar.getTime().after(date)){
				calendar.add(Calendar.MONTH, 1);
			}
		}
	}
	
	crons.put("nextrun",(int)(calendar.getTimeInMillis()/1000)+"");

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
