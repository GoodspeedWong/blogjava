package controllers;

import java.lang.reflect.Constructor;
import java.util.List;

import play.data.binding.Binder;
import play.data.validation.Error;
import play.db.Model;
import play.exceptions.TemplateNotFoundException;
import controllers.CRUD.ObjectType;
import models.TCfgUser;

@CRUD.For(TCfgUser.class)
public class Users extends Admin {

	public static void create() throws Exception {
        ObjectType type = ObjectType.get(getControllerClass());
        notFoundIfNull(type);
        Constructor<?> constructor = type.entityClass.getDeclaredConstructor();
        constructor.setAccessible(true);
        TCfgUser object = (TCfgUser) constructor.newInstance();
        Binder.bindBean(params.getRootParamNode(), "object", object);
        validation.valid(object);
        if (validation.hasErrors()) {
        	List<play.data.validation.Error> errors = validation.errors();
        	for(Error e: errors){
        		System.out.println(e.getKey()+"-"+e.message());
        	}
            renderArgs.put("error", play.i18n.Messages.get("crud.hasErrors"));
            try {
                render(request.controller.replace(".", "/") + "/blank.html", type, object);
            } catch (TemplateNotFoundException e) {
                render("CRUD/blank.html", type, object);
            }
        }
        object._save();
        Mail.welcome(object);
        flash.success(play.i18n.Messages.get("crud.created", type.modelName));
        if (params.get("_save") != null) {
            redirect(request.controller + ".list");
        }
        if (params.get("_saveAndAddAnother") != null) {
            redirect(request.controller + ".blank");
        }
        redirect(request.controller + ".show", object._key());
    }
	
}
