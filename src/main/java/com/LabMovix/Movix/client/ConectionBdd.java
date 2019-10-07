/*package com.LabMovix.Movix.client;

import java.net.URL;
import java.sql.*;
import javax.swing.JOptionPane;

public class ConectionBdd {

    Connection conexion = null;
    URL url ="url de la base";

    public void conectar(){
        try{
            Class.forName("servidor sql jdbc");
        }
        catch(Exception ex){
                JOptionPane.showMessageDialog(null,"error al conectar"+datos);
        }
    }

    public String Select(){
        String texto="";
        try{
            Statement ejecutor = conexion.createStatement();
            ResultSet respuesta = ejecutor.executeQuery("Select:");

            while(respuesta.next()){
                texto = texto + respuesta.getString("Nombre")+respuesta.getString("algo")
            }
            catch (Exception e) {
            }
            return texto;
        }
    }
}
*/

