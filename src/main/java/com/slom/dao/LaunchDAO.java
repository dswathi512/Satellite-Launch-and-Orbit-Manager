package com.slom.dao;

import com.slom.main.DBConnection;
import com.slom.model.Launches;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LaunchDAO {
    public void addLaunch(Launches l){
        try{
            Connection conn= DBConnection.getConnection();
            String sql="Insert into Launches values(?,?,?,?,?)";
            PreparedStatement stmt= conn.prepareStatement(sql);
            stmt.setLong(1,l.getLaunchId());
            stmt.setTimestamp(2,l.getLaunchDate());
            stmt.setString(3,l.getLaunchSite());
            stmt.setLong(4,l.getSatId());
            stmt.setLong(5,l.getOrbitId());
            stmt.executeUpdate();
            System.out.println("Launch SUCCESSFULL!!!");
            stmt.close();
            conn.close();
        }
        catch(SQLException e){
            e.printStackTrace();
        }
    }

    public void viewLaunchHistory(){
        try{
            Connection conn=DBConnection.getConnection();
            String sql="Select * from Launches";
            PreparedStatement stmt=conn.prepareStatement(sql);
            ResultSet rs=stmt.executeQuery();
            while(rs.next()){
                System.out.println(
                        "ID : " + rs.getLong("launch_id") +
                        " | Date : " + rs.getTimestamp("launch_date") +
                        " | Site : " + rs.getString("launch_site") +
                        " | Satellite ID : " + rs.getLong("sat_id") +
                        " | Orbit ID : " + rs.getLong("orbit_id")
                );
            }
            rs.close();
            stmt.close();
            conn.close();
        }
        catch(SQLException e){
            e.printStackTrace();
        }
    }
}
