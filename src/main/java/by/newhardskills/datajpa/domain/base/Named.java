package by.newhardskills.datajpa.domain.base;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class Named extends Identifiable {

    @Column(name = "name", columnDefinition = "varchar(255)")
    protected String name;

}
