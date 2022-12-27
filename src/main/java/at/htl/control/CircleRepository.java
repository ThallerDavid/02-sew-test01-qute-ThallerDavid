package at.htl.control;

import at.htl.entity.Circle;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.Id;

public class CircleRepository implements PanacheRepositoryBase<Circle, Id> {
}
