package observable;

import database.Database;
import model.User;

import java.util.ArrayList;

public class Promo {
    public static void addUser(User user)
    {
        Database.getInstance().addUser(user);
    }

    public static void notifyUsers(String message)
    {
        ArrayList<User> users = Database.getInstance().getUsers();

        for (User user :
                users) {
            user.update(message);
        }
    }
}
