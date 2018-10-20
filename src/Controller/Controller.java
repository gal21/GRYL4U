package Controller;

import Model.User;
import Model.Model;

public class Controller {
    Model model;

    public Controller(Model _model) {
        model = _model;
    }

    public void updateUser(User updatedUser) {
        model.updateUser(updatedUser);

    }

    public User searchUserData(String userName) {
        return model.searchUserData(userName);
    }

    public void insertUser(User newUser){
        model.insertUser(newUser);
    }
}
