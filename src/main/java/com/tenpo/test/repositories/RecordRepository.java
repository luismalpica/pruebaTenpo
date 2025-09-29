package com.tenpo.test.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tenpo.test.entities.Record;

public interface RecordRepository extends JpaRepository<Record, Long> {}

