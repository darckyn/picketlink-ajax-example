package info.subsonic.picketlink;

import java.util.ResourceBundle;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIViewRoot;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import org.picketlink.Identity;
import org.picketlink.Identity.AuthenticationResult;

/**
 * This class is a LoginView.
 *
 * @author HOSHI Seigo
 */
@Named
@RequestScoped
public class LoginView {

	/**
	 * The Identity.
	 */
	@Inject
	private Identity identity;

	/**
	 * Processes login.
	 * 
	 * @return the outcome.
	 */
	public String login() {

		if (identity.isLoggedIn()) {
			return "/protected/home?faces-redirect=true";
		}

		AuthenticationResult result = identity.login();

		if (AuthenticationResult.FAILED.equals(result)) {
			FacesContext facesContext = FacesContext.getCurrentInstance();
			UIViewRoot uiViewRoot = facesContext.getViewRoot();
			ResourceBundle resourceBundle = ResourceBundle.getBundle(
					"resources.message", uiViewRoot.getLocale());
			String loginFailed = resourceBundle.getString("login.failed");
			facesContext.addMessage(null, new FacesMessage(loginFailed));
			return "";
		}

		return "/protected/home?faces-redirect=true";
	}

}
