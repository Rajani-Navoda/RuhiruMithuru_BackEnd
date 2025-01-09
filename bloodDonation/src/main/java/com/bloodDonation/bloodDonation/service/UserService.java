package com.bloodDonation.bloodDonation.service;

import com.bloodDonation.bloodDonation.dao.RoleDao;
import com.bloodDonation.bloodDonation.dao.UserDao;
import com.bloodDonation.bloodDonation.entity.Role;
import com.bloodDonation.bloodDonation.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class UserService {
    @Autowired
    private UserDao userDao;

    @Autowired
    private RoleDao roleDao;

    @Autowired
    private PasswordEncoder passwordEncoder;


    public User registerNewUser(User user){

        Role role = roleDao.findById("User").get();
        Set<Role> roles = new HashSet<>();
        roles.add(role);
        user.setRole(roles);
        user.setUserPassword(getEncodedPassword(user.getUserPassword()));
       return userDao.save(user);

    }

    public void initRolesAndUser() {

        Role adminRole = new Role();
        adminRole.setRoleName("Admin");
        adminRole.setRoleDescription("Admin role for the application");
        roleDao.save(adminRole);

        Role userRole = new Role();
        userRole.setRoleName("User");
        userRole.setRoleDescription("User role for the application");
        roleDao.save(userRole);

        User adminUser = new User();
        adminUser.setUserFirstName("Admin");
        adminUser.setUserLastName("Admin");
        adminUser.setUserName("admin123");
        adminUser.setUserPassword(getEncodedPassword("admin@123"));
        Set<Role> adminRoles = new HashSet<>();
        adminRoles.add(adminRole);
        adminUser.setRole(adminRoles);
        userDao.save(adminUser);

//        User user = new User();
//        user.setUserFirstName("Normal");
//        user.setUserLastName("User");
//        user.setUserName("user123");
//        user.setUserPassword(getEncodedPassword("user@123"));
//        Set<Role> userRoles = new HashSet<>();
//        userRoles.add(userRole);
//        user.setRole(userRoles);
//        userDao.save(user);

    }

    public String getEncodedPassword(String password){
        return passwordEncoder.encode(password);
    }

}
