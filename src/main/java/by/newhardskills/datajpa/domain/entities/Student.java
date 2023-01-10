package by.newhardskills.datajpa.domain.entities;

import by.newhardskills.datajpa.domain.base.Named;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "student")
public class Student extends Named {

    @Column(name = "average", columnDefinition = "double precision")
    private double average;

}
