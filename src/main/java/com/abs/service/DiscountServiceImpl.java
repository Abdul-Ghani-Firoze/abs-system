/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.abs.service;

import com.abs.model.Discount;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

/**
 *
 * @author ghani
 */
@Path("abs")
public class DiscountServiceImpl implements DiscountService {

    @Override
    public Discount getDiscount() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    @GET
    @Path("test")
    public void test() {
        System.out.println("TESTTTT");
    }

}
