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
        System.out.println("Update Success");
        //model.updateUser(updatedUser);
    }

    public User searchUserData(String userName) {
        System.out.println("SearchSuccess");
        return model.searchUserData(userName);
    }

    public void insertUser(User newUser){
        System.out.println("Insert Success");
        model.insertUser(newUser);
    }

    public void deleteUser() {
        model.deleteUser();
    }
}
