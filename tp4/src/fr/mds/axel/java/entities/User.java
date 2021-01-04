package fr.mds.axel.java.entities;

import java.util.ArrayList;
import java.util.List;

public class User {

  private long id;
  private String firstname;
  private String lastname;
  private Hobby mainHobby;
  private List<Hobby> hobbies = new ArrayList<Hobby>();
  private Job job;

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getFirstname() {
    return firstname;
  }

  public void setFirstname(String firstname) {
    this.firstname = firstname;
  }

  public String getLastname() {
    return lastname;
  }

  public void setLastname(String lastname) {
    this.lastname = lastname;
  }

  public Hobby getMainHobby() {
    return mainHobby;
  }

  public void setMainHobby(Hobby mainHobby) {
    this.mainHobby = mainHobby;
  }

  public Job getJob() {
    return job;
  }

  public void setJob(Job job) {
    this.job = job;
  }

  public List<Hobby> getHobbies() {
    return this.hobbies;
  }

  @Override
  public String toString() {
    return "User [id=" + id + ", firstname=" + firstname + ", lastname=" + lastname + ", mainHobby=" + mainHobby
        + ", hobbies=" + hobbies + ", job=" + job + "]";
  }
}
