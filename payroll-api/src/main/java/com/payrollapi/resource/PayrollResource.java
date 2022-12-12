package com.payrollapi.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.payrollapi.domain.Payroll;
import com.payrollapi.service.PayrollService;

@RestController
@RequestMapping(value = "/payments")
public class PayrollResource {
	
	@Autowired
	private PayrollService payrollService;

	@GetMapping(value = "/{workerId}")
	public ResponseEntity<Payroll> getPayment(@PathVariable Long workerId, @RequestBody Payroll payment) {
		return ResponseEntity.ok().body(payrollService.getPayment(workerId, payment));			
	}
}
