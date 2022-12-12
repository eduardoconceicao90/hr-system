package com.payrollapi.service;


import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import com.payrollapi.domain.Payroll;
import com.payrollapi.feignClients.UserFeign;
import com.payrollapi.service.exception.ObjectNotFoundException;

import feign.FeignException;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class PayrollService {
	
	@Autowired
	private Environment environment;
	
	@Autowired
	private UserFeign userFeign;
	
	public Payroll getPayment(Long workerId, Payroll payroll) {
		log.info("PAYROLL_SERVICE ::: Get request on " + environment.getProperty("local.server.port") + " port");
		try {
			var user = userFeign.findByid(workerId).getBody();
			if(Objects.nonNull(user)) {
				return new Payroll(
						user.getName(), 
						payroll.getDescription(), 
						user.getHourlyPrice(),
						payroll.getWorkedHours(), 
						user.getHourlyPrice() * payroll.getWorkedHours() 
						);
			}
			
		} catch (FeignException.NotFound ex) {
			throw new ObjectNotFoundException("Object not found");
		} catch (Exception ex) {
			throw new IllegalArgumentException("Illegal argument exception");
		}
		return null;
	}

}
