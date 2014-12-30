/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistence.util;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import javax.naming.NamingException;
import static persistence.util.GenericDAO.conn;

public abstract class DAO<A> {
    protected static Connection conn = null;
    protected Statement statement;
    
    public static void initConnection() throws NamingException, SQLException{
        //Context context = new InitialContext();
        //DataSource dataSource = (DataSource) context.lookup("java:comp/env/jdbc/habitat");
        GenericDAO.conn = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/habitat",
                "ola", 
                ""
        );
    }


    protected void newStatement() throws SQLException{
        statement = conn.createStatement();
    }
   
    protected ResultSet executeSelect(String query) throws SQLException{
        ResultSet rs = statement.executeQuery(query);
        return rs;
    }
    
    protected void executeSQL(String query) throws SQLException{
        statement.executeUpdate(query);
    }
    protected int executeSQLWithId(String query) throws SQLException{
        int affectedRows = statement.executeUpdate(query,  Statement.RETURN_GENERATED_KEYS);
        if (affectedRows == 0) {
            throw new SQLException("Creating failed, no rows affected.");
        }

        try (ResultSet generatedKeys = statement.getGeneratedKeys()) {
            if (generatedKeys.next()) {
               return generatedKeys.getInt(1);
            }
            else {
                throw new SQLException("Creating failed, no ID obtained.");
            }
        }
    }
    protected void closeStatemnet() throws SQLException{;
        statement.close();
        statement = null;
    }
    
    public abstract A getById(int id) throws SQLException;

    public abstract ArrayList<A> getAll() throws SQLException;

    public abstract int insert(A obj)throws SQLException;

    public abstract void remove(A obj) throws SQLException;

    public abstract void update(A obj) throws SQLException;

    protected String toSQL(GregorianCalendar o){
        if (o == null){
            return "NULL";
        }else{
            DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
            return "'" + df.format(o.getTime()) + "'";
        }
    }
    
    protected String toSQL(String o){
        if (o == null){
            return "NULL";
        }else{
            return "'" + o + "'";
        }
    }
    
    protected String toSQL(boolean o){
        return Boolean.toString(o);
    }
    
    protected String toSQL(int o){
        return "'" + o + "'";
    }
    
    protected String toSQL(double o){
        return "'" + o + "'";
    }
    
    protected GregorianCalendar fromSQL(Date date){
        if (date == null){
            return null;
        }
        GregorianCalendar g = new GregorianCalendar();
        g.setTime(new java.util.Date(date.getTime()));
        return g;
    }
}