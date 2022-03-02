package com.example.slau;

import java.sql.*;

public class DatabaseHandler extends Configs {
    ResultSet result;
    Connection dbConnection;
    float[] Array_seidel;
    float[] Array_iter;

    public Connection getDbConnection() throws ClassNotFoundException, SQLException{
        String connectionString = "jdbc:mysql://" + dbHost + ":"
                + dbPort + "/" + dbName;

        Class.forName("com.mysql.cj.jdbc.Driver");

        dbConnection = DriverManager.getConnection(connectionString, dbUser, dbPass);
        return dbConnection;
    }

    public void iterResult(Double x1, Double x2, Double x3) {
        String insert = "INSERT INTO " + Const.RESULT_ITER + "(" + Const.X1 + "," + Const.X2 +  "," + Const.X3 + ")"
                + "VALUES(?,?,?)";
        try {
            PreparedStatement peSt = getDbConnection().prepareStatement(insert);
            peSt.setDouble(1, x1);
            peSt.setDouble(2, x2);
            peSt.setDouble(3, x3);
            peSt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void seidelResult(Double x1, Double x2, Double x3) {
        String insert = "INSERT INTO " + Const.RESULT_SEIDEL + "(" + Const.X1 + "," + Const.X2 +  "," + Const.X3 + ")"
                + "VALUES(?,?,?)";
        try {
            PreparedStatement peSt = getDbConnection().prepareStatement(insert);
            peSt.setDouble(1, x1);
            peSt.setDouble(2, x2);
            peSt.setDouble(3, x3);
            peSt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

    public float[] getDataSeidel() {

        String select = "SELECT x1, x2, x3 FROM " + Const.RESULT_SEIDEL + " WHERE (SELECT MAX(id) FROM " + Const.RESULT_SEIDEL + ") = id";

        try {
            Statement statement = getDbConnection().createStatement();
            result = statement.executeQuery(select);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            result.next();
            System.out.println(result.getString(1));
            System.out.println(result.getString(2));
            System.out.println(result.getString(3));
            float seidel_x1 = Float.parseFloat(result.getString(1));
            float seidel_x2 = Float.parseFloat(result.getString(2));
            float seidel_x3 = Float.parseFloat(result.getString(3));
            Array_seidel = new float[]{seidel_x1, seidel_x2, seidel_x3};
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Array_seidel;
    }

    public float[] getDataIter() {

        String select = "SELECT x1, x2, x3 FROM " + Const.RESULT_ITER + " WHERE (SELECT MAX(id) FROM " + Const.RESULT_ITER + ") = id";

        try {
            Statement statement = getDbConnection().createStatement();
            result = statement.executeQuery(select);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            result.next();
            System.out.println(result.getString(1));
            System.out.println(result.getString(2));
            System.out.println(result.getString(3));
            float iter_x1 = Float.parseFloat(result.getString(1));
            float iter_x2 = Float.parseFloat(result.getString(2));
            float iter_x3 = Float.parseFloat(result.getString(3));
            Array_iter = new float[]{iter_x1, iter_x2, iter_x3};
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Array_iter;
    }

}
