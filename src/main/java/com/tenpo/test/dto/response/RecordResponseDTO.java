package com.tenpo.test.dto.response;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class RecordResponseDTO {
   private String endpointName;
   private String parameter;
   private Date date;
   private String result;
}
