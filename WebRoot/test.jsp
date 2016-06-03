<%@ page import="java.util.Enumeration" %>
<%--<%@ page import="java.util.Enumeration" %><%--%>
<%--HttpSession httpSession = request.getSession();--%>
<%--out.println("Application /test1 no data!");--%>
<%--out.println("<br/>");--%>
<%--out.println("Application /test1 no data!"+httpSession.getId());--%>
<%--out.println("<br/>");--%>
<%--out.println(" - "+httpSession.getAttribute("jsprun_sid"));--%>
<%--out.println("<br/>");--%>
<%--out.println(" - "+httpSession.getAttribute("jsprun_uid"));--%>

<%--out.print("abc - "+application.getContext("user").getAttribute("userName"));--%>
<%--out.print("abc - "+application.getContext("user").getAttribute("password"));--%>

<%--/**  12345*/--%>
<%--Enumeration<String> names = session.getAttributeNames();--%>
<%--while (names.hasMoreElements()) {--%>
<%--String sname = names.nextElement();--%>
<%--String value = session.getAttribute(sname).toString();--%>
<%--System.out.println(sname + " = " + value + "<br>");--%>
<%--System.out.println(sname + " = " + value);--%>
<%--}--%>
<%--/**  12345*/--%>
<%--%>--%>
<%@page language="java" pageEncoding="GBK" %>
<%
    try {
//以下内容用于测试同一tomcat下不同项目之间共享session
        HttpSession session1 = request.getSession();
        ServletContext Context = session1.getServletContext();
        // 这里面传递的是 Project_A 的虚拟路径
        ServletContext Context1 = Context.getContext("/csmis");
        System.out.println(Context1);
        HttpSession session2 = (HttpSession) Context1.getAttribute("session");
        System.out.println("base传过来的user为:" + session2.getAttribute("name"));
    } catch (Exception ex) {
        ex.printStackTrace();
    }

%>