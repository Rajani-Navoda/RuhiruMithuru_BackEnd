package com.bloodDonation.bloodDonation.service;

import com.bloodDonation.bloodDonation.dao.RoleDao;
import com.bloodDonation.bloodDonation.dao.UserDao;
import com.bloodDonation.bloodDonation.entity.Role;
import com.bloodDonation.bloodDonation.entity.User;
import com.bloodDonation.bloodDonation.util.UserType;
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

//
        Role role = roleDao.findById("User").get();
//        Set<Role> roles = new HashSet<>();
//        roles.add(role);
//        user.setRole(roles);
//        user.setUserPassword(getEncodedPassword(user.getUserPassword()));
//       return userDao.save(user);

        Role userRole = roleDao.findById(user.getUserType().toString()).get();
        Set<Role> roles = new HashSet<>();
        roles.add(userRole);
        user.setRole(roles);
        user.setUserPassword(getEncodedPassword(user.getUserPassword()));
        return userDao.save(user);
    }

    public void initRolesAndUser() {
        Role adminRole = new Role();
        adminRole.setRoleName("ADMIN");
        adminRole.setRoleDescription("Administrator role");
        roleDao.save(adminRole);

        // Initialize Blood Bank Role
        Role bloodBankRole = new Role();
        bloodBankRole.setRoleName("BLOOD_BANK");
        bloodBankRole.setRoleDescription("Blood Bank role");
        roleDao.save(bloodBankRole);

        // Initialize Organizer Role
        Role organizerRole = new Role();
        organizerRole.setRoleName("ORGANIZER");
        organizerRole.setRoleDescription("Event Organizer role");
        roleDao.save(organizerRole);

        // Initialize User Role
        Role userRole = new Role();
        userRole.setRoleName("USER");
        userRole.setRoleDescription("Default user role");
        roleDao.save(userRole);

        // Create default admin user
        User adminUser = new User();
        adminUser.setUserFirstName("Admin");
        adminUser.setUserLastName("Admin");
        adminUser.setUserName("admin123");

        adminUser.setUserPassword(getEncodedPassword("admin@123"));
        adminUser.setUserType(UserType.ADMIN);
        Set<Role> adminRoles = new HashSet<>();
        adminRoles.add(adminRole);
        adminUser.setRole(adminRoles);
        userDao.save(adminUser);
    }

    public String getEncodedPassword(String password){
        return passwordEncoder.encode(password);
    }

}
