package com.bloodDonation.bloodDonation.service;

import com.bloodDonation.bloodDonation.dao.RoleDao;
import com.bloodDonation.bloodDonation.entity.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleService {
    @Autowired
    private RoleDao roleDao;
    public Role createNewRole(Role role){
        return roleDao.save(role);
    }
}
