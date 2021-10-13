package com.cheaclo.userdatabase.entity;

import lombok.*;
import com.cheaclo.userdatabase.model.Gender;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
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
    @NotNull
    @Column(name = "account_info_id")
    private Long id;

    @NotNull
    @Size(min=2, max=30)
    private String firstname;

    @NotNull
    @Size(min=2, max=30)
    private String lastname;

    @NotNull
    @Email
    private String email;

    @NotNull
    @Size(min=5, max=30)
    private String password;

    private Date birthdayDate;

    private Gender gender;

    @Pattern(regexp = "^$|^\\d{9}$")
    private String phone;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id")
    private Address address;
}