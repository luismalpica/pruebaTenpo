package com.tenpo.test.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tenpo.test.external_services.MockPercentageService;

@RestController
@RequestMapping("external")
public class ExternalController {

   private final MockPercentageService mockPercentageService;

   public ExternalController(MockPercentageService mockPercentageService) {
      this.mockPercentageService = mockPercentageService;
   }

   @GetMapping("/percentage")
   public Double getExternalValue() {
      return mockPercentageService.getPercentageValue();
   }

}
