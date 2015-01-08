package com.imipgroup.hieuvt;

import junit.framework.TestCase;
import org.apache.commons.httpclient.Header;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.GetMethod;

public class BookServiceTest extends TestCase {

    String quote = "\"";
    static final String url = "http://localhost:8080/bookservice/books/";

    private String executeURL(String url) {
        String output = null;
        try {

            HttpClient client = new HttpClient();

//            PostMethod mPost = new PostMethod(url);
//            client.executeMethod(mPost);

            GetMethod mGet = new GetMethod(url);
            client.executeMethod(mGet);

            Header mtHeader = new Header();
            mtHeader.setName("content-type");
            mtHeader.setValue("application/x-www-form-urlencoded");
            mtHeader.setName("accept");
//            mtHeader.setValue("application/xml");
            mtHeader.setValue("application/json");

//            mPost.addRequestHeader(mtHeader);
//            client.executeMethod(mPost);
//            output = mPost.getResponseBodyAsString();
//            mPost.releaseConnection();

            mGet.addRequestHeader(mtHeader);
            client.executeMethod(mGet);
            output = mGet.getResponseBodyAsString();
            mGet.releaseConnection();

            System.out.println(output);
//            assertEquals(output,expectedOutput);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return output;
    }

    public void testGetBucket() throws Exception {

        int bookId = 1;
        String expectedOutput = "{" + quote + "bookId" + quote + ":1," + quote + "bookName" + quote + ":" + quote + "book#1" + quote + "," + quote + "author" + quote + ":" + quote + "author#1" + quote + "}";
//            url = url + URLEncoder.encode(bookId, "UTF-8");
        String tmpUrl = url + bookId;
        assertEquals(expectedOutput, executeURL(tmpUrl));
    }

    public void testGetAllBooks() throws Exception {
        String expectedOutput = "";
        executeURL(url);
    }
}