package models;

import java.util.Calendar;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Table;

import controllers.CRUD.Hidden;
import play.data.validation.MaxSize;
import play.data.validation.Required;
import play.db.jpa.Model;

@Entity
@Table(name="t_cfg_blog")
public class TCfgBlog extends Model {

	@Required
	@MaxSize(64)
	public String title;
	
	@Required
	@MaxSize(5000)
	public String content;
	
	@Hidden
	public Long create_at = Calendar.getInstance().getTimeInMillis();
	
	@Hidden
	public Long update_at = Calendar.getInstance().getTimeInMillis();
	
}
