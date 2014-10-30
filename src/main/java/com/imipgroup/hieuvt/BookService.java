package com.imipgroup.hieuvt;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

/**
 * Created by hieu.vutrong on 10/28/2014.
 */
public class BookService {

    protected final Logger log = LoggerFactory.getLogger(BookService.class);


    @POST
    @Path("/getbook/{name}")
    @Produces({"application/xml","application/json"})
    @Consumes({"application/xml","application/json","application/x-www-form-urlencoded"})
    public Response getBucket(@PathParam("name") String name) {
        log.debug("name : " + name);
        BookVO bookVO = null;

        try {
            bookVO = BookDB.getInstance().getBook(name);
        } catch (Exception e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }

        if(bookVO == null){
            return Response.status(Response.Status.BAD_REQUEST).build();
        }else{
            return Response.ok(bookVO).build();
        }
    }
}