/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package responsi;

import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Lab Informatika
 */
public class ModelMovie {
    private DefaultTableModel tableModel;
    Object[] column = {"Judul","Alur","Penokohan","Akting","Nilai"};
    
    private String DBurl = "jdbc:mysql://localhost/movie_db";
    private String DBusername = "root";
    private String DBpassword = "";
    Connection koneksi;
    Statement statement;
    
    public ModelMovie() {
        tableModel = new DefaultTableModel();
        
        for (Object columnName : column) {
            tableModel.addColumn(columnName);
        }
    }
    
    public void resetTableModel() {
        int row = tableModel.getRowCount();
        
        for (int i = row-1 ; i >= 0 ; --i) {
            tableModel.removeRow(i);
        }
    }
    
    public DefaultTableModel getTable() {
        resetTableModel();
        populateTableModel();
        return tableModel;
    }
    
    public void populateTableModel() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            koneksi = DriverManager.getConnection(DBurl, DBusername, DBpassword);
            statement = koneksi.createStatement();
        
            String sql = "SELECT * FROM movie";
            
            ResultSet resultSet = statement.executeQuery(sql);
            ResultSetMetaData metaData = resultSet.getMetaData();
            
            int columnCount = metaData.getColumnCount();
            
            while (resultSet.next()) {
                Object[] rowData = new Object[columnCount];
                
                for (int i = 1 ; i <= columnCount ; ++i) {
                    rowData[i-1] = resultSet.getObject(i);
                }
                
                tableModel.addRow(rowData);
            }
            
            statement.close();
            koneksi.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex, "", JOptionPane.ERROR_MESSAGE);
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Data gagal ditambahkan!", "", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void submitTambah(ViewMovie vm) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            koneksi = DriverManager.getConnection(DBurl, DBusername, DBpassword);
            statement = koneksi.createStatement();
            
            String judul = vm.getJudul().getText();
            String alur = vm.getAlur().getText();
            String penokohan = vm.getPenokohan().getText();
            String akting = vm.getAkting().getText();
            
            double alurVal = Double.parseDouble(alur);
            double penokohanVal = Double.parseDouble(penokohan);
            double aktingVal = Double.parseDouble(akting);
            double nilaiVal = (alurVal+penokohanVal+aktingVal)/3;
        
            String sql = "INSERT INTO movie (judul,alur,penokohan,akting,nilai)"
                    + " VALUES("
                    + "'" + judul + "',"
                    + alurVal + ","
                    + penokohanVal + ","
                    + aktingVal + ","
                    + nilaiVal + ")";
            
            statement.executeUpdate(sql);
            JOptionPane.showMessageDialog(null, "Data berhasil ditambahkan!", "", JOptionPane.INFORMATION_MESSAGE);
            
            statement.close();
            koneksi.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Data gagal ditambahkan!", "", JOptionPane.ERROR_MESSAGE);
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Data gagal ditambahkan!", "", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void submitUpdate(ViewMovie vm) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            koneksi = DriverManager.getConnection(DBurl, DBusername, DBpassword);
            statement = koneksi.createStatement();
            
            String judul = vm.getJudul().getText();
            String alur = vm.getAlur().getText();
            String penokohan = vm.getPenokohan().getText();
            String akting = vm.getAkting().getText();
            
            double alurVal = Double.parseDouble(alur);
            double penokohanVal = Double.parseDouble(penokohan);
            double aktingVal = Double.parseDouble(akting);
            double nilaiVal = (alurVal+penokohanVal+aktingVal)/3;
        
            String sql = "UPDATE movie SET "
                    + "alur=" + alurVal + ", "
                    + "penokohan=" + penokohanVal + ", "
                    + "akting=" + aktingVal + ", "
                    + "nilai=" + nilaiVal + " WHERE judul='" + judul + "'";
            
            statement.executeUpdate(sql);
            JOptionPane.showMessageDialog(null, "Data berhasil diubah!", "", JOptionPane.INFORMATION_MESSAGE);
            
            statement.close();
            koneksi.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Data gagal diubah!", "", JOptionPane.ERROR_MESSAGE);
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Data gagal diubah!", "", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void submitDelete(ViewMovie vm) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            koneksi = DriverManager.getConnection(DBurl, DBusername, DBpassword);
            statement = koneksi.createStatement();
            
            String judul = vm.getJudul().getText();
            String alur = vm.getAlur().getText();
            String penokohan = vm.getPenokohan().getText();
            String akting = vm.getAkting().getText();
            
            double alurVal = Double.parseDouble(alur);
            double penokohanVal = Double.parseDouble(penokohan);
            double aktingVal = Double.parseDouble(akting);
            double nilaiVal = (alurVal+penokohanVal+aktingVal)/3;
        
            String sql = "DELETE FROM movie WHERE judul='" + judul + "'";
            
            statement.executeUpdate(sql);
            JOptionPane.showMessageDialog(null, "Data berhasil dihapus!", "", JOptionPane.INFORMATION_MESSAGE);
            
            statement.close();
            koneksi.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Data gagal dihapus!", "", JOptionPane.ERROR_MESSAGE);
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Data gagal dihapus!", "", JOptionPane.ERROR_MESSAGE);
        }
    }
}