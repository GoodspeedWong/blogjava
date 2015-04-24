package models;

import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
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
	@Lob
	public String content;
	
	public Boolean top;
	
	@Hidden
	public Long create_at = Calendar.getInstance().getTimeInMillis();
	
	@Hidden
	public Long update_at = Calendar.getInstance().getTimeInMillis();
	
	@ManyToMany(cascade=CascadeType.PERSIST)
	@JoinTable(name="t_cfg_blog_tags")
	public Set<TCfgTag> tags = new HashSet<TCfgTag>();
	
	public String toString(){
		return title;
	}
}
