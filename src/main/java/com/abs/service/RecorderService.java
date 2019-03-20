/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.abs.service;

import java.util.Date;

/**
 *
 * @author ghani
 */
public interface RecorderService {

    public enum ProductPageAction {
        VIEWED, LEFT
    }

    public void recordStickinessData(ProductPageAction productPageAction, Date dateTime);
    
}
