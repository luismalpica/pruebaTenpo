package com.tenpo.test.error;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class ApiError {
   private String message;
   private String details;
}
