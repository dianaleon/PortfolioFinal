package com.portfolio.model.entities.component;

public class BackgroundObject {
	
	private String startColor = null;
	private String endColor = null;
	private int angle = -1;
	
	public BackgroundObject(String value) {
		String[] values = value.split(";");
		if (values.length > 0) {
			startColor = values[0];
		}
		if (values.length > 1) {
			endColor = values[1];
		}
		if (values.length == 3) {
			angle = Integer.valueOf(values[2]);
		}
	}

	public String getStartColor() {
		return startColor;
	}

	public void setStartColor(String startColor) {
		this.startColor = startColor;
	}

	public String getEndColor() {
		return endColor;
	}

	public void setEndColor(String endColor) {
		this.endColor = endColor;
	}

	public int getAngle() {
		return angle;
	}

	public void setAngle(int angle) {
		this.angle = angle;
	}

}
