package jobs;

import play.Logger;
import play.jobs.Every;
import play.jobs.Job;

@Every("1mn")
public class TestSchedule extends Job {
	
	@Override
	public void doJob() throws Exception {
		// TODO Auto-generated method stub
		Logger.info("start to execute the test schedule...");
	}
}
