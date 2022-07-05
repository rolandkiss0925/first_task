package com.example.first_task.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import java.util.Date;
import java.util.Set;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "patient")
public class Patient {

    public enum SSNType {
        SSN(1),
        ID(2),
        PASSPORT(3),
        OTHER(4);

        private final int value;

        SSNType(final int newValue) {
            value = newValue;
        }

        public int getValue() { return value; }
    }

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    private String name;

    private Date birthDate;

    private String ssn;

    private SSNType ssnType;

    private String mothersName;

}
