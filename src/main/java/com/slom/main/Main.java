package com.slom.main;
import com.slom.dao.LaunchDAO;
import com.slom.dao.OrbitDAO;
import com.slom.dao.SatelliteDAO;
import com.slom.model.Launches;
import com.slom.model.Orbit;
import com.slom.model.Satellites;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Scanner;

import static java.lang.System.exit;

public class Main {
    public static void main(String[] args){
        /*try{
            Connection conn = DBConnection.getConnection();
            System.out.println("Connection Succesfull");
            conn.close();
        } catch (SQLException e) {
            System.out.println("Connection Failed" + e.getMessage());
        } */
        SatelliteDAO satelliteDAO = new SatelliteDAO();
        LaunchDAO launchDAO = new LaunchDAO();
        OrbitDAO orbitDAO = new OrbitDAO();
        Scanner sc=new Scanner(System.in);
        int choice;
       do {
           System.out.println(" ==== SATELLITE LAUNCH AND ORBIT MANAGER ==== ");
           System.out.println("1. Add Satellite ");
           System.out.println("2. Add Orbit ");
           System.out.println("3. Add Launch ");
           System.out.println("4. View All Satellites ");
           System.out.println("5. View Satellites By Orbit ");
           System.out.println("6. View All Orbits ");
           System.out.println("7. View Launch History ");
           System.out.println("0. Exit ");
           System.out.println("Enter your choice : ");
           choice = sc.nextInt();
           switch (choice) {
               case 0: {
                   exit(0);
                   break;
               }
               case 1: {
                   System.out.println("Enter Satellite ID : ");
                   long satid = sc.nextLong();
                   System.out.println("Enter Satellite Name : ");
                   String name = sc.next();
                   System.out.println("Enter Satellite Type : ");
                   String type = sc.next();
                   System.out.println("Enter Satellite Manufacturer : ");
                   String manufacturer = sc.next();
                   Satellites s = new Satellites(satid, name, type, manufacturer);
                   satelliteDAO.addSatellite(s);
                   break;
               }
               case 2: {
                   System.out.println("Enter Orbit ID : ");
                   long orbitid = sc.nextLong();
                   System.out.println("Enter Orbit Type : ");
                   String type = sc.next();
                   System.out.println("Enter Altitude : ");
                   double altitude = sc.nextDouble();
                   Orbit o = new Orbit(orbitid, type, altitude);
                   orbitDAO.addOrbit(o);
                   break;
               }
               case 3: {
                   System.out.println("Enter Satellite ID : ");
                   long satid = sc.nextLong();
                   System.out.println("Enter Orbit ID : ");
                   long orbitid = sc.nextLong();
                   System.out.println("Enter Launch ID : ");
                   long launchId = sc.nextLong();
                   sc.nextLine();
                   System.out.println("Enter Launch Date(YYYY-MM-DD HH:MM:SS) : ");
                   String dateinput = sc.nextLine();
                   Timestamp date = Timestamp.valueOf(dateinput);
                   System.out.println("Enter Launch Site : ");
                   String site = sc.next();
                   Launches l = new Launches(launchId, date, site, satid, orbitid);
                   launchDAO.addLaunch(l);
                   break;
               }
               case 4: {
                   satelliteDAO.ViewSatellite();
                   break;
               }
               case 5: {
                   System.out.println("Enter which orbit's satellites you wish to view :");
                   String type = sc.next();
                   satelliteDAO.ViewSatellitesByOrbit(type);
                   break;
               }
               case 6: {
                   orbitDAO.viewOrbits();
                   break;
               }
               case 7: {
                   launchDAO.viewLaunchHistory();
                   break;
               }
           }
       }while(choice!=0);
        sc.close();
    }
}
