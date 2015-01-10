/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistence.util;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public abstract class GenericDAO<A> extends DAO<A> {

    protected Enum<?>[] attrs;
    protected int indexNotKey;
    protected String tableName;
    protected String tableNameSelect;

    public GenericDAO(Enum<?>[] attrs, int indexNotKey, String tableName) {
        this(attrs, indexNotKey, tableName, tableName);
    }

    public GenericDAO(Enum<?>[] attrs, int indexNotKey, String tableName, String tableNameSelect) {
        this.attrs = attrs;
        this.indexNotKey = indexNotKey;
        this.tableName = tableName;
        this.tableNameSelect = tableNameSelect;
    }

    protected abstract String getToBD(A p, Enum<?> a);

    public abstract A newObject(ResultSet rs) throws SQLException;

    @Override
    public A getById(int id) throws SQLException {
        ArrayList<A> f = getByIdAll(id);
        if (f.size() > 0) {
            return f.get(0);
        }
        return null;
    }

    public ArrayList<A> getByIdAll(int id) throws SQLException {
        newStatement();

        ResultSet rs = executeSelect("Select * " //+ queryBuilderAttrs(0)
                + " from " + tableNameSelect + ""
                + " where " + attrs[0].name() + " = " + id
        );
        ArrayList<A> list = new ArrayList<>();
        while (rs.next()) {
            A f = newObject(rs);
            list.add(f);
        }

        closeStatemnet();
        return list;
    }

    public ArrayList<A> getAllBy(A a, Enum<?>... attrs) throws SQLException {
        newStatement();

        String query = "Select * " //+ queryBuilderAttrs(0)
                + " from " + tableNameSelect;
        if (a != null) {
            query += " where ";
            for (Enum<?> attr : attrs) {
                query += attr.name() + " = " + getToBD(a, attr) + " and ";
            }
            query = query.substring(0, query.length() - 5);
        }

        ResultSet rs = executeSelect(query);
        ArrayList<A> list = new ArrayList<>();
        while (rs.next()) {
            A f = newObject(rs);
            list.add(f);
        }

        closeStatemnet();
        beforeReturn(list);
        return list;
    }

    public void beforeReturn(List<A> a) throws SQLException {
    }

    /**
     *
     * @return @throws SQLException
     */
    @Override
    public ArrayList<A> getAll() throws SQLException {
        return getAllBy(null);
    }

    /**
     *
     * @param obj
     * @throws SQLException
     */
    @Override
    public int insert(A obj) throws SQLException {
        newStatement();
        String query = "INSERT INTO " + tableName
                + " (" + queryBuilderAttrs(indexNotKey) + ")"
                + " VALUES "
                + " (" + queryBuilderValues(obj, indexNotKey) + ")";
        int ret = executeSQLWithId(query);
        closeStatemnet();
        return ret;
    }
    
    public void insertNoAuto(A obj) throws SQLException {
        newStatement();
        String query = "INSERT INTO " + tableName
                + " (" + queryBuilderAttrs(0) + ")"
                + " VALUES "
                + " (" + queryBuilderValues(obj, 0) + ")";
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
        executeSQL("DELETE FROM " + tableName + " WHERE "
                + queryBuilderAttrsValues(obj, 0, indexNotKey)
        );
        closeStatemnet();
    }

    /**
     *
     * @param obj
     * @throws SQLException
     */
    @Override
    public int update(A obj) throws SQLException {
        newStatement();
        int ret = statement.executeUpdate("UPDATE " + tableName + " SET "
                + queryBuilderAttrsValues(obj, indexNotKey, -1)
                + " WHERE  "
                + queryBuilderAttrsValuesAnd(obj, 0, indexNotKey)
        );
        closeStatemnet();
        return ret;
    }

    protected String queryBuilderAttrs(int fromIndex) {
        String res = "";
        int i;
        for (i = fromIndex; i < attrs.length - 1; i++) {
            res += attrs[i].name() + ", ";
        }
        if (i < attrs.length) {
            res += attrs[i].name();
        }

        return res;
    }

    protected String queryBuilderAttrsValues(A source, int fromIndex, int until) {
        String res = "";
        if (until == -1) {
            until = attrs.length;
        }
        int i;
        for (i = fromIndex; i < until - 1; i++) {
            res += attrs[i].name() + " = " + getToBD(source, attrs[i]) + ", ";
        }
        if (i < until) {
            res += attrs[i].name() + " = " + getToBD(source, attrs[i]);
        }

        return res;
    }
    
    protected String queryBuilderAttrsValuesAnd(A source, int fromIndex, int until){
                String res = "";
        if (until == -1) {
            until = attrs.length;
        }
        int i;
        for (i = fromIndex; i < until - 1; i++) {
            res += attrs[i].name() + " = " + getToBD(source, attrs[i]) + " and ";
        }
        if (i < until) {
            res += attrs[i].name() + " = " + getToBD(source, attrs[i]);
        }

        return res;
    }
    

    private String queryBuilderValues(A source, int fromIndex) {
        String res = "";
        int i;
        for (i = fromIndex; i < attrs.length - 1; i++) {
            res += getToBD(source, attrs[i]) + ", ";
        }
        if (i < attrs.length) {
            res += getToBD(source, attrs[i]);
        }

        return res;

    }
}
