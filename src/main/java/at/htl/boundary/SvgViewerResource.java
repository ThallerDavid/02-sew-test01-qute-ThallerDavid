package at.htl.boundary;

import at.htl.control.CircleRepository;
import at.htl.control.LineConfigRepository;
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

    @Inject
    CircleRepository circleRepository;

    @Inject
    LineConfigRepository lineConfigRepository;

    @CheckedTemplate()
    public static class Templates {
        public static native TemplateInstance viewer(List<Circle> circles, Circle solar, Circle wechselrichter);
    }


    @GET
    @Produces(MediaType.TEXT_HTML)
    public TemplateInstance renderSvg() {
        var circles = circleRepository.listAll();
        var solarPannel = circleRepository.findByName("solar-panel");
        var wechselRichter = circleRepository.findByName("inverter");

        circles.forEach((circle) -> {
            if(circle.getLineConfig() != null) {
                var lineConfig = circle.getLineConfig();
                Circle destination = (Circle) circle.getDestination();

                lineConfig.setX2pos(destination.getxPos());
                lineConfig.setY2pos(destination.getyPos());
            }
        });

        return Templates.viewer(circles, solarPannel, wechselRichter);
    }


}
