package controllers;

import java.util.List;

import models.TCfgUser;
import play.mvc.Controller;

public class RestUser extends Controller{

	public static void index(){
		List<TCfgUser> users = TCfgUser.findAll();
		renderJSON(users);
	}
	
	public static void show(Long id){
		TCfgUser user = TCfgUser.findById(id);
		renderJSON(user);
	}
	
}
