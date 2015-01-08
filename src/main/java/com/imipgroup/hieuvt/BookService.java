package com.imipgroup.hieuvt;

import org.apache.cxf.rs.security.cors.CorsHeaderConstants;
import org.apache.cxf.rs.security.cors.CrossOriginResourceSharing;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.util.List;

/**
 * Created by hieu.vutrong on 10/28/2014.
 */
@CrossOriginResourceSharing(
        allowAllOrigins = true
)
@Path("/books")
public class BookService {

    protected final Logger log = LoggerFactory.getLogger(BookService.class);

    @GET
    @Path("{id}")
    @Produces({"application/json"})
    @Consumes({"application/xml","application/json","application/x-www-form-urlencoded"})
/*    public Response getBucket(@PathParam("id") String id) {
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
    }*/


    public BookVO getBucket(@PathParam("id") String id) {

        log.debug("id : " + id);
        Integer bookId = new Integer(id);
        BookVO bookVO = null;
        try {
            bookVO = BookDB.getInstance().getBook(bookId);
        } catch (Exception e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }

/*        if(bookVO == null){
            return Response.status(Response.Status.BAD_REQUEST).build();
        }else{
            System.out.println(bookVO.getBookName());
            return Response.ok(bookVO)
                    .header(CorsHeaderConstants.HEADER_AC_ALLOW_ORIGIN, "*")
                    .build();
        }
        System.out.println(bookVO.getBookName());*/
        return bookVO;
    }

    @GET
    @Produces({"application/json"})
    @Consumes({"application/xml","application/json","application/x-www-form-urlencoded"})
    public List<BookVO> getAllBooks(){
/*        List<BookVO> bookVOs = BookDB.getInstance().getBooks();
        if(bookVOs == null){
            return Response.status(Response.Status.BAD_REQUEST).build();
        }else {
            return Response.ok(bookVOs)
                    .header(CorsHeaderConstants.HEADER_AC_ALLOW_ORIGIN, "*")
                    .build();
        }*/
        return BookDB.getInstance().getBooks();
    }

    @POST
    @Path("{id}")
    @Produces({"application/json"})
    @Consumes({"application/xml","application/json","application/x-www-form-urlencoded"})
    public BookVO createBook(BookVO bookVO){
        return BookDB.getInstance().createNewBook(bookVO);
    }

/*    need book without bookId to be passed. BookId will be added in bookDB.createNewBook (need to modified)
    need check how Angular pass object to backend*/

}