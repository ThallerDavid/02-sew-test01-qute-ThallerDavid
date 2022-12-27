package at.htl.control;

import at.htl.entity.LineConfig;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.Id;

@ApplicationScoped
public class LineConfigRepository implements PanacheRepositoryBase<LineConfig, Id> {

}
