package controllers;

import models.TCfgUser;

public class Security extends Secure.Security {

	 static boolean authentify(String username, String password) {
         return TCfgUser.connect(username, password)!=null;
     }
	 
	 static void onAuthenticated() {
		 Admin.index();
     }
	 
	 static void onDisconnected() {
		 Application.index();
     }
}
