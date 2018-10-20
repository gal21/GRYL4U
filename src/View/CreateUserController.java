package View;
import Model.User;
import javafx.scene.control.Alert;

import java.time.LocalDate;

public class CreateUserController extends  UserController{
    public javafx.scene.control.TextField userName;
    public javafx.scene.control.TextField userPassword;
    public javafx.scene.control.TextField userFirstName;
    public javafx.scene.control.TextField userLastName;
    public javafx.scene.control.TextField userCity;
    public javafx.scene.control.DatePicker userBirthDate;
    public javafx.scene.control.Button apply;

    public User apply(){
        String _userName = userName.getText();
        String _password = userPassword.getText();
        String _firstName = userFirstName.getText();
        String _lastName = userLastName.getText();
        String _userCity = userCity.getText();
        LocalDate date = userBirthDate.getValue();
        User newUser = new User(_userName,_password,_firstName,_lastName,_userCity,date.toString());
        //controller.insertUser(newUser); for later
        newUser.printUser();
        return newUser;
    }

    public void invalidUserDataError(String errorMsg){
        Alert a = new Alert(Alert.AlertType.INFORMATION);
        a.setContentText(errorMsg);
        a.show();
    }

}
