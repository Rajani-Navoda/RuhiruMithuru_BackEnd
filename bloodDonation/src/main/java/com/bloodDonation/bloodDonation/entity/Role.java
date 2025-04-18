package com.bloodDonation.bloodDonation.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Getter
@Setter
public class Role {
    @Id
    @Column(unique = true)
    private String roleName;
    private String roleDescription;

}
