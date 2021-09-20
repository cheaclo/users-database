
package com.cheaclo.userdatabase.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Address {
    @Id
    @SequenceGenerator(
            name = "address_seq",
            sequenceName = "address_seq",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "address_seq"
    )
    @Column(name = "address_id")
    private Long id;
    private String street;
    private int streetNumber;
    private String city;
    private int postalCode;
    private String country;
}