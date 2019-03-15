package nl.lawik.poc.jaxrs

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import javax.ws.rs.Consumes
import javax.ws.rs.ext.ContextResolver
import javax.ws.rs.ext.Provider

@Provider
@Consumes("application/json", "application/*+json", "text/json")
class JSONConsumer : ContextResolver<ObjectMapper> {

    private val objectMapper: ObjectMapper = jacksonObjectMapper()

    override fun getContext(type: Class<*>?): ObjectMapper {
        return objectMapper
    }

}