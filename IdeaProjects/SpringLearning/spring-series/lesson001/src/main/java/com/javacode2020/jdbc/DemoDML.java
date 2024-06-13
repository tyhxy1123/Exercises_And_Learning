package com.javacode2020.jdbc;

import java.sql.*;

public class DemoDML {
    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306", "root", null);
            stmt = conn.createStatement();
            stmt.execute("use rookie");
            String sql = "insert into account values (98, '游戏王', 500000)";
            stmt.executeUpdate(sql);
        } catch (ClassNotFoundException | SQLException e){
            e.printStackTrace();
        } finally {
            try{
                assert stmt != null;
                stmt.close();
                conn.close();
            } catch(SQLException e){
                e.printStackTrace();
            }
        }
    }
}
