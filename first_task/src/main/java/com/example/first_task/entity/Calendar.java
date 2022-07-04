package com.example.first_task.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "calendar")
public class Calendar {

    public enum Status {
        NEW,
        INPRO,
        DONE,
        DELETED
    }

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    private Date fromDate;
    private Date toDate;


    @ManyToOne
    @JoinColumn(foreignKey = @ForeignKey(name = "patientId"))
    private Patient patient;

    @ManyToOne
    @JoinColumn(foreignKey = @ForeignKey(name = "creatorUserId"))
    private User creatorUser;

    @ManyToOne
    @JoinColumn(foreignKey = @ForeignKey(name = "servicePointId"))
    private ServicePoint servicePoint;

    private Status status;
}
