package at.htl.boundary;

import at.htl.control.CircleRepository;
import at.htl.entity.dao.CircleDao;
import at.htl.entity.dao.CircleProducerDao;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/api/svg")
public class SvgViewerApi {
/*
Wechselrichter (inverter)

Solarpaneel (solar-panel)

Batterie (battery)

Einspeisung Netz (feed-in)

Verbraucher (local-consumer)

Auto Ladeanschluß (wallbox)
*/
    @Inject
    CircleRepository circleRepository;

    @Inject
    SvgViewerResource svgViewerResource;

    @Transactional
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response changePosition(CircleDao dao) {
        var circle = circleRepository.findByName(dao.htmlId());
        circle.setyPos(dao.yPos());
        circle.setxPos(dao.xPos());
        circleRepository.persist(circle);
        return Response.created(null).build();
    }

    @Transactional
    @POST
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public Response changeProducer(CircleProducerDao dao) {
        var circle = circleRepository.findByName(dao.htmlId());
        circle.setDeviceType(dao.deviceType());
        return Response.created(null).build();
    }

    @Transactional
    @GET
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public Response changeUI(@QueryParam("leistung") int pVLeistung,
                             @QueryParam("solar-xpos") int solarPositionX,
                             @QueryParam("solar-ypos") int solarPositionY,
                             @QueryParam("wr-xpos") int wrPosX,
                             @QueryParam("wr-ypos") int wrPosY ){

        var solarPannel = circleRepository.findByName("solar-panel");
        var wechselRichter = circleRepository.findByName("inverter");

        solarPannel.setxPos(solarPositionX);
        solarPannel.setyPos(solarPositionY);
        solarPannel.getLineConfig().setStrokeWidth(pVLeistung);

        circleRepository.persist(solarPannel);

        wechselRichter.setyPos(wrPosY);
        wechselRichter.setxPos(wrPosX);

        circleRepository.persist(wechselRichter);

        return Response.ok(svgViewerResource.renderSvg()).build();
    }

}
