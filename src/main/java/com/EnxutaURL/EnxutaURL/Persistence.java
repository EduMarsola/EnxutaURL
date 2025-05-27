package com.EnxutaURL.EnxutaURL;

import java.sql.*;
import java.util.Optional;

public abstract class Persistence{
    static Connection c = null;
    public static void In(String subject){
        CreateConnection();
        Execute("insert into URLS (compactURL) values "+ subject);
        DisposeConnection();
    }

    public static String Out(String compactURL){
        CreateConnection();
        String reply = Execute("select originalURL from URLS where compactURL = " + compactURL);
        DisposeConnection();
        return reply;
    }

    private static String Execute(String query){
        String reply = null;
        try{
            Statement st = c.createStatement();
            ResultSet res = st.executeQuery(query);
            reply = res.getString("");
        }catch(SQLException e){
            throw new RuntimeException(e);
        }
        return reply;
    }
    private static void CreateConnection(){
        if(c == null){
            try{
                c = DriverManager.getConnection("", "", "");
            }catch(SQLException e){
                throw new RuntimeException(e);
            }
        }
    }

    private static void DisposeConnection(){
        if(c != null){
            try{
                c.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }

}
