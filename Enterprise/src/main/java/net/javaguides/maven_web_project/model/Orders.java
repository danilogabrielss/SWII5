package net.javaguides.maven_web_project.model;

import java.util.Date;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Orders {

	private int ordNo;
	private float purchase;
	private Date ordDate;
	private int costumerId;
	private int salesmanId;
	
}
