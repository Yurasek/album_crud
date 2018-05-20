package com.crud.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionToDb {
   
    private static String dbUrl = "jdbc:mysql://localhost:3306/usersdata?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
    private static String dbUser = "root";
    private static String dbPass = "toor";
    
    public static Connection getConnection() {
          try  {
              Class.forName("com.mysql.cj.jdbc.Driver");
              Connection connection = DriverManager.getConnection(dbUrl, dbUser, dbPass);
              return connection;
          }
          catch(Exception ex) {
              System.out.println("Don't establish connection with database: " + ex.getMessage());
              ex.printStackTrace();
              return null;
          }
      }
 
       public static void closeConnection(Connection connection) {
          try  {
              connection.close();
          }
          catch(Exception ex) {
          }
      }
}
