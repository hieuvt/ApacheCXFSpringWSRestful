package com.imipgroup.hieuvt;

import org.apache.cxf.rs.security.cors.CorsHeaderConstants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.util.List;

/**
 * Created by hieu.vutrong on 10/28/2014.
 */
//@CrossOriginResourceSharing(allowAllOrigins = true)
public class BookService {

    protected final Logger log = LoggerFactory.getLogger(BookService.class);

    @GET
    @Path("/getbook/{id}")
    @Produces({"application/json"})
    @Consumes({"application/xml","application/json","application/x-www-form-urlencoded"})
    public Response getBucket(@PathParam("id") String id) {
        log.debug("id : " + id);
        Integer bookId = new Integer(id);
        BookVO bookVO = null;
        try {
            bookVO = BookDB.getInstance().getBook(bookId);
        } catch (Exception e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }

        if(bookVO == null){
            return Response.status(Response.Status.BAD_REQUEST).build();
        }else{
            System.out.println(bookVO.getBookName());
            return Response.ok(bookVO)
                    .header(CorsHeaderConstants.HEADER_AC_ALLOW_ORIGIN, "*")
                    .build();
        }
    }

    @GET
    @Path("/getAllBooks")
    @Produces({"application/json"})
    @Consumes({"application/xml","application/json","application/x-www-form-urlencoded"})
    public Response getAllBooks(){
        List<BookVO> bookVOs = BookDB.getInstance().getBooks();
        if(bookVOs == null){
            return Response.status(Response.Status.BAD_REQUEST).build();
        }else {
            return Response.ok(bookVOs)
                    .header(CorsHeaderConstants.HEADER_AC_ALLOW_ORIGIN, "*")
                    .build();
        }
    }



}