package nl.lawik.poc.jaxrs.endpoint

import javax.ws.rs.GET
import javax.ws.rs.HeaderParam
import javax.ws.rs.Path
import javax.ws.rs.Produces
import javax.ws.rs.core.MediaType
import javax.ws.rs.core.Response

private const val USER_AGENT = "user-agent"
private const val ACCEPT = "accept"
private const val ACCEPT_ENCODING = "accept-encoding"
private const val ACCEPT_LANGUAGE = "accept-language"

@Path("/header")
@Produces(MediaType.APPLICATION_JSON)
class HeaderEndpoint {

    @GET
    fun headersGET(
        @HeaderParam(USER_AGENT) userAgent: String?,
        @HeaderParam(ACCEPT) accept: String?,
        @HeaderParam(ACCEPT_ENCODING) acceptEncoding: String?,
        @HeaderParam(ACCEPT_LANGUAGE) acceptLanguage: String?
    ): Response = Response.ok().entity(
        hashMapOf(
            USER_AGENT to userAgent,
            ACCEPT to accept,
            ACCEPT_ENCODING to acceptEncoding,
            ACCEPT_LANGUAGE to acceptLanguage
        )
    ).build()


    @GET
    @Path("/$USER_AGENT")
    fun userAgentGET(@HeaderParam(USER_AGENT) userAgent: String?): Response =
        Response.ok().entity(hashMapOf(USER_AGENT to userAgent)).build()


    @GET
    @Path("/$ACCEPT")
    fun acceptGET(@HeaderParam(ACCEPT) accept: String?): Response =
        Response.ok().entity(hashMapOf(ACCEPT to accept)).build()


    @GET
    @Path("/$ACCEPT_ENCODING")
    fun acceptEncodingGET(@HeaderParam(ACCEPT_ENCODING) acceptEncoding: String?): Response =
        Response.ok().entity(hashMapOf(ACCEPT_ENCODING to acceptEncoding)).build()


    @GET
    @Path("/$ACCEPT_LANGUAGE")
    fun acceptLanguageGET(@HeaderParam(ACCEPT_LANGUAGE) acceptLanguage: String?): Response =
        Response.ok().entity(hashMapOf(ACCEPT_LANGUAGE to acceptLanguage)).build()

}