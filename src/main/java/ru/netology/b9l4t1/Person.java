package ru.netology.b9l4t1;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "persons")
public class Person {
    @Column(columnDefinition = "bigint not null unique key auto_increment")
    private long id;
    @EmbeddedId
    private Human human;
    @Column
    private String phoneNumber;
    @Column
    private String city;

    public static PersonBuilder builder() {
        return new PersonBuilder();
    }

    public static class PersonBuilder {
        private long id;
        private Human human;
        private String phoneNumber;
        private String city;

        PersonBuilder() {
        }

        public PersonBuilder id(long id) {
            this.id = id;
            return this;
        }

        public PersonBuilder human(Human human) {
            this.human = human;
            return this;
        }

        public PersonBuilder phoneNumber(String phoneNumber) {
            this.phoneNumber = phoneNumber;
            return this;
        }

        public PersonBuilder city(String city) {
            this.city = city;
            return this;
        }

        public Person build() {
            return new Person(id, human, phoneNumber, city);
        }

        public String toString() {
            return "Person.PersonBuilder(id=" + this.id + ", human=" + this.human + ", phoneNumber=" + this.phoneNumber + ", city=" + this.city + ")";
        }
    }
}
