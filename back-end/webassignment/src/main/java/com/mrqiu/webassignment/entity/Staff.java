package com.mrqiu.webassignment.entity;


public class Staff {

  private String sid;
  private String saccount;
  private String spassword;
  private String sname;
  private String sgender;
  private String sdid;
  private String sposition;
  private String scontact;
  private String saddress;
  private long ssalaryHoliday;
  private java.sql.Timestamp sentryTime;


  public String getSid() {
    return sid;
  }

  public void setSid(String sid) {
    this.sid = sid;
  }


  public String getSaccount() {
    return saccount;
  }

  public void setSaccount(String saccount) {
    this.saccount = saccount;
  }


  public String getSpassword() {
    return spassword;
  }

  public void setSpassword(String spassword) {
    this.spassword = spassword;
  }


  public String getSname() {
    return sname;
  }

  public void setSname(String sname) {
    this.sname = sname;
  }


  public String getSgender() {
    return sgender;
  }

  public void setSgender(String sgender) {
    this.sgender = sgender;
  }


  public String getSdid() {
    return sdid;
  }

  public void setSdid(String sdid) {
    this.sdid = sdid;
  }


  public String getSposition() {
    return sposition;
  }

  public void setSposition(String sposition) {
    this.sposition = sposition;
  }


  public String getScontact() {
    return scontact;
  }

  public void setScontact(String scontact) {
    this.scontact = scontact;
  }


  public String getSaddress() {
    return saddress;
  }

  public void setSaddress(String saddress) {
    this.saddress = saddress;
  }


  public long getSsalaryHoliday() {
    return ssalaryHoliday;
  }

  public void setSsalaryHoliday(long ssalaryHoliday) {
    this.ssalaryHoliday = ssalaryHoliday;
  }


  public java.sql.Timestamp getSentryTime() {
    return sentryTime;
  }

  public void setSentryTime(java.sql.Timestamp sentryTime) {
    this.sentryTime = sentryTime;
  }

}
