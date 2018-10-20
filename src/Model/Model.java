package Model;

public class Model {

    private sql_create sql_db;

    public Model() {
        sql_db = new sql_create();
    }

    public void insertUser(User newUser) {
        sql_db.insert(newUser.getUser_name(), newUser.getPassword(), newUser.getFirst_name(),
                newUser.getLast_name(), newUser.getCity(), newUser.getDate());
    }

    public void updateUser(User updatedUser) {
        sql_db.update(updatedUser.getUser_name(), "password", updatedUser.getPassword());
        sql_db.update(updatedUser.getUser_name(), "first_name", updatedUser.getFirst_name());
        sql_db.update(updatedUser.getUser_name(), "last_name", updatedUser.getLast_name());
        sql_db.update(updatedUser.getUser_name(), "city", updatedUser.getCity());
        sql_db.update(updatedUser.getUser_name(), "date", updatedUser.getDate());
    }

    public User searchUserData(String userName) {
        return sql_db.find_User_Exists(userName);
    }

}
