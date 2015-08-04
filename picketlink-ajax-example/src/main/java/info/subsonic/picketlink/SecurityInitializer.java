package info.subsonic.picketlink;

import org.picketlink.idm.IdentityManager;
import org.picketlink.idm.PartitionManager;
import org.picketlink.idm.credential.Password;
import org.picketlink.idm.model.basic.User;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.inject.Inject;

/**
 * This startup bean creates a default user account when the application is
 * started. Since I am not providing an IDM configuration in this example,
 * PicketLink will default to using a file-based identity store to persist user
 * and other identity state.
 *
 * @author HOSHI Seigo
 */
@Singleton
@Startup
public class SecurityInitializer {

	/**
	 * The PartitionManager.
	 */
	@Inject
	private PartitionManager partitionManager;

	/**
	 * Creates User.
	 */
	@PostConstruct
	public void create() {
		IdentityManager identityManager = this.partitionManager
				.createIdentityManager();

		User user = new User("jane");

		user.setEmail("jane@doe.com");
		user.setFirstName("Jane");
		user.setLastName("Doe");

		identityManager.add(user);
		identityManager.updateCredential(user, new Password("abcd1234"));
	}
	
}
