/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author USER
 */
public class DbUtil {

    public void close(Connection connection) {
        try {

            connection.close();
        } catch (Exception e) {

        }

    }

    public void close(PreparedStatement ps) {
        try {
            ps.close();
        } catch (Exception e) {

        }

    }
    
    
    public void close(ResultSet rs) {
        try {
            rs.close();
        } catch (Exception e) {

        }

    }
    

}
