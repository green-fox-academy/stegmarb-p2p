package com.greenfox.repository;

import com.greenfox.model.LogMessage;
import org.springframework.data.repository.CrudRepository;

public interface LogMessageRepository extends CrudRepository<LogMessage, Long> {
}
