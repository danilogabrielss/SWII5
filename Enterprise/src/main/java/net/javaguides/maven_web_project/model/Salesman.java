package net.javaguides.maven_web_project.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Salesman {
	private int id;
	private String name;
	private String city;
	private float commission;

	public Salesman (int id,String name, String city, float comissao) {
		this.id = id;
		this.name = name;
		this.city = city;
		this.commission = comissao;
	}
}
