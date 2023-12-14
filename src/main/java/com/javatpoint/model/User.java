package com.javatpoint.model;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="userdata")
public class User 
{
@Id
private Long id;
private String username;
public Long getId() 
{
return id;
}
public void setId(Long id) 
{
this.id = id;
}
public String getUname() 
{
return username;
}
public void setUname(String username) 
{
this.username = username;
}
@Override
public String toString() 
{
return "User [id=" + id + ", uname=" + username + "]";
}
}
