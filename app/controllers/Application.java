package controllers;

import play.*;
import play.db.jpa.JPA;
import play.jobs.Job;
import play.mvc.*;

import java.util.*;

import jobs.TestCron;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

import models.TCfgBlog;
import models.TCfgUser;

public class Application extends Controller {

    public static void index() {
    	List<TCfgBlog> blogs = TCfgBlog.find("order by update_at desc").fetch();
    	List<TCfgBlog> topBlogs = TCfgBlog.find("top=?",true).fetch();
    	
    	render(blogs, topBlogs);
    }
    
    public static void showBlog(Long id){
    	TCfgBlog blog = TCfgBlog.findById(id);
    	render("Application/blog.html",blog);
    }

    public static void indexJson(){
    	List<TCfgBlog> blogs = TCfgBlog.findAll();
    	
    }
    
    public static void test(){
    	Job testCron = new TestCron();
    	testCron.now();
    	
    	Application.index();
    }
}