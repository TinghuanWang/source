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
//�����������ڲ���ͬһtomcat�²�ͬ��Ŀ֮�乲��session
        HttpSession session1 = request.getSession();
        ServletContext Context = session1.getServletContext();
        // �����洫�ݵ��� Project_A ������·��
        ServletContext Context1 = Context.getContext("/csmis");
        System.out.println(Context1);
        HttpSession session2 = (HttpSession) Context1.getAttribute("session");
        System.out.println("base��������userΪ:" + session2.getAttribute("name"));
    } catch (Exception ex) {
        ex.printStackTrace();
    }

%>