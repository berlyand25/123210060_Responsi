/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package responsi;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Lab Informatika
 */
public class ControllerMovie {
    ModelMovie mm;
    
    public void setMM(ModelMovie mm) {
        this.mm = mm;
    }
    
    public DefaultTableModel getTable() {
        DefaultTableModel tableModel = mm.getTable(); 
        return tableModel;
    }
    
    public void submitTambah(ViewMovie vm) {
        String judul = vm.getJudul().getText();
        String alur = vm.getAlur().getText();
        String penokohan = vm.getPenokohan().getText();
        String akting = vm.getAkting().getText();
        
        if (judul.equals("") || alur.equals("") || penokohan.equals("") || akting.equals("")) {
            // Handling jika inputan kosong
            JOptionPane.showMessageDialog(null, "Inputan kosong!", "", JOptionPane.ERROR_MESSAGE);
        } else {
            // Handling jika inputan tidak valid
            try {
                double alurVal = Double.parseDouble(alur);
                double penokohanVal = Double.parseDouble(penokohan);
                double aktingVal = Double.parseDouble(akting);
                
                if (alurVal < 0 || alurVal > 5 || penokohanVal < 0 || penokohanVal > 5 || aktingVal < 0 || aktingVal > 5) {
                    JOptionPane.showMessageDialog(null, "Inputan tidak valid!", "", JOptionPane.ERROR_MESSAGE);
                } else {
                    mm.submitTambah(vm);
                }
            } catch (RuntimeException ex) {
                JOptionPane.showMessageDialog(null, "Inputan tidak valid!", "", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
    
    public void submitUpdate(ViewMovie vm) {
        String judul = vm.getJudul().getText();
        String alur = vm.getAlur().getText();
        String penokohan = vm.getPenokohan().getText();
        String akting = vm.getAkting().getText();
        
        if (judul.equals("") || alur.equals("") || penokohan.equals("") || akting.equals("")) {
            // Handling jika inputan kosong
            JOptionPane.showMessageDialog(null, "Inputan kosong!", "", JOptionPane.ERROR_MESSAGE);
        } else {
            // Handling jika inputan tidak valid
            try {
                double alurVal = Double.parseDouble(alur);
                double penokohanVal = Double.parseDouble(penokohan);
                double aktingVal = Double.parseDouble(akting);
                
                if (alurVal < 0 || alurVal > 5 || penokohanVal < 0 || penokohanVal > 5 || aktingVal < 0 || aktingVal > 5) {
                    JOptionPane.showMessageDialog(null, "Inputan tidak valid!", "", JOptionPane.ERROR_MESSAGE);
                } else {
                    mm.submitUpdate(vm);
                }
            } catch (RuntimeException ex) {
                JOptionPane.showMessageDialog(null, "Inputan tidak valid!", "", JOptionPane.ERROR_MESSAGE);
            } 
        }
    }
    
    public void submitDelete(ViewMovie vm) {
        String judul = vm.getJudul().getText();
        String alur = vm.getAlur().getText();
        String penokohan = vm.getPenokohan().getText();
        String akting = vm.getAkting().getText();
        
        if (judul.equals("") || alur.equals("") || penokohan.equals("") || akting.equals("")) {
            // Handling jika inputan kosong
            JOptionPane.showMessageDialog(null, "Inputan kosong!", "", JOptionPane.ERROR_MESSAGE);
        } else {
            // Handling jika inputan tidak valid
            try {
                double alurVal = Double.parseDouble(alur);
                double penokohanVal = Double.parseDouble(penokohan);
                double aktingVal = Double.parseDouble(akting);
                
                if (alurVal < 0 || alurVal > 5 || penokohanVal < 0 || penokohanVal > 5 || aktingVal < 0 || aktingVal > 5) {
                    JOptionPane.showMessageDialog(null, "Inputan tidak valid!", "", JOptionPane.ERROR_MESSAGE);
                } else {
                    mm.submitDelete(vm);
                }
            } catch (RuntimeException ex) {
                JOptionPane.showMessageDialog(null, "Inputan tidak valid!", "", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}