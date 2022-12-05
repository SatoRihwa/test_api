package com.example.logger.repo;
import com.example.logger.bean.*;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoggerRepository extends JpaRepository<Logger, Integer>{
	
}
