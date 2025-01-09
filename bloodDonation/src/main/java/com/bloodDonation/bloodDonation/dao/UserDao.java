package com.bloodDonation.bloodDonation.dao;

import com.bloodDonation.bloodDonation.entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao extends CrudRepository<User, String> {

}
