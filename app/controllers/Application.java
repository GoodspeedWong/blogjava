package controllers;

import play.*;
import play.mvc.*;

import java.util.*;

import models.TCfgBlog;

public class Application extends Controller {

    public static void index() {
    	List<TCfgBlog> blogs = TCfgBlog.findAll();
        render(blogs);
    }

    public static void indexJson(){
    	List<TCfgBlog> blogs = TCfgBlog.findAll();
    	
    }
}