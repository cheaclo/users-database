package com.cheaclo.userdatabase.entity;

import lombok.*;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Country {
    @Id
    @SequenceGenerator(
            name = "country_seq",
            sequenceName = "country_seq",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "country_seq"
    )
    @Column(name = "user_id")
    private Long id;
    private String name;
}
