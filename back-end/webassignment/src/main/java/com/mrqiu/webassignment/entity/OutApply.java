package com.mrqiu.webassignment.entity;


import java.sql.Timestamp;

public class OutApply {

  private long oid;
  private String ostaffId;
  private Timestamp ostartTime;
  private Timestamp oendTime;
  private long opriority;
  private String oreason;
  private String opassStaffId;
  private long ostatus;


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


  public long getOpriority() {
    return opriority;
  }

  public void setOpriority(long opriority) {
    this.opriority = opriority;
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


  public long getOstatus() {
    return ostatus;
  }

  public void setOstatus(long ostatus) {
    this.ostatus = ostatus;
  }

  @Override
  public String toString() {
    return "OutApply{" +
            "oid=" + oid +
            ", ostaffId='" + ostaffId + '\'' +
            ", ostartTime=" + ostartTime +
            ", oendTime=" + oendTime +
            ", opriority=" + opriority +
            ", oreason='" + oreason + '\'' +
            ", opassStaffId='" + opassStaffId + '\'' +
            ", ostatus=" + ostatus +
            '}';
  }
}
