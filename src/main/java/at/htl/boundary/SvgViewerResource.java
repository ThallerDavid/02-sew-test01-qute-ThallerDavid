package at.htl.boundary;

import at.htl.control.CircleRepository;
import at.htl.entity.Circle;
import at.htl.entity.LineConfig;
import io.quarkus.qute.CheckedTemplate;
import io.quarkus.qute.TemplateInstance;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("svg")
public class SvgViewerResource {


    @GET
    @Produces(MediaType.TEXT_HTML)
    public TemplateInstance renderSvg() {



        return null;
    }


}
