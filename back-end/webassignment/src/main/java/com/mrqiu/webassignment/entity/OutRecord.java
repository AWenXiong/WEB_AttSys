package com.mrqiu.webassignment.entity;


import java.sql.Timestamp;

public class OutRecord {

  private long oid;
  private String ostaffId;
  private Timestamp ostartTime;
  private Timestamp oendTime;
  private String oreason;
  private String opassStaffId;


  public long getOid() {
    return oid;
  }

  public void setOid(long oid) {
    this.oid = oid;
  }


  public String getOstaffId() {
    return ostaffId;
  }

  public void setOstaffId(String ostaffId) {
    this.ostaffId = ostaffId;
  }


  public Timestamp getOstartTime() {
    return ostartTime;
  }

  public void setOstartTime(Timestamp ostartTime) {
    this.ostartTime = ostartTime;
  }


  public Timestamp getOendTime() {
    return oendTime;
  }

  public void setOendTime(Timestamp oendTime) {
    this.oendTime = oendTime;
  }


  public String getOreason() {
    return oreason;
  }

  public void setOreason(String oreason) {
    this.oreason = oreason;
  }


  public String getOpassStaffId() {
    return opassStaffId;
  }

  public void setOpassStaffId(String opassStaffId) {
    this.opassStaffId = opassStaffId;
  }


  @Override
  public String toString() {
    return "OutRecord{" +
            "oid=" + oid +
            ", ostaffId='" + ostaffId + '\'' +
            ", ostartTime=" + ostartTime +
            ", oendTime=" + oendTime +
            ", oreason='" + oreason + '\'' +
            ", opassStaffId='" + opassStaffId + '\'' +
            '}';
  }
}
