/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Clark
 */
public class Official {

    public Official(int off_id, String off_username, String off_password, String off_role, String off_position, String off_commision, String off_status, int off_r_id) {
        this.off_id = off_id;
        this.off_username = off_username;
        this.off_password = off_password;
        this.off_role = off_role;
        this.off_position = off_position;
        this.off_commision = off_commision;
        this.off_status = off_status;
        this.off_r_id = off_r_id;
    }

    /**
     * @return the off_id
     */
    public int getOff_id() {
        return off_id;
    }

    /**
     * @param off_id the off_id to set
     */
    public void setOff_id(int off_id) {
        this.off_id = off_id;
    }

    /**
     * @return the off_username
     */
    public String getOff_username() {
        return off_username;
    }

    /**
     * @param off_username the off_username to set
     */
    public void setOff_username(String off_username) {
        this.off_username = off_username;
    }

    /**
     * @return the off_password
     */
    public String getOff_password() {
        return off_password;
    }

    /**
     * @param off_password the off_password to set
     */
    public void setOff_password(String off_password) {
        this.off_password = off_password;
    }

    /**
     * @return the off_role
     */
    public String getOff_role() {
        return off_role;
    }

    /**
     * @param off_role the off_role to set
     */
    public void setOff_role(String off_role) {
        this.off_role = off_role;
    }

    /**
     * @return the off_position
     */
    public String getOff_position() {
        return off_position;
    }

    /**
     * @param off_position the off_position to set
     */
    public void setOff_position(String off_position) {
        this.off_position = off_position;
    }

    /**
     * @return the off_commision
     */
    public String getOff_commision() {
        return off_commision;
    }

    /**
     * @param off_commision the off_commision to set
     */
    public void setOff_commision(String off_commision) {
        this.off_commision = off_commision;
    }

    /**
     * @return the off_status
     */
    public String getOff_status() {
        return off_status;
    }

    /**
     * @param off_status the off_status to set
     */
    public void setOff_status(String off_status) {
        this.off_status = off_status;
    }

    /**
     * @return the off_r_id
     */
    public int getOff_r_id() {
        return off_r_id;
    }

    /**
     * @param off_r_id the off_r_id to set
     */
    public void setOff_r_id(int off_r_id) {
        this.off_r_id = off_r_id;
    }
    private int off_id;
    private String off_username;
    private String off_password;
    private String off_role;
    private String off_position;
    private String off_commision;
    private String off_status;
    private int  off_r_id;
    
    
    
    
    
    
}
