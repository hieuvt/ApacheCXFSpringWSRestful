package com.imipgroup.hieuvt;

import junit.framework.TestCase;
import org.apache.commons.httpclient.Header;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpMethod;
import org.apache.commons.httpclient.methods.DeleteMethod;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.cxf.jaxrs.client.WebClient;
import org.codehaus.jackson.jaxrs.JacksonJsonProvider;

import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;

public class BookServiceTest extends TestCase {

    String quote = "\"";
    static final String url = "http://localhost:8080/bookservice/books/";

    private String executeURL(HttpMethod httpMethod) {
        String output = null;
        try {

            HttpClient client = new HttpClient();
            client.executeMethod(httpMethod);

            Header mtHeader = new Header();
            mtHeader.setName("content-type");
            mtHeader.setValue("application/x-www-form-urlencoded");
            mtHeader.setName("accept");
            mtHeader.setValue("application/json");

            httpMethod.addRequestHeader(mtHeader);
            client.executeMethod(httpMethod);
            output = httpMethod.getResponseBodyAsString();
            httpMethod.releaseConnection();

            System.out.println(output);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return output;
    }

    public void testGetBucket() throws Exception {

        int bookId = 0;
        String expectedOutput = "{" + quote + "bookId" + quote + ":0," + quote + "bookName" + quote + ":" + quote + "book#0" + quote + "," + quote + "author" + quote + ":" + quote + "author#0" + quote + "}";
//            url = url + URLEncoder.encode(bookId, "UTF-8");
        String tmpUrl = url + bookId;
//        assertEquals(expectedOutput, executeURLGet(tmpUrl));
        GetMethod mGet = new GetMethod(tmpUrl);
        assertEquals(expectedOutput, executeURL(mGet));
    }

    public void testGetAllBooks() throws Exception {
        String expectedOutput = "";
        GetMethod mGet = new GetMethod(url);
        executeURL(mGet);
    }

    public void testCreateBook() throws Exception {
        List<JacksonJsonProvider> providerList = new ArrayList<JacksonJsonProvider>();
        JacksonJsonProvider provider = new JacksonJsonProvider();
        provider.addUntouchable(Response.class);
        providerList.add(provider);

        WebClient client = WebClient.create("http://localhost:8080/bookservice/books", providerList);
        client.accept("application/json").type("application/json");
        BookVO bookVO = new BookVO(0, "New Book", "New Author");
        BookVO addBookResponse = client.post(bookVO, BookVO.class);
        System.out.println(addBookResponse.getBookId());
    }

/*    public void testUpdateBookInfo() throws Exception {
        List<JacksonJsonProvider> providerList = new ArrayList<JacksonJsonProvider>();
        JacksonJsonProvider provider = new JacksonJsonProvider();
        provider.addUntouchable(Response.class);
        providerList.add(provider);

        WebClient client = WebClient.create("http://localhost:8080/bookservice/books", providerList);
        client.accept("application/json").type("application/json");
        BookVO bookVO = new BookVO(1, "Test Book", "Test Author");
        BookVO addBookResponse = client.put(bookVO, BookVO.class);
        System.out.println(addBookResponse.getBookId());
    }*/

    public void testRemoveBook() throws Exception {
        System.out.println("BookServiceTest.testRemoveBook");
        int bookId = 1;
        String tmpUrl = url + bookId;
        DeleteMethod mDelete = new DeleteMethod(tmpUrl);
        executeURL(mDelete);
        /*try {
            HttpClient client = new HttpClient();
            client.executeMethod(mDelete);

*//*        Header mtHeader = new Header();
        mtHeader.setName("content-type");
        mtHeader.setValue("application/x-www-form-urlencoded");
        mtHeader.setName("accept");
        mtHeader.setValue("application/json");

        httpMethod.addRequestHeader(mtHeader);*//*
            client.executeMethod(mDelete);

            mDelete.releaseConnection();


        } catch (Exception e) {
            e.printStackTrace();
        }*/
    }
}