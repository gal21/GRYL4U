package View;

import Model.User;

import java.time.LocalDate;

public class ShowUserController extends UserController {
    public static User currentUser ;

    public void show(){
        currentUser = searchUserData(userName.getText());
        userName.setDisable(true);
        userPassword.setText(currentUser.getPassword());
        userPassword.setDisable(false);
        userFirstName.setText(currentUser.getFirst_name());
        userFirstName.setDisable(false);
        userLastName.setText(currentUser.getLast_name());
        userLastName.setDisable(false);
        userCity.setText(currentUser.getCity());
        userCity.setDisable(false);
        userBirthDate.setValue(LocalDate.parse(currentUser.getDate()));
        userBirthDate.setDisable(false);
    }

}
