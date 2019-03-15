package nl.lawik.poc.jaxrs.endpoint

import nl.lawik.poc.jaxrs.Data
import nl.lawik.poc.jaxrs.entity.Person
import javax.ws.rs.*
import javax.ws.rs.core.MediaType
import javax.ws.rs.core.Response


@Path("/person")
@Produces(MediaType.APPLICATION_JSON)
class PersonEndpoint {

    @GET
    fun allPersonsGET(): Response {
        return Response.ok().entity(Data.findAll()).build()
    }

    @GET
    @Path("/{id}")
    fun personByIdGET(@PathParam("id") id: Int): Response {
        val person: Person? = Data.findById(id)
        return if (person != null) {
            Response.ok().entity(person).build()
        } else {
            Response.status(Response.Status.NOT_FOUND).build()
        }
    }

    @DELETE
    fun personDEL(@QueryParam("id") id: Int): Response {
        return if (Data.delete(id)) {
            Response.status(Response.Status.NO_CONTENT).build()
        } else {
            Response.status(Response.Status.NOT_FOUND).build()
        }
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    fun personPOST(person: Person): Response {
        return if (person.id == null) {
            val id = Data.insert(person)
            Response.status(Response.Status.CREATED).entity(hashMapOf("id" to id)).build()
        } else {
            Response.status(Response.Status.BAD_REQUEST)
                .entity(hashMapOf("error" to "you may not provide a id for a new person")).build()
        }
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    fun personPUT(person: Person): Response {
        return if (Data.update(person)) {
            Response.status(Response.Status.NO_CONTENT).build()
        } else {
            Response.status(Response.Status.BAD_REQUEST)
                .entity(hashMapOf("error" to "person with id: ${person.id} not found")).build()
        }
    }
}