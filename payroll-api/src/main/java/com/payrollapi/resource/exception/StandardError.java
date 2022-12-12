package com.payrollapi.resource.exception;

import java.io.Serializable;
import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class StandardError implements Serializable {

	private static final long serialVersionUID = 1L;

	private LocalDateTime timestamp;
	private String error;
	private Integer status;
	private String path;
	
}
