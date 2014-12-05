package com.imipgroup.hieuvt;

import junit.framework.TestCase;
import org.apache.commons.httpclient.Header;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.PostMethod;

import java.net.URLEncoder;

public class BookServiceTest extends TestCase {

    public void testGetBucket() throws Exception {

        String output = null;
        String bookName = "book#1";
        String expectedOutput = "<?xml version=" + "\"" + "1.0" + "\""
                + " encoding=" + "\"" + "UTF-8" + "\"" + " standalone=" + "\""
                + "yes" + "\"" + "?><Book><author>author#1</author><bookId>0</bookId><bookName>book#1</bookName></Book>";
        try {
            String url = "http://localhost:8080/bookservice/getbook/";

            url = url + URLEncoder.encode(bookName, "UTF-8");

            HttpClient client = new HttpClient();
            PostMethod mPost = new PostMethod(url);
            client.executeMethod(mPost);
            Header mtHeader = new Header();
            mtHeader.setName("content-type");
            mtHeader.setValue("application/x-www-form-urlencoded");
            mtHeader.setName("accept");
//            mtHeader.setValue("application/xml");
            mtHeader.setValue("application/json");
            mPost.addRequestHeader(mtHeader);
            client.executeMethod(mPost);
            output = mPost.getResponseBodyAsString();
            mPost.releaseConnection();
           System.out.println(output);
//            assertEquals(output,expectedOutput);
        } catch (Exception e) {
            throw new Exception("Exception in retriving group page info : " + e);
        }
    }
}