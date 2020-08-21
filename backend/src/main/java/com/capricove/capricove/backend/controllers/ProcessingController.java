package com.capricove.capricove.backend.controllers;

import com.capricove.capricove.backend.data.Coordinate;
import com.capricove.capricove.backend.data.DeliveryDTO;
import com.capricove.capricove.backend.services.ProcessingService;
import com.google.maps.errors.ApiException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping("/processor")
public class ProcessingController {

    @Autowired
    ProcessingService processingService;

    @PostMapping("/get_delivery_fee")
    public DeliveryDTO getDeliveryInfo(@RequestBody Coordinate coordinate) throws InterruptedException, ApiException, IOException {
        System.out.println(coordinate.getLatitude());
        System.out.println(coordinate.getLongitude());
        return processingService.getDeliveryDTO(coordinate);
    }
}
