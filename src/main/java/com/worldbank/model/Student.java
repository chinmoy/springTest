package com.worldbank.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@NoArgsConstructor
@EqualsAndHashCode
public class Student {
	@NonNull
	private String name;
	private int roll;
}
