package com.EnxutaURL.EnxutaURL;

import java.sql.*;
import java.util.Optional;

public abstract class Persistence{
    static Connection c = null;
    public static void In(String originalURL, String compactURL){
        CreateConnection();
        Execute("insert into URLs (URL_original, URL_short) values ('"+ originalURL +"','"+compactURL+"');");
        DisposeConnection();
    }

    public static String Out(String compactURL){
        CreateConnection();
        String reply = ExecuteResponse("select originalURL from URLs where compactURL = " + compactURL+";");
        DisposeConnection();
        return reply;
    }

    private static String ExecuteResponse(String query){
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

    private static void Execute(String query){
        try{
            Statement st = c.createStatement();
            st.execute("use EnxutaURL;");
            st.execute(query);
        }catch(SQLException e){
            throw new RuntimeException(e);
        }
    }
    private static void CreateConnection(){
        if(c == null){
            try{
                c = DriverManager.getConnection("jdbc:mysql://localhost:3306/EnxutaURL", "root", "null");
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
