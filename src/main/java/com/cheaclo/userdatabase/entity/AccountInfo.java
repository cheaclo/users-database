package com.cheaclo.userdatabase.entity;

import lombok.*;
import model.Gender;

import javax.persistence.*;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class AccountInfo {
    @Id
    @SequenceGenerator(
            name = "account_info_seq",
            sequenceName = "account_info_seq",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "account_info_seq"
    )
    @Column(name = "account_info_id")
    private Long id;
    private String firstname;
    private String lastname;
    private String email;
    private String password;
    private Date birthdayDate;
    private Gender gender;
    private String phoneNumber;

    @OneToOne
    @JoinColumn(name = "address_id")
    private Address address;
}