package com.example.resources;

import com.example.exceptions.UserNotExistsException;
import com.example.services.UsersService;
import com.example.utils.CorsGenerator;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/exampleurl")
public class ExampleResource {

    public static final String ID = "id";

    final Logger logger = LogManager.getLogger(ExampleResource.class.getName());

    @OPTIONS
    public Response corsMyResource(@HeaderParam("Access-Control-Request-Headers") String requestH) {
        return CorsGenerator.makeCORS(Response.ok(), requestH);
    }


    @OPTIONS
    @Path("{id}")
    public Response corsMyResourceId(@HeaderParam("Access-Control-Request-Headers") String requestH) {
        return CorsGenerator.makeCORS(Response.ok(), requestH);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getUser(@QueryParam(ID) String id) {
        try {
            UsersService.getInstance().findUser(id);
        } catch (UserNotExistsException e) {
            e.printStackTrace();
            //handle exception
        }

        return Response.status(200).header("Access-Control-Allow-Origin", "*").entity("Welcome TA Team!").build();
    }


    @PUT
    @Path("{id}/putMethod")
    @Produces(MediaType.APPLICATION_JSON)
    public Response putExample(@PathParam(ID) String id) {
        return Response.status(200).header("Access-Control-Allow-Origin", "*").build();
    }

}
