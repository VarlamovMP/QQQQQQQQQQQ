package web.dao;

import org.springframework.stereotype.Component;
import web.models.User;

import java.util.ArrayList;
import java.util.List;


@Component
public class UserDao {

    private List<User> users;
    private static int USER_COUNT;

    {
        users = new ArrayList<>();
        users.add(new User(++USER_COUNT, "Aleksey", "Aleksey@mail.ru"));
        users.add(new User(++USER_COUNT, "Donald", "Trampampam@mail.ru"));
        users.add(new User(++USER_COUNT, "Tom", "Tom@mail.ru"));
        users.add(new User(++USER_COUNT, "Vova", "Putin@mail.ru"));
        users.add(new User(++USER_COUNT, "Dima", "Medved@mail.ru"));

    }

    public List<User> index() {
        return users;
    }

    public User show(int id) {
        return users.stream().filter(user -> user.getId() == id).findAny().orElse(null);
    }

    public void save(User user) {
        user.setId(++USER_COUNT);
        users.add(user);
    }

    public void update(int id, User updateUser) {
        User updateToUser = show(id);
        updateToUser.setName(updateUser.getName());
        updateToUser.setEmail(updateUser.getEmail());
    }

    public void delete(int id) {
        users.removeIf(p -> p.getId() == id);
    }


}
