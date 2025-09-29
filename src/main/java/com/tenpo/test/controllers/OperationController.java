package com.tenpo.test.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.tenpo.test.dto.request.OperationRequestDTO;
import com.tenpo.test.dto.response.OperationResponseDTO;
import com.tenpo.test.services.OperationService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("v1")
public class OperationController {

   @Autowired
   private OperationService operationService;

   @PostMapping("/operation/sum")
   public OperationResponseDTO doOperation(@RequestBody OperationRequestDTO operationRequestDTO) {
      log.info("Creating Operation Sum");
      return operationService.doOperation(operationRequestDTO, "v1/operation/sum");
   }

}
