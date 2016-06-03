package cn.jsprun.filter;

import cn.jsprun.domain.Members;
import cn.jsprun.service.MemberService;
import cn.jsprun.utils.Common;
import cn.jsprun.utils.Md5Token;

import javax.servlet.ServletContext;
import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
import java.util.Enumeration;

/**
 * Created by 123456 on 2016/1/27.
 */
public class BbscsmisLisenner implements HttpSessionListener, ServletRequestListener {
    private static HttpServletRequest request;

    @Override
    public void sessionCreated(HttpSessionEvent httpSessionEvent) {
//        HttpSession session = httpSessionEvent.getSession();
//        System.out.println("------------------------------------------------");
        //try {
//            /**获取csmis系统session Context缓存记录**/
//            /**获取csmis系统Session*/
//            ServletContext Context = session.getServletContext();
//            ServletContext Context1 = Context.getContext("/csmis");
//            HttpSession session2 = (HttpSession) Context1.getAttribute("csmis");
//            /**如果获得csmis session*/
//            String action = request.getParameter("action") == null ? "" : request.getParameter("action");
//
//            if (!action.equals("logout") || !action.equals("login")) {
//                int count = 0;
//                try {
//                    session2.getAttribute("userName");
//                } catch (Exception ee) {
//                    count = 1;
//                }
//                /**csmis系统session没有invalidate掉，执行以下代码**/
//                if (session2 != null && count == 0) {
//                    String userName = session2.getAttribute("userName") == null ? "" : session2.getAttribute("userName").toString();
//                    String passWord = session2.getAttribute("passWord") == null ? "" : session2.getAttribute("passWord").toString();
//
//                    /**csmis系统没有，则取本系统的*/
//                    userName = userName == "" ? request.getParameter("username") : userName;
//                    passWord = passWord == "" ? request.getParameter("password") : passWord;
//                    /**如果用户名密码不为空*/
//                    if (passWord != "" && userName != "") {
//                        System.out.println("Copy csmis session======================================");
//                        Members member = null;
//                        MemberService memberService = new MemberService();
//                        member = memberService.findByName(userName.toString());
//                        if (null != member) {
//                            session.setAttribute("styleid", member.getStyleid().toString());
//                            session.setAttribute("formhash", Common.getRandStr(8, false));
//                            session.setAttribute("dateformat", "yyyy-MM-dd");
//                            session.setAttribute("jsprun_userss", session2.getAttribute("userName").toString());
//                            session.setAttribute("jsprun_uid", member.getUid());
//                            session.setAttribute("jsprun_groupid", member.getGroupid());
//                            /**jsprun_sid 保证唯一*/
//                            String jsprunId = session.getAttribute("jsprun_sid") == null ? member.getUid().toString() : session.getAttribute("jsprun_sid").toString();
//                            session.setAttribute("jsprun_sid", jsprunId);
//                            session.setAttribute("jsprun_adminid", member.getAdminid());
//                            session.setAttribute("timeformat", "HH:mm");
//                            String loginauth = request.getParameter("loginauth");
//                            Md5Token md5 = Md5Token.getInstance();
//                            passWord = passWord != null ? md5.getLongToken(md5.getLongToken(passWord) + (member != null ? member.getSalt() : "")) : "";
//                            session.setAttribute("jsprun_pw", passWord);
//                            session.setAttribute("user", member);
//                            request.setAttribute("sessionexists", false);
//
//                            ServletContext ContextA = session.getServletContext();
//                            ContextA.setAttribute("bbs", session);
//                        }
//                    }
//                }
//            }
//            /**  输入bbs session信息*/
//            Enumeration<String> names = session.getAttributeNames();
//            System.out.println("------------bbs filter{start}");
//            while (names.hasMoreElements()) {
//                String sname = names.nextElement();
//                String value = session.getAttribute(sname).toString();
//                System.out.println(sname + " = " + value + "<br>");
//                System.out.println(sname + " = " + value);
//            }
//            System.out.println("------------bbs filter{end}");
//
//        } catch (Exception x) {
//            x.printStackTrace();
//        }
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent httpSessionEvent) {

        System.out.println("[======destroyed========================]");
    }

    @Override
    public void requestDestroyed(ServletRequestEvent servletRequestEvent) {

    }

    @Override
    public void requestInitialized(ServletRequestEvent servletRequestEvent) {
        request = (HttpServletRequest) servletRequestEvent.getServletRequest();
    }
}
