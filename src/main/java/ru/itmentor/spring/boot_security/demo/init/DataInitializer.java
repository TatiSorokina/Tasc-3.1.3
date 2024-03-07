package ru.itmentor.spring.boot_security.demo.init;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import ru.itmentor.spring.boot_security.demo.dao.RoleDao;
import ru.itmentor.spring.boot_security.demo.dao.UserDao;
import ru.itmentor.spring.boot_security.demo.model.Role;
import ru.itmentor.spring.boot_security.demo.model.User;

import java.util.HashSet;
import java.util.Set;

@Component
public class DataInitializer implements CommandLineRunner {

    private final RoleDao roleDao;
    private final UserDao userDao;


    @Autowired
    public DataInitializer(RoleDao roleDao, UserDao userDao) {
        this.roleDao = roleDao;
        this.userDao = userDao;
    }

    @Override
    public void run(String... args) throws Exception {
        Role adminrole = new Role(1, "ROLE_ADMIN");
        Role userrole = new Role(2, "ROLE_USER");
        roleDao.save(adminrole);
        roleDao.save(userrole);

        Set<Role> admin_roles = new HashSet<>();
        admin_roles.add(adminrole);

        User admin = new User(1, "admin", "admin", "admin@gmail.com", 48, admin_roles);
        userDao.save(admin);

        Set<Role> user_roles = new HashSet<>();
        user_roles.add(userrole);

        User user = new User(2, "user", "user", "user@gmail.com", 22, user_roles);
        userDao.save(user);

    }
}
