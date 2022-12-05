package com.example.logger.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.logger.bean.Logger;
import com.example.logger.repo.LoggerRepository;

@RestController
public class LoggerController {
	@Autowired
	private LoggerRepository loggerRepository;
	
	@RequestMapping(value = "/logger", method = RequestMethod.GET)
	public List<Logger> loggerGet() {
		List<Logger> list = loggerRepository.findAll();
		return list;
	}
	
	@RequestMapping(value = "/logger", method = RequestMethod.POST)
    public List<Logger> loggerPost(
            @RequestBody List<Logger> loggerList) {

        List<Logger> result = loggerRepository.saveAll(loggerList);
        return result;
    }
	
	@RequestMapping(value = "/logger", method = RequestMethod.PUT)
    public Logger loggerPut(@RequestBody Logger logger){
        Optional<Logger> target = loggerRepository.findById(logger.getId());
        if(target.isEmpty()) {
            return null;
        } else {
            loggerRepository.save(logger);
            return target.get();
        }
    }
	
	@RequestMapping(value = "/logger", method = RequestMethod.DELETE)
    public Logger loggerDelete(@RequestBody Logger logger) {
        Optional<Logger> target = loggerRepository.findById(logger.getId());
        if(target.isEmpty()) {
            return null;
        } else {
            loggerRepository.deleteById(target.get().getId());
            return target.get();
        }
    }
}
