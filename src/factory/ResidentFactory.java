/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package factory;

import database.ConnectionFactory;
import database.DbUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.Resident;

/**
 *
 * @author Clark
 */
public class ResidentFactory {

    ConnectionFactory cf = new ConnectionFactory();
    DbUtil dbUtil = new DbUtil();
    List<Resident> residents = new ArrayList<>();
    Resident resident;

    public void addResident(Resident r) {
        Connection conn = cf.getConnection();
        try {
            PreparedStatement ps = conn.prepareStatement("INSERT INTO residents (r_fname, r_mname, r_lname, r_extname, r_gender, r_bday, "
                    + "r_contact, r_email, r_religion,r_civilstatus, r_isvoter, r_status,r_purok, r_addedby, r_addedon, r_modifiedby, r_modifiedon) "
                    + "values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
            ps.setString(1, r.getR_fname());
            ps.setString(2, r.getR_mname());
            ps.setString(3, r.getR_lname());
            ps.setString(4, r.getR_extname());
            ps.setString(5, r.getR_gender());
            ps.setString(6, r.getR_bday());
            ps.setString(7, r.getR_contact());
            ps.setString(8, r.getR_email());
            ps.setString(9, r.getR_religion());
            ps.setString(10, r.getR_civilstatus());
            ps.setString(11, r.getR_isvoter());
            ps.setString(12, r.getR_status());
            ps.setString(13, "" + r.getR_purok());
            ps.setString(14, "" + r.getR_addedby());
            ps.setString(15, r.getR_addedon());
            ps.setString(16, "" + r.getR_modifiedby());
            ps.setString(17, r.getR_modifiedon());

            ps.executeUpdate();

            dbUtil.close(conn);
            dbUtil.close(ps);

        } catch (Exception e) {
            System.out.print(e);
        }

    }

    public List<Resident> searchResidents(String s) {

        ResultSet rs;
        Connection conn = cf.getConnection();
        residents.clear();
        try {
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM residents WHERE concat(r_fname,r_mname,r_lname) LIKE  '%" + s + "%' "
                    + "ORDER BY  concat(r_fname,r_mname,r_lname) ASC, r_status ASC, r_purok ASC");
            rs = ps.executeQuery();

            while (rs.next()) {
                resident = new Resident(rs.getInt("r_id"), rs.getString("r_fname"), rs.getString("r_mname"), rs.getString("r_lname"), rs.getString("r_extname"),
                        rs.getString("r_gender"), rs.getString("r_bday"), rs.getString("r_contact"), rs.getString("r_email"), rs.getString("r_religion"),
                        rs.getString("r_civilstatus"), rs.getString("r_isvoter"), rs.getString("r_status"), rs.getInt("r_purok"), rs.getInt("r_addedby"), rs.getString("r_addedon"),
                        rs.getInt("r_modifiedby"), rs.getString("r_modifiedon"));

                residents.add(resident);
            }
            dbUtil.close(conn);
            dbUtil.close(rs);
            dbUtil.close(ps);

        } catch (Exception e) {
            System.out.print(e);
        }
        return residents;
    }

    public Resident getResident(int id) {

        ResultSet rs;
        Connection conn = cf.getConnection();
        try {
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM residents WHERE r_id = ?");
            ps.setString(1, "" + id);
            rs = ps.executeQuery();

            while (rs.next()) {
                resident = new Resident(rs.getInt("r_id"), rs.getString("r_fname"), rs.getString("r_mname"), rs.getString("r_lname"), rs.getString("r_extname"),
                        rs.getString("r_gender"), rs.getString("r_bday"), rs.getString("r_contact"), rs.getString("r_email"), rs.getString("r_religion"),
                        rs.getString("r_civilstatus"), rs.getString("r_isvoter"), rs.getString("r_status"), rs.getInt("r_purok"), rs.getInt("r_addedby"), rs.getString("r_addedon"),
                        rs.getInt("r_modifiedby"), rs.getString("r_modifiedon"));

            }
            dbUtil.close(conn);
            dbUtil.close(rs);
            dbUtil.close(ps);

        } catch (Exception e) {
            System.out.print(e);
        }
        return resident;
    }

    public List<Resident> getVoters() {

        ResultSet rs;
        Connection conn = cf.getConnection();
        residents.clear();
        try {
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM residents WHERE r_isvoter = 'YES'");
            rs = ps.executeQuery();

            while (rs.next()) {
                resident = new Resident(rs.getInt("r_id"), rs.getString("r_fname"), rs.getString("r_mname"), rs.getString("r_lname"), rs.getString("r_extname"),
                        rs.getString("r_gender"), rs.getString("r_bday"), rs.getString("r_contact"), rs.getString("r_email"), rs.getString("r_religion"),
                        rs.getString("r_civilstatus"), rs.getString("r_isvoter"), rs.getString("r_status"), rs.getInt("r_purok"), rs.getInt("r_addedby"), rs.getString("r_addedon"),
                        rs.getInt("r_modifiedby"), rs.getString("r_modifiedon"));

                residents.add(resident);
            }
            dbUtil.close(conn);
            dbUtil.close(rs);
            dbUtil.close(ps);

        } catch (Exception e) {
            System.out.print(e);
        }
        return residents;
    }

    public List<Resident> getSeniorCitizen() {

        ResultSet rs;
        Connection conn = cf.getConnection();
        residents.clear();
        try {
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM residents");
            rs = ps.executeQuery();

            while (rs.next()) {
                resident = new Resident(rs.getInt("r_id"), rs.getString("r_fname"), rs.getString("r_mname"), rs.getString("r_lname"), rs.getString("r_extname"),
                        rs.getString("r_gender"), rs.getString("r_bday"), rs.getString("r_contact"), rs.getString("r_email"), rs.getString("r_religion"),
                        rs.getString("r_civilstatus"), rs.getString("r_isvoter"), rs.getString("r_status"), rs.getInt("r_purok"), rs.getInt("r_addedby"), rs.getString("r_addedon"),
                        rs.getInt("r_modifiedby"), rs.getString("r_modifiedon"));

                if (resident.getAge() >= 60) {
                    residents.add(resident);
                }

            }
            dbUtil.close(conn);
            dbUtil.close(rs);
            dbUtil.close(ps);

        } catch (Exception e) {
            System.out.print(e);
        }
        return residents;
    }

    public List<Resident> getMale() {

        ResultSet rs;
        Connection conn = cf.getConnection();
        residents.clear();
        try {
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM residents WHERE r_gender = 'MALE'");
            rs = ps.executeQuery();

            while (rs.next()) {
                resident = new Resident(rs.getInt("r_id"), rs.getString("r_fname"), rs.getString("r_mname"), rs.getString("r_lname"), rs.getString("r_extname"),
                        rs.getString("r_gender"), rs.getString("r_bday"), rs.getString("r_contact"), rs.getString("r_email"), rs.getString("r_religion"),
                        rs.getString("r_civilstatus"), rs.getString("r_isvoter"), rs.getString("r_status"), rs.getInt("r_purok"), rs.getInt("r_addedby"), rs.getString("r_addedon"),
                        rs.getInt("r_modifiedby"), rs.getString("r_modifiedon"));

                residents.add(resident);
            }
            dbUtil.close(conn);
            dbUtil.close(rs);
            dbUtil.close(ps);

        } catch (Exception e) {
            System.out.print(e);
        }
        return residents;
    }

    public List<Resident> getFemale() {

        ResultSet rs;
        Connection conn = cf.getConnection();
        residents.clear();
        try {
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM residents WHERE r_gender = 'FEMALE'");
            rs = ps.executeQuery();

            while (rs.next()) {
                resident = new Resident(rs.getInt("r_id"), rs.getString("r_fname"), rs.getString("r_mname"), rs.getString("r_lname"), rs.getString("r_extname"),
                        rs.getString("r_gender"), rs.getString("r_bday"), rs.getString("r_contact"), rs.getString("r_email"), rs.getString("r_religion"),
                        rs.getString("r_civilstatus"), rs.getString("r_isvoter"), rs.getString("r_status"), rs.getInt("r_purok"), rs.getInt("r_addedby"), rs.getString("r_addedon"),
                        rs.getInt("r_modifiedby"), rs.getString("r_modifiedon"));

                residents.add(resident);
            }
            dbUtil.close(conn);
            dbUtil.close(rs);
            dbUtil.close(ps);

        } catch (Exception e) {
            System.out.print(e);
        }
        return residents;
    }

    public List<Resident> getActiveResidents() {

        ResultSet rs;
        Connection conn = cf.getConnection();
        residents.clear();
        try {
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM residents WHERE r_status = 'ACTIVE'");
            rs = ps.executeQuery();

            while (rs.next()) {
                resident = new Resident(rs.getInt("r_id"), rs.getString("r_fname"), rs.getString("r_mname"), rs.getString("r_lname"), rs.getString("r_extname"),
                        rs.getString("r_gender"), rs.getString("r_bday"), rs.getString("r_contact"), rs.getString("r_email"), rs.getString("r_religion"),
                        rs.getString("r_civilstatus"), rs.getString("r_isvoter"), rs.getString("r_status"), rs.getInt("r_purok"), rs.getInt("r_addedby"), rs.getString("r_addedon"),
                        rs.getInt("r_modifiedby"), rs.getString("r_modifiedon"));

                residents.add(resident);
            }
            dbUtil.close(conn);
            dbUtil.close(rs);
            dbUtil.close(ps);

        } catch (Exception e) {
            System.out.print(e);
        }
        return residents;
    }

    public List<Resident> getPurokMembers(int purok_id, String s) {

        ResultSet rs;
        Connection conn = cf.getConnection();
        residents.clear();
        try {
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM residents WHERE concat(r_fname,r_mname,r_lname) LIKE  '%" + s + "%' AND r_purok=?");
            ps.setString(1, "" + purok_id);
            rs = ps.executeQuery();

            while (rs.next()) {
                resident = new Resident(rs.getInt("r_id"), rs.getString("r_fname"), rs.getString("r_mname"), rs.getString("r_lname"), rs.getString("r_extname"),
                        rs.getString("r_gender"), rs.getString("r_bday"), rs.getString("r_contact"), rs.getString("r_email"), rs.getString("r_religion"),
                        rs.getString("r_civilstatus"), rs.getString("r_isvoter"), rs.getString("r_status"), rs.getInt("r_purok"), rs.getInt("r_addedby"), rs.getString("r_addedon"),
                        rs.getInt("r_modifiedby"), rs.getString("r_modifiedon"));

                residents.add(resident);
            }
            dbUtil.close(conn);
            dbUtil.close(rs);
            dbUtil.close(ps);

        } catch (Exception e) {
            System.out.print(e);
        }
        return residents;
    }

    public void updateResident(Resident r, int id) {
        Connection conn = cf.getConnection();
        try {
            PreparedStatement ps = conn.prepareStatement("UPDATE residents SET r_fname=?, r_mname=?, r_lname=?, r_extname=?, r_gender=?, r_bday=?,"
                    + "r_contact=?, r_email=?, r_religion=?, r_civilstatus=?, r_isvoter=?, r_status=?, r_purok=?, r_modifiedby=?, r_modifiedon=?"
                    + " WHERE r_id=?");
            ps.setString(1, r.getR_fname());
            ps.setString(2, r.getR_mname());
            ps.setString(3, r.getR_lname());
            ps.setString(4, r.getR_extname());
            ps.setString(5, r.getR_gender());
            ps.setString(6, r.getR_bday());
            ps.setString(7, r.getR_contact());
            ps.setString(8, r.getR_email());
            ps.setString(9, r.getR_religion());
            ps.setString(10, r.getR_civilstatus());
            ps.setString(11, r.getR_isvoter());
            ps.setString(12, r.getR_status());
            ps.setString(13, "" + r.getR_purok());
            ps.setString(14, "" + r.getR_modifiedby());
            ps.setString(15, r.getR_modifiedon());
            ps.setString(16, "" + id);

            ps.executeUpdate();

            dbUtil.close(conn);
            dbUtil.close(ps);

        } catch (Exception e) {
            System.out.print(e);
        }

    }

}
