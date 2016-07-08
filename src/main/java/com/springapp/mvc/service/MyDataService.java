package com.springapp.mvc.service;

/**
 * Created by akhil on 1/7/16.
 */
import com.springapp.mvc.model.Employee;

import javax.ws.rs.*;


@Path("/")
@Produces("application/json")
@Consumes("application/json")
public interface MyDataService {

    @Path("/ping")
    @GET
    String ping();

    @Path("/getEmployee/{id}/{website}")
    @GET
    Employee getEmployeeName(@PathParam("id") String id,@PathParam("website") String website);

    @Path("/saveEmployee/{id}/{name}/{dno}")
    @GET
    void saveEmployee(@PathParam("id") String id, @PathParam("name") String name, @PathParam("dno") String dno);

}
