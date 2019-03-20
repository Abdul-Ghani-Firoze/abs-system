/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.abs.service;

import java.util.Date;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;

/**
 *
 * @author ghani
 */
@Path("recorder")
public class RecorderServiceImpl implements RecorderService {

    @Override
    @POST
    @Path("/recordStickiness")
    public void recordStickinessData(ProductPageAction productPageAction, Date dateTime) {
        System.out.println("RECORDING STICKINESS: Action: " + productPageAction + " DateTime: " + dateTime);
    }

    @GET
    @Path("test")
    public void test() {
        System.out.println("TESTTTT");
    }
    
    public void test2() {
        
    }
}
