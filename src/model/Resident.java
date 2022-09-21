/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Clark
 */
public class Resident {

    /**
     * @return the r_id
     */
    public int getR_id() {
        return r_id;
    }

    /**
     * @param r_id the r_id to set
     */
    public void setR_id(int r_id) {
        this.r_id = r_id;
    }

    /**
     * @return the r_fname
     */
    public String getR_fname() {
        return r_fname;
    }

    /**
     * @param r_fname the r_fname to set
     */
    public void setR_fname(String r_fname) {
        this.r_fname = r_fname;
    }

    /**
     * @return the r_mname
     */
    public String getR_mname() {
        return r_mname;
    }

    /**
     * @param r_mname the r_mname to set
     */
    public void setR_mname(String r_mname) {
        this.r_mname = r_mname;
    }

    /**
     * @return the r_lname
     */
    public String getR_lname() {
        return r_lname;
    }

    /**
     * @param r_lname the r_lname to set
     */
    public void setR_lname(String r_lname) {
        this.r_lname = r_lname;
    }

    /**
     * @return the r_extname
     */
    public String getR_extname() {
        return r_extname;
    }

    /**
     * @param r_extname the r_extname to set
     */
    public void setR_extname(String r_extname) {
        this.r_extname = r_extname;
    }

    /**
     * @return the r_gender
     */
    public String getR_gender() {
        return r_gender;
    }

    /**
     * @param r_gender the r_gender to set
     */
    public void setR_gender(String r_gender) {
        this.r_gender = r_gender;
    }

    /**
     * @return the r_bday
     */
    public String getR_bday() {
        return r_bday;
    }

    /**
     * @param r_bday the r_bday to set
     */
    public void setR_bday(String r_bday) {
        this.r_bday = r_bday;
    }

    /**
     * @return the r_contact
     */
    public String getR_contact() {
        return r_contact;
    }

    /**
     * @param r_contact the r_contact to set
     */
    public void setR_contact(String r_contact) {
        this.r_contact = r_contact;
    }

    /**
     * @return the r_email
     */
    public String getR_email() {
        return r_email;
    }

    /**
     * @param r_email the r_email to set
     */
    public void setR_email(String r_email) {
        this.r_email = r_email;
    }

    /**
     * @return the r_religion
     */
    public String getR_religion() {
        return r_religion;
    }

    /**
     * @param r_religion the r_religion to set
     */
    public void setR_religion(String r_religion) {
        this.r_religion = r_religion;
    }

    /**
     * @return the r_civilstatus
     */
    public String getR_civilstatus() {
        return r_civilstatus;
    }

    /**
     * @param r_civilstatus the r_civilstatus to set
     */
    public void setR_civilstatus(String r_civilstatus) {
        this.r_civilstatus = r_civilstatus;
    }

    /**
     * @return the r_isvoter
     */
    public String getR_isvoter() {
        return r_isvoter;
    }

    /**
     * @param r_isvoter the r_isvoter to set
     */
    public void setR_isvoter(String r_isvoter) {
        this.r_isvoter = r_isvoter;
    }

    /**
     * @return the r_status
     */
    public String getR_status() {
        return r_status;
    }

    /**
     * @param r_status the r_status to set
     */
    public void setR_status(String r_status) {
        this.r_status = r_status;
    }

    /**
     * @return the r_addedby
     */
    public int getR_addedby() {
        return r_addedby;
    }

    /**
     * @param r_addedby the r_addedby to set
     */
    public void setR_addedby(int r_addedby) {
        this.r_addedby = r_addedby;
    }

    /**
     * @return the r_addedon
     */
    public String getR_addedon() {
        return r_addedon;
    }

    /**
     * @param r_addedon the r_addedon to set
     */
    public void setR_addedon(String r_addedon) {
        this.r_addedon = r_addedon;
    }

    /**
     * @return the r_modifiedby
     */
    public int getR_modifiedby() {
        return r_modifiedby;
    }

    /**
     * @param r_modifiedby the r_modifiedby to set
     */
    public void setR_modifiedby(int r_modifiedby) {
        this.r_modifiedby = r_modifiedby;
    }

    /**
     * @return the r_modifiedon
     */
    public String getR_modifiedon() {
        return r_modifiedon;
    }

    /**
     * @param r_modifiedon the r_modifiedon to set
     */
    public void setR_modifiedon(String r_modifiedon) {
        this.r_modifiedon = r_modifiedon;
    }

    public String getFullName() {
        return getR_lname() + ", " + getR_fname() + " " + getR_mname() + " " + getR_extname();
    }

    public int getAge() {
        Date bd=null;
        try {
            bd = new SimpleDateFormat("dd/MM/yyyy").parse(r_bday);
        } catch (ParseException ex) {
            Logger.getLogger(Resident.class.getName()).log(Level.SEVERE, null, ex);
        }
        LocalDate today = LocalDate.now();
        LocalDate bday = Instant.ofEpochMilli(bd.getTime())
                .atZone(ZoneId.systemDefault())
                .toLocalDate();//Today's date

        Period period = Period.between(bday, today);
        return period.getYears();
    }

    public Resident(int r_id, String r_fname, String r_mname, String r_lname, String r_extname, String r_gender, String r_bday, String r_contact, String r_email, String r_religion, String r_civilstatus, String r_isvoter, String r_status, int r_purok, int r_addedby, String r_addedon, int r_modifiedby, String r_modifiedon) {
        this.r_id = r_id;
        this.r_fname = r_fname;
        this.r_mname = r_mname;
        this.r_lname = r_lname;
        this.r_extname = r_extname;
        this.r_gender = r_gender;
        this.r_bday = r_bday;
        this.r_contact = r_contact;
        this.r_email = r_email;
        this.r_religion = r_religion;
        this.r_civilstatus = r_civilstatus;
        this.r_isvoter = r_isvoter;
        this.r_status = r_status;
        this.r_purok = r_purok;
        this.r_addedby = r_addedby;
        this.r_addedon = r_addedon;
        this.r_modifiedby = r_modifiedby;
        this.r_modifiedon = r_modifiedon;
    }



    private int r_id;
    private String r_fname;
    private String r_mname;
    private String r_lname;
    private String r_extname;
    private String r_gender;
    private String r_bday;
    private String r_contact;
    private String r_email;
    private String r_religion;
    private String r_civilstatus;
    private String r_isvoter;
    private String r_status;
    private int r_purok;
    private int r_addedby;
    private String r_addedon;
    private int r_modifiedby;
    private String r_modifiedon;

    /**
     * @return the r_purok
     */
    public int getR_purok() {
        return r_purok;
    }

    /**
     * @param r_purok the r_purok to set
     */
    public void setR_purok(int r_purok) {
        this.r_purok = r_purok;
    }

}
