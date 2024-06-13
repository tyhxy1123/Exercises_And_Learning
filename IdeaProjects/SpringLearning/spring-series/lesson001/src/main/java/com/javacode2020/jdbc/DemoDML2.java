package com.javacode2020.jdbc;

import kotlin.text.StringsKt;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DemoDML2 {
    public static void main(String[] args) {
        Integer id = null;
        String name = null;
        Float money = null;
        Connection conn = null;
        Statement stmt = null;

        if(args.length != 3){
            System.out.println("Need 3 parameters");
            System.exit(-1);
        }

        try{
            id = Integer.parseInt(args[0]);
            name = args[1];
            money = Float.parseFloat(args[2]);
        }catch (NumberFormatException e){
            e.printStackTrace();
            System.out.println("parameters format error");
            System.exit(-1);
        }

        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306", "root", null);
            stmt = conn.createStatement();
            stmt.execute("use rookie");
            String sql = String.format("insert into account values (%d, %s, %f)", id, name, money);
            System.out.println(sql);
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
