package com.tenpo.test.dto.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class OperationResponseDTO {
   private Double result;

   public static OperationResponseDTO fromOperationResult(Double result){
      return OperationResponseDTO.builder()
                                 .result(result).build();
   }
}
