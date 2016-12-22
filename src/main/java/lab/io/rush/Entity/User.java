
package lab.io.rush.Entity;
import java.io.Serializable;

import javax.jdo.annotations.*;

/**
 * Sample class that has a String field holding a Long.
 */
@PersistenceCapable
public class User implements Serializable
{

	@PrimaryKey
    int id;
    String name;
    String password;
    String mail;

    public User(){}
    
	public User(String name, String password, String mail) {
		super();
		this.name = name;
		this.password = password;
		this.mail = mail;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
 

}
