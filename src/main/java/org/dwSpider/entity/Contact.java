package org.dwSpider.entity;

import java.util.Date;

/**
 * Created by wenjing on 2017/3/16.
 */
public class Contact {
    private String casNo;
    private String casName;
    private String cName;
    private String mobile;
    private String email;
    private String message;
    private String country;
    private String city;
    private Date updataDate;
    private String contacted;
    private String intention;

    public String getCasNo() {
        return casNo;
    }

    public void setCasNo(String casNo) {
        this.casNo = casNo;
    }

    public String getCasName() {
        return casName;
    }

    public void setCasName(String casName) {
        this.casName = casName;
    }

    public String getcName() {
        return cName;
    }

    public void setcName(String cName) {
        this.cName = cName;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Date getUpdataDate() {
        return updataDate;
    }

    public void setUpdataDate(Date updataDate) {
        this.updataDate = updataDate;
    }

    public String getContacted() {
        return contacted;
    }

    public void setContacted(String contacted) {
        this.contacted = contacted;
    }

    public String getIntention() {
        return intention;
    }

    public void setIntention(String intention) {
        this.intention = intention;
    }
}
