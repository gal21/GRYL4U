package View;

public class ReadUserController extends UserController {
    @Override
    public void show(){
        super.show();
        userPassword.setDisable(true);
        userFirstName.setDisable(true);
        userLastName.setDisable(true);
        userCity.setDisable(true);
        userBirthDate.setDisable(true);
    }
}