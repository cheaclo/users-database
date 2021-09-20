package com.cheaclo.userdatabase.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class SavedProduct {
    @Id
    @SequenceGenerator(
            name = "saved_product_seq",
            sequenceName = "saved_product_seq",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "saved_product_seq"
    )
    private Long id;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    private int product;
}
