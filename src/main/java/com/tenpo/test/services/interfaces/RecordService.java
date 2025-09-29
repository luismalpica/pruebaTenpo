package com.tenpo.test.services.interfaces;

import java.util.List;

import com.tenpo.test.dto.response.RecordResponseDTO;
import com.tenpo.test.entities.Record;

public interface RecordService {

   List<RecordResponseDTO> findAll();

   Record save(Record record);

}
