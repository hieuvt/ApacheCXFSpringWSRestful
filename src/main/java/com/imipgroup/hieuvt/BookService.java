package com.imipgroup.hieuvt;

import org.apache.cxf.rs.security.cors.CorsHeaderConstants;
import org.apache.cxf.rs.security.cors.CrossOriginResourceSharing;
import org.apache.cxf.rs.security.cors.LocalPreflight;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Response;
import java.util.List;

/**
 * Created by hieu.vutrong on 10/28/2014.
 */
@CrossOriginResourceSharing(
        allowAllOrigins = true
)
@Path("/books")
@Produces({"application/json"})
@Consumes({"application/xml", "application/json", "application/x-www-form-urlencoded"})

public class BookService {

    @Context
    private HttpHeaders headers;
    protected final Logger log = LoggerFactory.getLogger(BookService.class);

    @GET
    @Path("{id}")

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

        return bookVO;
    }

    @GET
    public List<BookVO> getAllBooks() {
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
    /*public BookVO createBook(@FormParam("bookName") String bookName,
                             @FormParam("author") String author){
        BookVO bookVO = new BookVO();
        bookVO.setBookName(bookName);
        bookVO.setAuthor(author);
        return BookDB.getInstance().createNewBook(bookVO);
    }*/

    public BookVO createBook(BookVO bookVO) {
        return BookDB.getInstance().createNewBook(bookVO);
    }

    @PUT
    public BookVO updateBookInfo(BookVO bookVO) {
        return BookDB.getInstance().updateBookInfo(bookVO);
    }

    @DELETE
    @Path("{id}")
    public List<BookVO> removeBook(@PathParam("id") String id) {
        Integer bookId = new Integer(id);
        return BookDB.getInstance().removeBook(bookId);
    }

/*    public Response removeBook(@PathParam("id") String id) {
        Integer bookId = new Integer(id);
        return Response.ok(BookDB.getInstance().removeBook(bookId))
                .header(CorsHeaderConstants.HEADER_AC_ALLOW_METHODS, "DELETE PUT")
                .header(CorsHeaderConstants.HEADER_AC_ALLOW_ORIGIN, "*")
                .build();
    }*/


}