package com.easylearnjava.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.easylearnjava.form.LoginForm;

/**
 * 
 * @author rnr
 *
 */
public class LogoutAction  extends Action{
	
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		LoginForm loginForm = (LoginForm) form;
		loginForm.setPassword("");
		loginForm.setUsername("");
		return mapping.findForward("success");
		
		
	}
	
}
