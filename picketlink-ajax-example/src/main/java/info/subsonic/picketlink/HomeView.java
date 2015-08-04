package info.subsonic.picketlink;

import java.util.Date;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.picketlink.Identity;

/**
 * This class is a HomeView.
 *
 * @author HOSHI Seigo
 */
@Named
@RequestScoped
public class HomeView {

	/**
	 * The Identity.
	 */
	@Inject
	private Identity identity;

	/**
	 * The current Date and time.
	 */
	private Date currentDateTime = new Date();

	/**
	 * Updates date and time.
	 */
	public void updateDateTime() {
		currentDateTime = new Date();
	}

	/**
	 * Processes logout.
	 * 
	 * @return the outcome.
	 */
	public String logout() {
		identity.logout();
		return "/loggedOut?faces-redirect=true";
	}

	/**
	 * Gets current date and time.
	 *
	 * @return the current date and time.
	 */
	public Date getCurrentDateTime() {
		return currentDateTime;
	}

	/**
	 * Sets current date and time.
	 *
	 * @param currentDateTime the current date and time.
	 */
	public void setCurrentDateTime(Date currentDateTime) {
		this.currentDateTime = currentDateTime;
	}

}
