package com.jacaranda;

import java.sql.Date;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;



@Entity(name="USERS")
public class Users {
	@Id
	
	private String nick;
	private String password;
	private String name;
	
	private String dateUser;
	private boolean gender;
	private boolean admin;
	
	
	
	
	public Users() {
		super();
		
		this.password=null;
		this.name=null;
		this.nick=null;
		this.dateUser=null;
		this.gender=true;
		this.admin=false;
	}

	

	public String getPassword() {
		return password;
	}

	public void setPassword(String password)throws UserException {
		if(password.length()>32||password.length()<1) {
			throw new UserException("Contraseña demasiado larga o inexistente");
		}else {
			this.password = password;
		}
		
	}

	public String getName(){
		return name;
	}

	public void setName(String name)throws UserException {
		if(name.length()>200|| name.length()<2) {
			throw new UserException("Nombre de usuario demasiado largo o corto");
		}
		this.name = name;
	}

	public String getNick() {
		return nick;
	}

	public void setNick(String nick)throws UserException {
		if(nick.length()>100||nick.length()<2) {
			throw new UserException("Nick demasiado largo o corto");
		}
		this.nick = nick;
	}

	public String getDate() {
		return dateUser;
	}

	public void setDate(String date) throws UserException {
		if(date.equals(null)) {
			throw new UserException("El campo fecha es necesario");
		}
		this.dateUser = date;
	}

	public boolean isGender() {
		return gender;
	}

	public void setGender(boolean gender) {
		this.gender = gender;
	}

	public boolean isAdmin() {
		return admin;
	}

	public void setAdmin(boolean admin) {
		this.admin = admin;
	}

	

	@Override
	public int hashCode() {
		return Objects.hash(nick, password);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Users other = (Users) obj;
		return Objects.equals(nick, other.nick) && Objects.equals(password, other.password);
	}
	
	
	
}
