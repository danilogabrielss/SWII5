package net.javaguides.maven_web_project.model;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Costumer {

	private int id;
	private String custName;
	private String city;
	private int grade;
	private int salesmanId;
	
}
