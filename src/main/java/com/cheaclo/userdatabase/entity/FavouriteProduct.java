package com.cheaclo.userdatabase.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class FavouriteProduct {
    @Id
    @SequenceGenerator(
            name = "favourite_product_seq",
            sequenceName = "favourite_product_seq",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "favourite_product_seq"
    )
    private Long id;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    private Long product;
}
