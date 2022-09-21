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
import model.Official;

/**
 *
 * @author Clark
 */
public class OfficialFactory {

    ConnectionFactory cf = new ConnectionFactory();
    DbUtil dbUtil = new DbUtil();
    List<Official> officials = new ArrayList<>();
    Official official;

    public void addOfficial(Official o) {
        Connection conn = cf.getConnection();
        try {
            PreparedStatement ps = conn.prepareStatement("INSERT INTO officials (off_username, off_password, off_role, off_position, off_commision, off_status, off_r_id) "
                    + "values (?,?,?,?,?,?,?)");
            ps.setString(1, o.getOff_username());
            ps.setString(2, o.getOff_password());
            ps.setString(3, o.getOff_role());
            ps.setString(4, o.getOff_position());
            ps.setString(5, o.getOff_commision());
            ps.setString(6, o.getOff_status());
            ps.setString(7, "" + o.getOff_r_id());

            ps.executeUpdate();

            dbUtil.close(conn);
            dbUtil.close(ps);

        } catch (Exception e) {
            System.out.print(e);
        }

    }

    public List<Official> searchOfficial(String s) {

        ResultSet rs;
        Connection conn = cf.getConnection();
        officials.clear();
        try {
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM officials INNER JOIN  residents on officials.off_r_id=residents.r_id"
                    + " WHERE concat(r_fname,r_mname,r_lname) LIKE  '%" + s + "%'");

            rs = ps.executeQuery();

            while (rs.next()) {
                official = new Official(rs.getInt("off_id"), rs.getString("off_username"), rs.getString("off_password"), rs.getString("off_role"),
                        rs.getString("off_position"), rs.getString("off_commision"), rs.getString("off_status"), rs.getInt("off_r_id"));

                officials.add(official);
            }
            dbUtil.close(conn);
            dbUtil.close(rs);
            dbUtil.close(ps);

        } catch (Exception e) {
            System.out.print(e);
        }
        return officials;
    }

    public Official getOfficial(int id) {

        ResultSet rs;
        Connection conn = cf.getConnection();
        try {
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM officials WHERE off_id = ? ");
            ps.setString(1, "" + id);

            rs = ps.executeQuery();

            while (rs.next()) {
                official = new Official(rs.getInt("off_id"), rs.getString("off_username"), rs.getString("off_password"), rs.getString("off_role"),
                        rs.getString("off_position"), rs.getString("off_commision"), rs.getString("off_status"), rs.getInt("off_r_id"));

            }
            dbUtil.close(conn);
            dbUtil.close(rs);
            dbUtil.close(ps);

        } catch (Exception e) {
            System.out.print(e);
        }
        return official;
    }

    public Official login(String username, String password) {

        ResultSet rs;
        Connection conn = cf.getConnection();
        try {
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM officials WHERE off_username =? AND off_password=?");
            ps.setString(1, username);
            ps.setString(2, password);

            rs = ps.executeQuery();

            while (rs.next()) {
                official = new Official(rs.getInt("off_id"), rs.getString("off_username"), rs.getString("off_password"), rs.getString("off_role"),
                        rs.getString("off_position"), rs.getString("off_commision"), rs.getString("off_status"), rs.getInt("off_r_id"));

            }
            dbUtil.close(conn);
            dbUtil.close(rs);
            dbUtil.close(ps);

        } catch (Exception e) {
            System.out.print(e);
        }
        return official;
    }

    public void changePassword(String password, int id) {
        Connection conn = cf.getConnection();
        try {
            PreparedStatement ps = conn.prepareStatement("UPDATE officials SET off_password=? WHERE off_id=?");
            ps.setString(1, password);
            ps.setString(2, "" + id);

            ps.executeUpdate();

            dbUtil.close(conn);
            dbUtil.close(ps);

        } catch (Exception e) {
            System.out.print(e);
        }
    }

    public void updateOfficial(Official off, int id) {
        Connection conn = cf.getConnection();
        try {
            PreparedStatement ps = conn.prepareStatement("UPDATE officials SET off_password=?, off_role=?, off_position=?, off_commision=?, off_status=?"
                    + " WHERE off_id=?");
            ps.setString(1, off.getOff_password());
            ps.setString(2, off.getOff_role());
            ps.setString(3, off.getOff_position());
            ps.setString(4, off.getOff_commision());
            ps.setString(5, off.getOff_status());
            ps.setString(6, "" + id);

            ps.executeUpdate();

            dbUtil.close(conn);
            dbUtil.close(ps);

        } catch (Exception e) {
            System.out.print(e);
        }

    }

}
