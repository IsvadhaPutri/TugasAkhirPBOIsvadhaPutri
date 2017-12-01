/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ta;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author HP
 */
public class ShoppingController implements Initializable {

    @FXML
    private Button buy;
    @FXML
    private TextField Lightstick;
    @FXML
    private TextField Clock;
    @FXML
    private TextField Jacket;
    @FXML
    private TextField PhoneCase;
    @FXML
    private TextField KeyChain;
    @FXML
    private TextField Album;
    
    
    String jmllightstick, jmlclock, jmljacket, jmlphonecase, jmlkeychain, jmlalbum;
   
    
    int jml1, jml2, jml3, jml4, jml5, jml6;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    void kirim(){
        jmllightstick = Lightstick.getText();
        jmlclock = Clock.getText();
        jmljacket = Jacket.getText();
        jmlphonecase = PhoneCase.getText();
        jmlkeychain = KeyChain.getText();
        jmlalbum = Album.getText();
        
        jml1 = Integer.parseInt(jmllightstick)*250000;
        jml2 = Integer.parseInt(jmlclock)*50000;
        jml3 = Integer.parseInt(jmljacket)*175000;
        jml4 = Integer.parseInt(jmlphonecase)*150000;
        jml5 = Integer.parseInt(jmlkeychain)*15000;
        jml6 = Integer.parseInt(jmlalbum)*200000;
        
    }
    
    
    @FXML
    private void btnbuy(ActionEvent event) throws IOException {
        kirim();
        try{
        ((Node) (event.getSource())).getScene().getWindow().hide();
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("nota.fxml"));
        Scene scene = new Scene (fxmlLoader.load());
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.setTitle("Nota");
        stage.show();
        
        
        NotaController Data = new NotaController();
        Data = fxmlLoader.getController();
        
        Data.setdata(jml1,jml2,jml3,jml4,jml5,jml6);
        } catch (IOException e){
            System.out.println("Batal membuat window baru" +e);
        }
                
        
    }
    
    
    
}
