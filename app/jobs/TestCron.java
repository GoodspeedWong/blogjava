package jobs;

import play.Logger;
import play.jobs.Job;
import play.jobs.On;

@On("03 48 15 * * ?")
public class TestCron extends Job {

	@Override
	public void doJob() throws Exception {
		// TODO Auto-generated method stub
		Logger.info("start to execute the crontab *********");
	}
	
}
