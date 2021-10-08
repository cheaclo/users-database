package com.cheaclo.userdatabase.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class UserSearchPhrase {
    @Id
    @SequenceGenerator(
            name = "last_five_searched_seq",
            sequenceName = "last_five_searched_seq",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "last_five_searched_seq"
    )
    private Long id;
    private Date searchDate;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    private String searchedPhrase;
}
