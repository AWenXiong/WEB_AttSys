package com.mrqiu.webassignment.entity;


import java.sql.Timestamp;

public class LeaveApply {

  private long lid;
  private String lstaffId;
  private Timestamp lstartTime;
  private Timestamp lendTime;
  private long lpriority;
  private String lreason;
  private String lpassStaffId;
  private long lkind;
  private long lstatus;


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


  public long getLpriority() {
    return lpriority;
  }

  public void setLpriority(long lpriority) {
    this.lpriority = lpriority;
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


  public long getLstatus() {
    return lstatus;
  }

  public void setLstatus(long lstatus) {
    this.lstatus = lstatus;
  }

  @Override
  public String toString() {
    return "LeaveApply{" +
            "lid=" + lid +
            ", lstaffId='" + lstaffId + '\'' +
            ", lstartTime=" + lstartTime +
            ", lendTime=" + lendTime +
            ", lpriority=" + lpriority +
            ", lreason='" + lreason + '\'' +
            ", lpassStaffId='" + lpassStaffId + '\'' +
            ", lkind=" + lkind +
            ", lstatus=" + lstatus +
            '}';
  }
}
