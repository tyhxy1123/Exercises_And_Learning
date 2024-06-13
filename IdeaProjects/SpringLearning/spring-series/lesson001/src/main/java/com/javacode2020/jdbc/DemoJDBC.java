package com.javacode2020.jdbc;

import java.sql.*;

public class DemoJDBC {
    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306", "root", null);
            stmt = conn.createStatement();
            stmt.execute("use rookie");
            rs = stmt.executeQuery("select * from account");
            while(rs.next()){
                System.out.println(String.format("id: %d, name: %s, money: %s", rs.getInt("id"), rs.getString("name"), rs.getString("money")));
            }
        } catch (ClassNotFoundException | SQLException e){
            e.printStackTrace();
        } finally {
            try{
                assert rs != null;
                rs.close();
                stmt.close();
                conn.close();
            } catch(SQLException e){
                e.printStackTrace();
            }
        }
    }
}
