package id.ac.upj.tif.pbo_uas;

import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;

public class Koneksi {
    private Connection conn;
    private Statement st;

    public Koneksi() {
        try{
            String user = "root";
            String password = "";
            String urldb = "jdbc:mysql://localhost:3306/database_tumbuhan";
            conn = DriverManager.getConnection(urldb, user, password);
            System.out.println("Koneksi Berhasil");
        } catch (SQLException e){
            System.out.println("Koneksi Gagal :" + e);
        } catch (Exception e) {
            System.out.println("Terjadi Error yang tidak diketahui");
        }
    }

    public ResultSet bacaData(String query) throws SQLException {
        st = conn.createStatement();
        return st.executeQuery(query);
    }

    public int manipulasiData(String query) {

        try {

            st = conn.createStatement();

            return st.executeUpdate(query);

        } catch (SQLException e) {

            System.out.println("SQL Error: " + e);

            return 0;

        } catch (Exception e) {

            System.out.println("Terjadi Error yang tidak diketahui");

            return 0;

        }

    }



    public void tutup(){

        try {

            conn.close();

            st.close();

        } catch (SQLException e) {

            System.out.println("SQL Error: " + e);

        } catch (Exception e) {

            System.out.println("Terjadi Error yang tidak diketahui");

        }

    }

}