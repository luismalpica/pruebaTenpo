package com.tenpo.test.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tenpo.test.dto.response.RecordResponseDTO;
import com.tenpo.test.entities.Record;
import com.tenpo.test.repositories.RecordRepository;
import com.tenpo.test.services.interfaces.RecordService;

import jakarta.transaction.Transactional;

@Service
public class RecordServiceImpl implements RecordService {

   @Autowired
   private RecordRepository recordRepository;

   @Override
   public List<RecordResponseDTO> findAll() {

      List<Record> recordList = recordRepository.findAll();

      return recordList.stream()
                      .map(r -> new RecordResponseDTO(r.getEndpointName(), r.getParameter(), r.getDate(), r.getResult()))
                      .toList();
   }

   @Override
   @Transactional
   public Record save(Record record) {
      return recordRepository.save(record);
   }
}
