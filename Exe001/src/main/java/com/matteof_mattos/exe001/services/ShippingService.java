package com.matteof_mattos.exe001.services;

import org.springframework.stereotype.Service;

@Service
public class ShippingService {

    public int shipment(Double basic) {

        if (basic<100){
            return 20;
        } else if (basic>=100 && basic<=200){
            return 12;
        } else {
            return 0;
        }
    }
}
