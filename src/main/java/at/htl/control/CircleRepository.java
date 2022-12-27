package at.htl.control;

import at.htl.entity.Circle;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.Id;

@ApplicationScoped
public class CircleRepository implements PanacheRepositoryBase<Circle, Id> {
    public Circle findByName(String name) {
        return find("#Circle.getByName", name).firstResult();
    }
}
