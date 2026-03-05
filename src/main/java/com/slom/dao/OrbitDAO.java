package com.slom.dao;

import com.slom.main.DBConnection;
import com.slom.model.Orbit;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class OrbitDAO {
    public void addOrbit(Orbit o){
        try{
            Connection conn= DBConnection.getConnection();
            String sql="Insert into Orbit values(?,?,?)";
            PreparedStatement stmt=conn.prepareStatement(sql);
            stmt.setLong(1,o.getOrbitId());
            stmt.setString(2,o.getOrbitType());
            stmt.setDouble(3,o.getAltitude());
            stmt.executeUpdate();
            System.out.println("Orbit details added successfully !!! ");
            stmt.close();
            conn.close();
        }
        catch(SQLException e){
            e.printStackTrace();
        }
    }

    public void viewOrbits(){
        try{
            Connection conn=DBConnection.getConnection();
            String sql="Select * from orbit";
            PreparedStatement stmt=conn.prepareStatement(sql);
            ResultSet rs=stmt.executeQuery();
            while(rs.next()){
                System.out.println(
                        "ID : " +rs.getLong("orbit_id") +
                        " | Type : " + rs.getString("orbit_type") +
                        " | Altitude : " + rs.getDouble("altitude")
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
