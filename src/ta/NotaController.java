/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ta;

import com.jfoenix.controls.JFXTextArea;
import static com.sun.javafx.animation.TickCalculation.sub;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author HP
 */
public class NotaController implements Initializable {

    @FXML
    private TextField total;
    @FXML
    private JFXTextArea barangyangdibeli;
    @FXML
    private Button proses;
    @FXML
    private TextField bayar;
    @FXML
    private TextField kembalian;


    String byr, totalll;
    int sisa;
   
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
            
        @FXML
    void tekanproses(ActionEvent event) {
        String byr = bayar.getText();
        totalll = total.getText();
        sisa = Integer.parseInt(byr) - Integer.parseInt(totalll);
        kembalian.setText(String.valueOf(sisa));
    }

    
    
    void setdata(int jml1, int jml2, int jml3, int jml4, int jml5, int jml6) {
       barangyangdibeli.setText(String.valueOf("Lightstick = "+jml1+"\n"
               + "Clock = "+jml2+"\n"
               + "Jacket = "+jml3+"\n"
               + "Phone Case = "+jml4+"\n"
               + "Key Chain = "+jml5+"\n"
               + "Album = "+jml6));
       
       
       total.setText(String.valueOf(jml1 + jml2 + jml3 + jml4 + jml5 + jml6));
    }
    
}
