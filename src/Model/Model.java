package Model;

public class Model {

    private DBManagement dbManagement;

    public Model() {
        dbManagement = new DBManagement();
    }

    public void insertUser(User newUser) {
        dbManagement.insert(newUser.getUser_name(), newUser.getPassword(), newUser.getFirst_name(),
                newUser.getLast_name(), newUser.getCity(), newUser.getDate());
    }

    public void updateUser(User updatedUser) {
        dbManagement.update(updatedUser.getUser_name(), "password", updatedUser.getPassword());
        dbManagement.update(updatedUser.getUser_name(), "first_name", updatedUser.getFirst_name());
        dbManagement.update(updatedUser.getUser_name(), "last_name", updatedUser.getLast_name());
        dbManagement.update(updatedUser.getUser_name(), "city", updatedUser.getCity());
        dbManagement.update(updatedUser.getUser_name(), "date", updatedUser.getDate());
    }

    public User searchUserData(String userName) {
        return dbManagement.find_User_Exists(userName);
    }

    public void deleteUser(String userToDelete) {
        dbManagement.delete(userToDelete);
    }
}
