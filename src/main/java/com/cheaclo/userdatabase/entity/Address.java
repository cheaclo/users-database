
package com.cheaclo.userdatabase.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.*;

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
    @NotNull
    @Column(name = "address_id")
    private Long id;

    @Size(min=2, max=50)
    @Pattern(regexp = "^\\w+[\\s*\\w*]*$")
    private String street;

    @Min(1)
    @Max(99999)
    private Integer streetNumber;

    @Size(min=2, max=50)
    @Pattern(regexp = "^\\w+[\\s*\\w*]*$")
    private String city;

    @Pattern(regexp = "^\\w{6}$")
    private String postalCode;

    @Size(min=2, max=50)
    private String country;
}