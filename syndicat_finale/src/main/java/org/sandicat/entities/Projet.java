package org.sandicat.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
@Entity
public class Projet implements Serializable{
	@Id @GeneratedValue
private Long id;
private String lib;
private String title;
@Temporal(TemporalType.DATE)
private Date date_start;
@Temporal(TemporalType.DATE)
private Date date_fin;
public Long getId() {
	return id;
}
public void setId(Long id) {
	this.id = id;
}
public String getLib() {
	return lib;
}
public void setLib(String lib) {
	this.lib = lib;
}
public String getTitle() {
	return title;
}
public void setTitle(String title) {
	this.title = title;
}
public Date getDate_start() {
	return date_start;
}
public void setDate_start(Date date_start) {
	this.date_start = date_start;
}
public Date getDate_fin() {
	return date_fin;
}
public void setDate_fin(Date date_fin) {
	this.date_fin = date_fin;
}
public Projet() {
	super();
	// TODO Auto-generated constructor stub
}
public Projet(String lib, String title, Date date_start, Date date_fin) {
	super();
	this.lib = lib;
	this.title = title;
	this.date_start = date_start;
	this.date_fin = date_fin;
}



}
