package org.lgim.rest.endpoints;

import org.jboss.logging.Logger;
import org.lgim.data.orm.EmotionEntity;
import org.lgim.rest.model.EmotionIncident;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;

@Path("/emotions")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@RequestScoped
public class EmotionResource {
    private static final Logger LOGGER = Logger.getLogger(EmotionResource.class.getName());

    @Inject
    EntityManager entityManager;

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Transactional
    public Response create(final EmotionIncident emotionIncident) {
        LOGGER.info("Request to Create with body : " + emotionIncident.toString());
        final EmotionEntity emotionEntity = EmotionIncident.getEmotionEntity(emotionIncident);
        entityManager.persist(emotionEntity);
        LOGGER.info("Request successful. Here is response : " + emotionEntity.toString());
        return Response.ok("Cheers").build();
    }

    @GET
    public Response get() {
        final List<EmotionEntity> resultList = entityManager.createNamedQuery("emotions.findAll", EmotionEntity.class)
                .getResultList();
        final List<EmotionIncident> emotionIncidents = new ArrayList<>();
        if (resultList != null && !resultList.isEmpty()) {
            resultList
                    .forEach(emotionEntity -> emotionIncidents.add(EmotionIncident.getEmotionIncident(emotionEntity)));
        }
        return Response.ok(emotionIncidents).build();
    }
}