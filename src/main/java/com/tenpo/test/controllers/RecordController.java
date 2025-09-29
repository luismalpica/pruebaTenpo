package com.tenpo.test.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.tenpo.test.dto.response.RecordResponseDTO;
import com.tenpo.test.services.RecordServiceImpl;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("v1")
public class RecordController {

   @Autowired
   private RecordServiceImpl recordService;

   @GetMapping("/record/all")
   public List<RecordResponseDTO> retrieveAllRecord() {
      log.info("Getting all records like a history");
      return recordService.findAll();
   }

}
