package com.easylearnjava.form;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

/**
 * 
 * @author rnr
 * 
 *         LoginForm extends ActionForm class and acts as a form Bean. Helps in
 *         data transfer from the UI screen to the Action class and from Action
 *         Class to UI. Validate method is used to perform data validations.
 *         Reset method is used to reset form data.
 */
public class LoginForm extends ActionForm {

	/**
	 * This is auto generated
	 */
	private static final long serialVersionUID = -324153790324983534L;

	private String username;
	private String password;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	// Basic data validations.
	@Override
	public ActionErrors validate(ActionMapping mapping,
			HttpServletRequest request) {

		ActionErrors errors_msg = new ActionErrors();

		if (getUsername() == null || ("".equals(getUsername()))) {
			errors_msg.add("common.name.err", new ActionMessage(
					"error.name.required"));
		}

		if (getPassword() == null || ("".equals(getPassword()))) {
			errors_msg.add("common.password.err", new ActionMessage(
					"error.password.required"));
		}

		return errors_msg;
	}

	// Used to reset the bean properties
	// Called before the properties are re-populated by the controller
	@Override
	public void reset(ActionMapping mapping, HttpServletRequest request) {
		super.reset(mapping, request);
	}

}
