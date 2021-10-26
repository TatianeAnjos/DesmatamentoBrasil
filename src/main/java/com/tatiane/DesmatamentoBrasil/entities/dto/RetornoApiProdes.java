package com.tatiane.DesmatamentoBrasil.entities.dto;

import java.util.ArrayList;
import java.util.List;

public class RetornoApiProdes {

	private String displayFieldName;

	private List<Features> features = new ArrayList<>();

	public List<Features> getFeatures() {
		return features;
	}

	public void setFeatures(List<Features> features) {
		this.features = features;
	}

	public String getDisplayFieldName() {
		return displayFieldName;
	}

	public void setDisplayFieldName(String displayFieldName) {
		this.displayFieldName = displayFieldName;
	}

}
