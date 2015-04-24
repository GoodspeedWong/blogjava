package jobs;

import models.TCfgUser;
import play.Logger;
import play.jobs.Job;
import play.jobs.OnApplicationStart;

@OnApplicationStart
public class Bootstrap extends Job {
	@Override
	public void doJob() throws Exception {
		Logger.info("start to bootstrap...");
		// TODO Auto-generated method stub
		TCfgUser user = TCfgUser.find("name=?", "admin").first();
		if(user==null){
			Logger.info("cannot found the admin user, the admin user will be created.");
			user = new TCfgUser();
			user.name="admin";
			user.description="Admin";
			user.password="Passw0rd";
			user.save();
		} else {
			Logger.info("found the admin user, the userid is "+user.id);
		}
		Logger.info("end to bootstrap...");
	}
}
