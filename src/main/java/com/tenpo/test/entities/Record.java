package com.tenpo.test.entities;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="records")
public class Record {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;

   private String endpointName;
   private String parameter;
   private Date date;
   private String result;

   public Record() {
   }

   public Long getId() {
      return id;
   }

   public void setId(Long id) {
      this.id = id;
   }

   public String getEndpointName() {
      return endpointName;
   }

   public void setEndpointName(String endpointName) {
      this.endpointName = endpointName;
   }

   public String getParameter() {
      return parameter;
   }

   public void setParameter(String parameter) {
      this.parameter = parameter;
   }

   public Date getDate() {
      return date;
   }

   public void setDate(Date date) {
      this.date = date;
   }

   public String getResult() {
      return result;
   }

   public void setResult(String result) {
      this.result = result;
   }
}
