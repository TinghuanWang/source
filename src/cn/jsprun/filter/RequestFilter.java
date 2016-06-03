package cn.jsprun.filter;

import cn.jsprun.domain.Members;
import cn.jsprun.service.MemberService;
import cn.jsprun.utils.Common;
import cn.jsprun.utils.Md5Token;

import javax.servlet.*;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.net.URLDecoder;
import java.util.Enumeration;

/**
 * Created by wth on 2016/1/18.
 */
public class RequestFilter implements Filter {
    private static String csmisSessionId;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;
        try {

            /**获取csmis系统session Context缓存记录**/
            HttpSession session = req.getSession();

            Cookie[] cookies = req.getCookies();
            String userName = "";
            if (cookies != null) {
                for (int i = 0; i < cookies.length; i++) {
                    if (cookies[i].getName().equals("userName")) {
                        userName = URLDecoder.decode(cookies[i].getValue());
                    }
                }

            }
            System.out.println("===================================" + userName);
            /**如果获得csmis session*/
            String action = req.getParameter("action") == null ? "" : req.getParameter("action");
            if (!action.equals("logout") && !action.equals("login")) {
                /**csmis系统没有，则取本系统的*/
                userName = userName == "" ? req.getParameter("username") : userName;
                /**如果用户名密码不为空*/
                if (userName != "") {
                    Members member = null;
                    MemberService memberService = new MemberService();
                    member = memberService.findByName(userName.toString());
                    if (null != member) {
                        session.setAttribute("styleid", member.getStyleid().toString());
                        session.setAttribute("formhash", Common.getRandStr(8, false));
                        session.setAttribute("dateformat", "yyyy-MM-dd");
                        session.setAttribute("jsprun_userss", userName);
                        session.setAttribute("jsprun_uid", member.getUid());
                        session.setAttribute("jsprun_groupid", member.getGroupid());
                        /**jsprun_sid 保证唯一*/
                        String jsprunId = session.getAttribute("jsprun_sid") == null ? member.getUid().toString() : session.getAttribute("jsprun_sid").toString();
                        session.setAttribute("jsprun_sid", jsprunId);
                        session.setAttribute("jsprun_adminid", member.getAdminid());
                        session.setAttribute("timeformat", "HH:mm");
                        String loginauth = req.getParameter("loginauth");
                        Md5Token md5 = Md5Token.getInstance();
                        String passWord = member.getPassword();
                        passWord = passWord != null ? md5.getLongToken(md5.getLongToken(passWord) + (member != null ? member.getSalt() : "")) : "";
                        session.setAttribute("jsprun_pw", passWord);
                        session.setAttribute("user", member);
                        req.setAttribute("sessionexists", false);
                    }
                }
            } else if (action.equals("logout")) {
                session.removeAttribute("jsprun_sid");
                session.setAttribute("jsprun_uid", 0);
                session.setAttribute("jsprun_userss", "");
                session.setAttribute("jsprun_pw", "");
                session.removeAttribute("user");
                session.setAttribute("jsprun_groupid", (short) 7);
                session.setAttribute("jsprun_adminid", (byte) 0);
                request.setAttribute("refresh", "true");
            }
            /**  输入bbs session信息*/
            Enumeration<String> names = session.getAttributeNames();
            System.out.println("------------bbs filter{start}");
            while (names.hasMoreElements()) {
                String sname = names.nextElement();
                String value = session.getAttribute(sname).toString();
                System.out.println(sname + " = " + value + "<br>");
                System.out.println(sname + " = " + value);
            }
            System.out.println("------------bbs filter{end}");

        } catch (Exception x) {
            x.printStackTrace();
        }
        chain.doFilter(req, resp);
    }

    @Override
    public void destroy() {

    }
}
