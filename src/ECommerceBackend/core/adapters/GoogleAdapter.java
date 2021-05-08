package ECommerceBackend.core.adapters;

import ECommerceBackend.business.concretes.GoogleManager;

public class GoogleAdapter implements Google{
	GoogleManager googleManager = new GoogleManager();
	public void login() {
		googleManager.loginViaGoogle();
	}

}
