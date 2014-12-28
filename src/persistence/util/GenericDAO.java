/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistence.util;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public abstract class GenericDAO<A> extends DAO<A>{
    protected Enum<?>[] attrs;
    protected int indexNotKey;
    protected String tableName;

    public GenericDAO(Enum<?>[] attrs, int indexNotKey, String tableName) {
        this.attrs = attrs;
        this.indexNotKey = indexNotKey;
        this.tableName = tableName;
    }
    
    protected abstract String getToBD(A p, Enum<?> a);
    public abstract A newObject(ResultSet rs)throws SQLException ;
    
    @Override
    public A getById(int id) throws SQLException {
        newStatement();
    
        ResultSet rs = executeSelect("Select " + queryBuilderAttrs(0)
                + " from " + tableName + ""
                + " where " + attrs[0].name() + " = " + id 
                );
        A f = null;
        if (rs.next()) {
            f = newObject(rs);
        }
        
        closeStatemnet();
        return f;
    }

    /**
     *
     * @return
     * @throws SQLException
     */
    @Override
    public ArrayList<A> getAll() throws SQLException {
        ArrayList<A> list = new ArrayList<>();
        newStatement();
        ResultSet rs = executeSelect("Select "+ queryBuilderAttrs(0) +" from " + tableName);
        while (rs.next()) {
            A f = newObject(rs);
            list.add(f);
        }
        closeStatemnet();
        return list;
    }

    /**
     *
     * @param obj
     * @throws SQLException
     */
    @Override
    public void insert(A obj) throws SQLException {
        newStatement();
        String query = "INSERT INTO " + tableName
                + " (" + queryBuilderAttrs(indexNotKey)  + ")"
                + " VALUES "
                + " (" + queryBuilderValues(obj, indexNotKey) + ")" ;
        executeSQL(query);
        closeStatemnet();
    }

    /**
     *
     * @param obj
     * @throws SQLException
     */
    @Override
    public void remove(A obj) throws SQLException {
        newStatement();
        executeSQL("DELETE FROM " + tableName + " WHERE " + 
                queryBuilderAttrsValues(obj, 0, indexNotKey)
        );
        closeStatemnet();
    }

    /**
     *
     * @param obj
     * @throws SQLException
     */
    @Override
    public void update(A obj) throws SQLException {
        newStatement();
        executeSQL("UPDATE " + tableName +" SET "
                + queryBuilderAttrsValues(obj, indexNotKey, -1) 
                + " WHERE  " +
                queryBuilderAttrsValues(obj, 0, indexNotKey)
        );
        closeStatemnet();
    }
    
    protected String queryBuilderAttrs(int fromIndex){
        String res ="";
        int i;
        for (i = fromIndex; i < attrs.length -1; i++) {
            res += attrs[i].name()+ ", ";
        }
        if(i < attrs.length){
            res += attrs[i].name();
        }
        
        return res;
    }
    
    protected String queryBuilderAttrsValues(A source, int fromIndex, int until){
        String res ="";
        if (until == -1){
            until = attrs.length;
        }
        int i;
        for (i = fromIndex; i < until -1; i++) {
            res += attrs[i].name() + " = " + getToBD(source, attrs[i]) + ", ";
        }
        if(i < until){
            res += attrs[i].name() + " = " + getToBD(source, attrs[i]);
        }
        
        return res;
    }

    private String queryBuilderValues(A source,int fromIndex) {
        String res ="";
        int i;
        for (i = fromIndex; i < attrs.length -1; i++) {
            res += getToBD(source, attrs[i]) + ", ";
        }
        if(i < attrs.length){
            res += getToBD(source, attrs[i]);
        }
        
        return res;

    }
}