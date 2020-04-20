package controller.filters;

import model.entity.User;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class ServletSecurityFilter implements Filter {
    private static final org.apache.logging.log4j.Logger log
            = org.apache.logging.log4j.LogManager.getLogger(ServletSecurityFilter.class);

    public void destroy() {
    }

    public void doFilter(ServletRequest request, ServletResponse response,
                         FilterChain chain) throws IOException, ServletException {
        System.out.println("auth filter");
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;
        HttpSession session = req.getSession();
        System.out.println(session.getAttribute("role"));
        log.info(session.getAttribute("role"));
        if (session.getAttribute("role") == null) {
            setGuestRole(session);
        }
        if (checkForDeniedAccess(req, User.ROLE.valueOf((String) session.getAttribute("role")))) {
            request.getRequestDispatcher("/WEB-INF/error.jsp").forward(req, resp);
        }
        chain.doFilter(request, response);
    }

    private boolean checkForDeniedAccess(HttpServletRequest req, User.ROLE role) {
        return (containsRole(req, "user") &&
                !role.equals(User.ROLE.USER)) ||
                (containsRole(req, "admin") &&
                        !role.equals(User.ROLE.ADMIN)) ||
                ((!(containsRole(req, "admin") && !(containsRole(req, "user"))) &&
                        !role.equals(User.ROLE.UNKNOWN)));
    }

    private boolean containsRole(HttpServletRequest req, String role) {
        return req.getRequestURI().contains(role);
    }

    private void setGuestRole(HttpSession session) {
        session.setAttribute("role", User.ROLE.UNKNOWN.toString());
    }

    public void init(FilterConfig fConfig) throws ServletException {
    }

}
