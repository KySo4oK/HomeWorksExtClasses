package controller.command;

import model.entity.User;
import model.service.UserService;

import javax.servlet.http.HttpServletRequest;

public class LoginCommand implements Command {
    private UserService userService = new UserService();
    private static final org.apache.logging.log4j.Logger log
            = org.apache.logging.log4j.LogManager.getLogger(LoginCommand.class);

    @Override
    public String execute(HttpServletRequest request) {
        String name = request.getParameter("name");
        String pass = request.getParameter("password");
        log.info(name + pass);

        if (name == null || name.equals("") || pass == null || pass.equals("")) {
            //System.out.println("Not");
            return "/login.jsp";
        }
        System.out.println(name + " " + pass);
        //System.out.println("Yes!");

        User.ROLE role = (userService.getRoleByUser(request.getParameter("username"),
                request.getParameter("password")));

        if (role == null) {
            return "/login.jsp";
        }

        if (CommandUtility.checkUserIsLogged(request, name)) {
            return "/WEB-INF/error.jsp";
        }

        if (role.equals(User.ROLE.ADMIN)) {
            CommandUtility.setUserRole(request, User.ROLE.ADMIN, name);
            return "/WEB-INF/admin/admin.jsp";
        } else if (role.equals(User.ROLE.USER)) {
            CommandUtility.setUserRole(request, User.ROLE.USER, name);
            return "/WEB-INF/user/admin.jsp";
        } else {
            CommandUtility.setUserRole(request, User.ROLE.UNKNOWN, name);
            return "/login.jsp";
        }
    }
}
