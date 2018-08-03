package alumnimanager.Controllers;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import javafx.fxml.FXML;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javax.xml.crypto.Data;
import alumnimanager.databaseAssisstant.Connect;


public class ALUM_SIGNUP_FORMController implements Initializable {

    
        @FXML
        private JFXTextField alumName;
        @FXML
        private JFXTextField gender;
        @FXML
        private JFXTextField birthdate;
        @FXML
        private JFXTextField gradYear;
        @FXML
        private JFXTextField country;
        @FXML
        private JFXTextField occupation;
        @FXML
        private JFXTextField email;
        @FXML
        private JFXButton saveButton;
        @FXML
        private JFXButton canceLButton;      
        
        
        Connect connect;
                
                
   
    @Override
    public void initialize(URL url, ResourceBundle rb){
       connect = new Connect();
    }
                
    @FXML            
    //
    public void saveProfile(ActionEvent event) {
        
        String name = alumName.getText();
        String userGender = gender.getText();
        String userBirthdate = birthdate.getText();
        String userGradYear = gradYear.getText();
        String userCountry = country.getText();
        String userOccupation = occupation.getText();
        String userEmail = email.getText();
        
        if(name.isEmpty()||userGender.isEmpty()||userGender.isEmpty()||userBirthdate.isEmpty()
                ||userGradYear.isEmpty()||userCountry.isEmpty()||userOccupation.isEmpty()||userEmail.isEmpty()){
                   Alert alert = new Alert(Alert.AlertType.ERROR);
                   alert.setHeaderText(null);
                   alert.setContentText("Please Enter in all fields");
                   alert.showAndWait();
                   return;
        }
       
        String qu = "INSERT INTO PROFILE (" +
                    "'" + name + "'," + 
                    "'" + userGender + "'," + 
                    "'" + userBirthdate + "'," + 
                    "'" + userGradYear + "'," + 
                    "'" + userCountry + "'," + 
                    "'" + userOccupation + "'," + 
                    "'" + userEmail + "'" + 
       ")";
        System.out.println("qu");
        if(connect.execAction(qu))
        {// if the run id successful
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
                   alert.setHeaderText(null);
                   alert.setContentText("Success");
                   alert.showAndWait();
        }
        else{//In the event of an error
            Alert alert = new Alert(Alert.AlertType.ERROR);
                   alert.setHeaderText(null);
                   alert.setContentText("Failed");
                  alert.showAndWait();
    
            }
          
    }    
    
    
   @FXML
    public void cancelProfile(ActionEvent event) {
 
    }
    
}
