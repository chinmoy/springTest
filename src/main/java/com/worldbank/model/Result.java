package com.worldbank.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode
public class Result {
	private String message;
	private int code;
}
