package com.alpacatours.action;

import com.alpacatours.dao.UserDAO;
import com.alpacatours.model.User;
import com.alpacatours.form.UserForm;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

public class UserAction extends Action {
    private final UserDAO userDAO = new UserDAO();

    @Override
    public ActionForward execute(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response) throws Exception {
        UserForm userForm = (UserForm) form;
        String action = mapping.getPath();
        if ("/login".equals(action)) {
            System.out.println("User-Login-Action");
            User user = userDAO.findByUsername(userForm.getUsername());
            if (user != null && user.getPassword().equals(userForm.getPassword())) {
                request.getSession().setAttribute("user", user);
                return mapping.findForward("success");
            }
            return mapping.findForward("failure");
        } else if ("/register".equals(action)) {
            User user = new User();
            user.setUsername(userForm.getUsername());
            user.setPassword(userForm.getPassword());
            user.setRole("USER");
            System.out.println("User-Register-Action");
            String role = userForm.getRole();
            if (role == null || role.isEmpty()) {
                role = "CUST";
            }
            user.setRole(role);
            userDAO.save(user);
            return mapping.findForward("success");
        } else if ("/users".equals(action)) {
            java.util.List<User> list = userDAO.findAll();
            request.setAttribute("users", list);
            return mapping.findForward("success");
        }
        return mapping.getInputForward();
    }
}
