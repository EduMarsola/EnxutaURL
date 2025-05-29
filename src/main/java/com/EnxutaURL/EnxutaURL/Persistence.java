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
        String reply = ExecuteResponse("select URL_original from URLs where URL_short = '"+ compactURL+"';");
        DisposeConnection();
        return reply;
    }

    private static String ExecuteResponse(String query){
        String reply = "";
        try{
            Statement st = c.createStatement();
            ResultSet res = st.executeQuery(query);
            while(res.next()){
                reply += res.getString("URL_original");
            }
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
        try{
            c = DriverManager.getConnection("jdbc:mysql://localhost:3306/EnxutaURL", "root", "null");
        }catch(SQLException e){
            throw new RuntimeException(e);
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
