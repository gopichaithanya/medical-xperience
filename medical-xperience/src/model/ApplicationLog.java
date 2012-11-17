package model;

import java.util.Date;

import javax.persistence.*;

@Entity
@Table (name="application_log")
public class ApplicationLog {
	
	@Id
	@GeneratedValue
	private int id;
	private String fromWhere;
	private String fromUser;
	private String ip;
	private String action;
	private String log_message;
	private Date timestamp;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFromWhere() {
		return fromWhere;
	}
	public void setFromWhere(String fromWhere) {
		this.fromWhere = fromWhere;
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
	public String getLog_message() {
		return log_message;
	}
	public void setLog_message(String log_message) {
		this.log_message = log_message;
	}

	public String getFromUser() {
		return fromUser;
	}
	public void setFromUser(String fromUser) {
		this.fromUser = fromUser;
	}
	public Date getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}
	
	
	
}
