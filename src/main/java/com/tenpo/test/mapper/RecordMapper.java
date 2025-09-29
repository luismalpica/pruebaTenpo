package com.tenpo.test.mapper;

import java.util.Date;

import com.tenpo.test.entities.Record;

public class RecordMapper {

   public static Record recordMapper(String endpoint, Double firstNumber, Double secondNumber,
                                     Double finalResult){

      Record record = new Record();
      record.setEndpointName(endpoint);
      record.setParameter(firstNumber + " and " + secondNumber);
      record.setDate(new Date());
      record.setResult(String.valueOf(finalResult));

      return record;
   }

}
