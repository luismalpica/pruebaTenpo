package com.tenpo.test.external_services;

import org.springframework.stereotype.Service;

@Service
public class MockPercentageService {

   private static final Double EXTERNAL_PERCENTAGE = 0.15;

   public Double getPercentageValue() {
      return EXTERNAL_PERCENTAGE;
   }

}
