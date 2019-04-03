package com.mrqiu.webassignment.entity;


import java.sql.Timestamp;

public class LeaveRecord {

  private long lid;
  private String lstaffId;
  private Timestamp lstartTime;
  private Timestamp lendTime;
  private String lreason;
  private String lpassStaffId;
  private long lkind;


  public long getLid() {
    return lid;
  }

  public void setLid(long lid) {
    this.lid = lid;
  }


  public String getLstaffId() {
    return lstaffId;
  }

  public void setLstaffId(String lstaffId) {
    this.lstaffId = lstaffId;
  }


  public Timestamp getLstartTime() {
    return lstartTime;
  }

  public void setLstartTime(Timestamp lstartTime) {
    this.lstartTime = lstartTime;
  }


  public Timestamp getLendTime() {
    return lendTime;
  }

  public void setLendTime(Timestamp lendTime) {
    this.lendTime = lendTime;
  }


  public String getLreason() {
    return lreason;
  }

  public void setLreason(String lreason) {
    this.lreason = lreason;
  }


  public String getLpassStaffId() {
    return lpassStaffId;
  }

  public void setLpassStaffId(String lpassStaffId) {
    this.lpassStaffId = lpassStaffId;
  }


  public long getLkind() {
    return lkind;
  }

  public void setLkind(long lkind) {
    this.lkind = lkind;
  }

  @Override
  public String toString() {
    return "LeaveRecord{" +
            "lid=" + lid +
            ", lstaffId='" + lstaffId + '\'' +
            ", lstartTime=" + lstartTime +
            ", lendTime=" + lendTime +
            ", lreason='" + lreason + '\'' +
            ", lpassStaffId='" + lpassStaffId + '\'' +
            ", lkind=" + lkind +
            '}';
  }
}
