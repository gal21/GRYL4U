package View;

public class CreateUserController {
    public javafx.scene.control.TextField userName;
    public javafx.scene.control.TextField userPassword;
    public javafx.scene.control.TextField userFirstName;
    public javafx.scene.control.TextField userLastName;
    public javafx.scene.control.TextField userCity;
    public javafx.scene.control.DatePicker userBirthDate;
    public javafx.scene.control.Button apply;

    private void apply(){
        String _password = userPassword.getText();
        String _firstName = userFirstName.getText();
        String _lastName = userLastName.getText();
        String _userCity = userCity.getText();
        String _userBorthDate = userBirthDate.getDayCellFactory().toString();
    }

}
