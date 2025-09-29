package com.tenpo.test.services;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import com.tenpo.test.dto.request.OperationRequestDTO;
import com.tenpo.test.dto.response.OperationResponseDTO;

public class OperationServiceTest {

   private OperationService operationService;

   @BeforeEach
   void setUp() {
      operationService = spy(new OperationService());
   }

   @Test
   void testDoOperation() {

      OperationRequestDTO request = new OperationRequestDTO(10.0, 20.0);
      String endpoint = "Endpoint Suma";

      doReturn(30.0).when(operationService).operationSum(10.0, 20.0);
      doReturn(34.5).when(operationService).calculatePercentage(30.0);
      doNothing().when(operationService).saveRecordData(endpoint, 10.0, 20.0, 34.5);


      OperationResponseDTO response = operationService.doOperation(request, endpoint);

      assertNotNull(response);
      assertEquals(34.5, response.getResult());

      verify(operationService, times(1)).saveRecordData(endpoint, 10.0, 20.0, 34.5);
   }

}
