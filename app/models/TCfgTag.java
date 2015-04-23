package models;

import javax.persistence.Entity;
import javax.persistence.Table;

import play.data.validation.MaxSize;
import play.data.validation.Required;
import play.data.validation.Unique;
import play.db.jpa.Model;

@Entity
@Table(name="t_cfg_tag")
public class TCfgTag extends Model {

	@Required
	@Unique
	@MaxSize(64)
	public String name;
	
	public String toString(){
		return name;
	}
}
