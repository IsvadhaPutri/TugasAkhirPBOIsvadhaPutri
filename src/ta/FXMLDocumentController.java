/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ta;

import java.awt.Component;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author HP
 */
public class FXMLDocumentController implements Initializable {

    @FXML
    private TextField signnama;
    @FXML
    private TextField signusername;
    @FXML
    private PasswordField signpassword;
    @FXML
    private Button signup;
    @FXML
    private TextField logusername;
    @FXML
    private PasswordField logpassword;
    @FXML
    private Button login;

    /**
     * initialises the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
   
    
    @FXML
    private void btnsignup(ActionEvent event) {
        String nama =signnama.getText();
        String user = signusername.getText();
        String p = signpassword.getText();
        
        try{
            try(Statement statement = (Statement) login_koneksi.GetConnection().createStatement()){
                statement.executeUpdate("INSERT INTO tb_akun VALUES ('"+user+"', '"+p+"')");
            } 
            JOptionPane.showMessageDialog(null, "Sign Up Berhasil");
            signnama.setText("");
            signusername.setText("");
            signpassword.setText("");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "GAGAL! Silahkan Ulangi");
        }
    }

    private void dispose() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
   @FXML
    private void btnlogin(ActionEvent event) throws IOException {
    Connection connection;
        PreparedStatement ps;
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost/toko?s TimeBehavior=convertToNull", "root", "");
            ps = connection.prepareStatement("SELECT * FROM `tb_akun` WHERE `username` = ? AND `password` = ?");
            ps.setString(1, logusername.getText());
            ps.setString(2, logpassword.getText());
            ResultSet result = ps.executeQuery();
            if (result.next()) {
                ((Node)(event.getSource())).getScene().getWindow().hide();
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("shopping.fxml"));
                Scene scene = new Scene (fxmlLoader.load(),830,450);
                Stage stage = new Stage();
                stage.setScene (scene);
                stage.setTitle("MenuAwal");
                stage.show();    
            } else {
                Component rootPane = null;
                JOptionPane.showMessageDialog(rootPane, "Salah!");
                logpassword.setText("");
                logusername.setText("");
            }
        } catch (SQLException ex) {
        Component rootPane = null;
            JOptionPane.showMessageDialog(rootPane, "Gagal!");
        }
    }

    }

   
