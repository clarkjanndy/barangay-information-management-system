/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author USER
 */
public class ConnectionFactory {

    public String DATABASE_LINK = "C:\\Barangay Management Information System\\src\\database\\BMIS.accdb";
    Connection connection;

    public Connection getConnection() {
        try {
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            connection = DriverManager.getConnection("jdbc:ucanaccess://" + DATABASE_LINK);
        } catch (Exception e) {
            System.out.print(e);

        }
        return connection;

    }

}
