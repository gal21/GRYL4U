package View;

import java.time.LocalDate;

public class ReadUserController extends UserController {
    @Override
    public void show(){
        show();
        userPassword.setDisable(true);
        userFirstName.setDisable(true);
        userLastName.setDisable(true);
        userCity.setDisable(true);
        userBirthDate.setDisable(true);
    }
}