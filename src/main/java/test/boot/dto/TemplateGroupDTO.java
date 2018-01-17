package test.boot.dto;

import java.util.List;

public class TemplateGroupDTO {

	private Integer id;	private String name;
	
	private List<Integer> tIds;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Integer> gettIds() {
		return tIds;
	}

	public void settIds(List<Integer> tIds) {
		this.tIds = tIds;
	}
}
