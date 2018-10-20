package Controller;

import Model.User;
import Model.Model;
import View.View;

public class Controller {
    private Model model;
    private View view;

    public Controller(Model _model, View _view) {
        model = _model;
        view = _view;
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
