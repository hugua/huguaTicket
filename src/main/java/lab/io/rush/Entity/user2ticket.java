package lab.io.rush.Entity;

import java.io.Serializable;

import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.PrimaryKey;

@PersistenceCapable
public class user2ticket implements Serializable{
	@PrimaryKey
	int id;
	String username;
	int ticket_id;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public int getTicket_id() {
		return ticket_id;
	}
	public void setTicket_id(int ticket_id) {
		this.ticket_id = ticket_id;
	}
	public user2ticket(String username, int ticket_id) {
		super();
		this.username = username;
		this.ticket_id = ticket_id;
	}
	
}
