package com.projeto.bookstore.controllers.exceptions;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class StandardError {
	
	private Integer status;
	private Long timestamp;
	private String message;

}
