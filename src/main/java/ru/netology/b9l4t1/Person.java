package ru.netology.b9l4t1;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "persons")
public class Person {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @EmbeddedId
    private Human human;
    @Column
    private String phoneNumber;
    @Column
    private String city;
}
