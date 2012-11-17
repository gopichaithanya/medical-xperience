package model;

import java.util.Date;

import javax.persistence.*;


/**
 * Class used to register the login/logoff activity
 * @author Ricardo
 *
 */
@Entity
@Table(name="login_history")
public class LoginHistory {
	
	@Id
	@GeneratedValue
	private int id;
	private String username;
	private Date timestamp;
	private String ip;
	private String action;
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
	public Date getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public String getAction() {
		return action;
	}
	public void setAction(String action) {
		this.action = action;
	}
	
	
}
