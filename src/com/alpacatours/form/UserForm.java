package com.alpacatours.form;

import javax.servlet.http.HttpServletRequest;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.validator.ValidatorForm;

public class UserForm extends ValidatorForm {
    private String username;
    private String password;

    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    @Override
    public ActionErrors validate(ActionMapping mapping, HttpServletRequest request) {
        ActionErrors errors = new ActionErrors();
        if (username == null || username.isEmpty()) {
            errors.add("username", new ActionMessage("error.username.required"));
        }
        if (password == null || password.isEmpty()) {
            errors.add("password", new ActionMessage("error.password.required"));
        }
        return errors;
    }
}
