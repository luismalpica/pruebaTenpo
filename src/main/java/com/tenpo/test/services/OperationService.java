package com.tenpo.test.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import com.tenpo.test.dto.request.OperationRequestDTO;
import com.tenpo.test.dto.response.OperationResponseDTO;
import com.tenpo.test.entities.Record;
import com.tenpo.test.mapper.RecordMapper;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class OperationService {

   @Autowired
   private CacheService cacheService;

   @Autowired
   private RecordServiceImpl recordService;

   public OperationResponseDTO doOperation(OperationRequestDTO operationRequestDTO, String endpoint) {
      log.info("Initiation Operation Sum using number: {} and number: {}",operationRequestDTO.firstNumber(),
            operationRequestDTO.secondNumber());

      var firstNumber = operationRequestDTO.firstNumber();
      var secondNumber = operationRequestDTO.secondNumber();
      var resultSum = operationSum(firstNumber,secondNumber);

      var finalResult = calculatePercentage(resultSum);

      saveRecordData(endpoint, firstNumber, secondNumber, finalResult);

      log.info("Returning the result: {}", finalResult);
      return OperationResponseDTO.fromOperationResult(finalResult);
   }

   protected Double operationSum(Double firstNumber, Double secondNumber){
      return firstNumber + secondNumber;
   }

   protected Double calculatePercentage(Double sum){
      var percentage = getValuePercentage();
      var calculatedValue = sum * percentage;
      return sum + calculatedValue;
   }

   protected Double getValuePercentage(){
      return cacheService.getValuePercentage();
   }

   @Async
   protected void saveRecordData(String endpoint, Double firstNumber, Double secondNumber, Double finalResult){

      Record record = RecordMapper.recordMapper(endpoint, firstNumber, secondNumber, finalResult);
      recordService.save(record);
   }
}
