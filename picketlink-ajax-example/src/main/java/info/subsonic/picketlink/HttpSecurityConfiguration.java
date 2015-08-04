package info.subsonic.picketlink;

import org.picketlink.config.SecurityConfigurationBuilder;
import org.picketlink.event.SecurityConfigurationEvent;

import javax.enterprise.event.Observes;

/**
 * <p>
 * A simple CDI observer for the
 * {@link org.picketlink.event.SecurityConfigurationEvent}.
 * </p>
 *
 * <p>
 * The event is fired during application startup and allows you to provide any
 * configuration to PicketLink before it is initialized.
 * </p>
 *
 * <p>
 * All the configuration related with Http Security is provided from this bean.
 * </p>
 *
 * @author HOSHI Seigo
 */
public class HttpSecurityConfiguration {

	/**
	 * Configures Http Security.
	 * 
	 * @param event the SecurityConfigurationEvent.
	 */
	public void onInit(@Observes SecurityConfigurationEvent event) {
		SecurityConfigurationBuilder builder = event.getBuilder();

		builder.http()
			.forPath("/protected/*")
				.authenticateWith()
					.scheme(FormWithAjaxAuthenticationScheme.class);
	}

}
