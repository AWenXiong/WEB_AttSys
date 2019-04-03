package com.mrqiu.webassignment.entity;


import java.sql.Timestamp;

public class Sign {

  private long sid;
  private String sstaffId;
  private Timestamp stime;


  public long getSid() {
    return sid;
  }

  public void setSid(long sid) {
    this.sid = sid;
  }


  public String getSstaffId() {
    return sstaffId;
  }

  public void setSstaffId(String sstaffId) {
    this.sstaffId = sstaffId;
  }


  public Timestamp getStime() {
    return stime;
  }

  public void setStime(Timestamp stime) {
    this.stime = stime;
  }

  @Override
  public String toString() {
    return "Sign{" +
            "sid=" + sid +
            ", sstaffId='" + sstaffId + '\'' +
            ", stime=" + stime +
            '}';
  }
}
