/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JFrameDuAn;
import java.sql.*;
import javax.swing.*;
/**
 *
 * @author DELL
 */
public class connect    {
    public static Connection getConnect(){
        try{
        Connection  conn = DriverManager.getConnection("jdbc:mysql://localhost:51258/DuAn","sa","1234");
        return conn;
        }   
        catch(Exception e){
            JOptionPane.showInputDialog(null, " kết nối thất bại");
            return null;
        }
    }
    
}
