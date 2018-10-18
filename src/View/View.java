package View;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class View {
    public javafx.scene.control.Button createUser;
    public javafx.scene.control.Button readUser;
    public javafx.scene.control.Button updateUser;
    public javafx.scene.control.Button deleteUser;

    public void createUser()
    {
        Stage stage = new Stage();
        stage.setAlwaysOnTop(true);
        stage.setResizable(true);
        stage.setTitle("Create New User");
        try
        {
            Parent root = FXMLLoader.load(getClass().getResource("CreateUser.fxml"));
            Scene scene = new Scene(root, 700, 600);
            stage.setScene(scene);
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.show();
        }
        catch (Exception e) {
            e.getCause().printStackTrace();
        }
    }

    public void readUser()
    {
        Stage stage = new Stage();
        stage.setAlwaysOnTop(true);
        stage.setResizable(true);
        stage.setTitle("Read User");
        try
        {
            Parent root = FXMLLoader.load(getClass().getResource("ReadUser.fxml"));
            Scene scene = new Scene(root, 700, 600);
            stage.setScene(scene);
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.show();
        }
        catch (Exception e) {
            e.getCause().printStackTrace();
        }
    }

    public void updateUser()
    {
        Stage stage = new Stage();
        stage.setAlwaysOnTop(true);
        stage.setResizable(true);
        stage.setTitle("Update User");
        try
        {
            Parent root = FXMLLoader.load(getClass().getResource("UpdateUser.fxml"));
            Scene scene = new Scene(root, 700, 600);
            stage.setScene(scene);
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.show();
        }
        catch (Exception e) {
            e.getCause().printStackTrace();
        }
    }

    public void deleteUser()
    {
        Stage stage = new Stage();
        stage.setAlwaysOnTop(true);
        stage.setResizable(true);
        stage.setTitle("Delete User");
        try
        {
            Parent root = FXMLLoader.load(getClass().getResource("DeleteUser.fxml"));
            Scene scene = new Scene(root, 600, 600);
            stage.setScene(scene);
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.show();
        }
        catch (Exception e) {
            e.getCause().printStackTrace();
        }
    }

}
