package com.slom.dao;

import com.slom.main.DBConnection;
import com.slom.model.Satellites;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SatelliteDAO {
    public void  addSatellite(Satellites s){
        try{
            Connection conn= DBConnection.getConnection();
            String sql="Insert into Satellites values (?,?,?,?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setLong(1,s.getSatId());
            stmt.setString(2,s.getName());
            stmt.setString(3,s.getType());
            stmt.setString(4,s.getManufacturer());
            stmt.executeUpdate();
            System.out.println("Satellite added Successfully !!!  ");
            stmt.close();
            conn.close();
        }
        catch(SQLException e){
            e.printStackTrace();
        }
    }

    public void ViewSatellite(){
        try{
            Connection conn=DBConnection.getConnection();
            String sql="Select * from Satellites";
            PreparedStatement stmt=conn.prepareStatement(sql);
            ResultSet rs=stmt.executeQuery();
            while(rs.next()){
                System.out.println(
                        "ID : " + rs.getLong("sat_id") +
                        " | Name : " + rs.getString("name") +
                        " | Type : " + rs.getString("type") +
                         " | Manufacturer : "  + rs.getString("manufacturer")
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

    public void ViewSatellitesByOrbit(String orbitType){
        try{
            Connection conn=DBConnection.getConnection();
            String sql="Select s.sat_id,s.name,o.orbit_type from Satellites s "+
                       "join Launches l on l.sat_id = s.sat_id " +
                       "join orbit o on l.orbit_id = o.orbit_id " +
                       "where o.orbit_type = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1,orbitType);
            ResultSet rs=stmt.executeQuery();
            while(rs.next()){
                System.out.println(
                        " ID : " + rs.getLong("sat_id") +
                        " | Name : " + rs.getString("name") +
                        " | Orbit Type : " + rs.getString("orbit_type")
                );
            }
            rs.close();
            stmt.close();
            conn.close();
        }
        catch(SQLException e){
            e.printStackTrace();;
        }
    }
}
