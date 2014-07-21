package com.easylearnjava.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;

import com.easylearnjava.exception.ServiceException;
import com.easylearnjava.form.LoginForm;
import com.easylearnjava.service.LoginService;

/**
 * 
 * @author rnr
 *
 *LoginAction extends Action class and gets all the featuers of an Acction class.
 *When the request comes to LoginAction class, execute method is called by default
 *If valid credentials are given the user is redirected to success page.
 *If invalid credentials are entered then the login page is displayed back to the user.
 *Even if an exception occurs at application level the user is redirected back to login page.
 */
public class LoginAction  extends Action{
	
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		ActionMessages appErrors = new ActionMessages();
		LoginForm loginForm = (LoginForm) form;
		
		try {
			String userNameStr = loginForm.getUsername();
			String passwordStr = loginForm.getPassword();

			LoginService ls = new LoginService();
			boolean isValid = ls.isValidPassword(userNameStr, passwordStr);

			if (isValid) {
				request.setAttribute("reqName", userNameStr);
				return mapping.findForward("success");
			} else {
				appErrors.add("username",new ActionMessage("login.failed"));
				saveErrors(request, appErrors);
				loginForm.setPassword("");
				loginForm.setUsername("");
				return mapping.findForward("failure");
			}
		} catch (Exception ex) {
			if(!(ex instanceof ServiceException)){
				ex.printStackTrace();
			}
			appErrors.add("username",new ActionMessage("global.exception.message"));
			saveErrors(request, appErrors);
			loginForm.setPassword("");
			loginForm.setUsername("");
			return mapping.findForward("failure");
		}
	}
	
}
