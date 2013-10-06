package br.com.soeirosantos.rest;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.core.UriBuilder;

import br.com.soeirosantos.model.Veiculo;

/**
 * 
 */
@Stateless
@Path("/veiculos")
public class VeiculoEndpoint
{
   @PersistenceContext(unitName = "defaultPU")
   private EntityManager em;

   @POST
   @Consumes("application/json")
   public Response create(Veiculo entity)
   {
      em.persist(entity);
      return Response.created( UriBuilder.fromResource(VeiculoEndpoint.class ).path(  String.valueOf( entity.getId() )   ).build()).build();
   }

   @DELETE
   @Path("/{id:[0-9][0-9]*}")
   public Response deleteById(@PathParam("id") Long id)
   {
      Veiculo entity = em.find(Veiculo.class, id);
      if (entity == null)
      {
         return Response.status(Status.NOT_FOUND).build();
      }
      em.remove(entity);
      return Response.noContent().build();
   }

   @GET
   @Path("/{id:[0-9][0-9]*}")
   @Produces("application/json")
   public Response findById(@PathParam("id") Long id)
   {
      TypedQuery<Veiculo> findByIdQuery = em.createQuery("SELECT DISTINCT v FROM Veiculo v WHERE v.id = :entityId ORDER BY v.id", Veiculo.class);
      findByIdQuery.setParameter("entityId", id);
      Veiculo entity = findByIdQuery.getSingleResult();
      if (entity == null)
      {
         return Response.status(Status.NOT_FOUND).build();
      }
      return Response.ok(entity).build();
   }

   @GET
   @Produces("application/json")
   public List<Veiculo> listAll()
   {
      final List<Veiculo> results = em.createQuery("SELECT DISTINCT v FROM Veiculo v ORDER BY v.id", Veiculo.class).getResultList();
      return results;
   }

   @PUT
   @Path("/{id:[0-9][0-9]*}")
   @Consumes("application/json")
   public Response update(Veiculo entity)
   {
      entity = em.merge(entity);
      return Response.noContent().build();
   }
}