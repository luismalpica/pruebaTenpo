package com.tenpo.test.services;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class CacheService {

   private String url;
   private final RestTemplate restTemplate;
   private final CacheManager cacheManager;

   public CacheService(RestTemplate restTemplate,
                        CacheManager cacheManager,
                        @Value("${external.service.url}") String url) {
      this.restTemplate = restTemplate;
      this.cacheManager = cacheManager;
      this.url = url;
   }

   @Cacheable("externalPercentage")
   public Double getValuePercentage(){
      log.info("Enter the first time and after 30 min it will be possible to consume again");
      Cache cache = cacheManager.getCache("externalPercentage");

      try {
         var value = restTemplate.getForObject(url, Double.class);
         cache.put("lastPercentage", value);

         return value;
      } catch (RestClientException e) {
         Cache.ValueWrapper cached = cache.get("lastPercentage");
         if (cached != null) {
            return (Double) cached.get();
         } else {
            throw new RuntimeException("Service is not available and there is not data cached");
         }
      }

   }

}
