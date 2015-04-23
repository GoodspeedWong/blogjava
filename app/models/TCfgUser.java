package models;

import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.persistence.Table;

import net.sf.oval.constraint.MaxLength;
import net.sf.oval.constraint.MinLength;
import play.data.validation.Max;
import play.data.validation.MaxSize;
import play.data.validation.Min;
import play.data.validation.MinSize;
import play.data.validation.Password;
import play.data.validation.Range;
import play.data.validation.Required;
import play.db.jpa.Model;

@Entity
@Table(name="t_cfg_user")
public class TCfgUser extends Model {

	@Required
	@MinSize(4)
	@MaxSize(14)
	public String name;
	
	@MinSize(4)
	@MaxSize(32)
	public String displayName;
	
	@MinSize(6)
	@MaxSize(64)
	@Password
	public String password;
	
	@Range(min=1,max=1000)
	public int age;
	
	@Lob
	@MaxSize(5000)
	public String description;
	
	public static TCfgUser connect(String name, String password){
		return find("name=? and password=?", name, password).first();
	}
	
	public String toString(){
		if(displayName!= null && !"".equals(displayName)){
			return displayName;
		} else {
			return name;
		}
	}
	
}
