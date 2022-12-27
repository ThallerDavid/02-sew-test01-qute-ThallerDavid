package at.htl.control;

import at.htl.entity.Node;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;

import javax.enterprise.context.ApplicationScoped;

public class NodeRepository implements PanacheRepositoryBase<Node, Long> {


}
