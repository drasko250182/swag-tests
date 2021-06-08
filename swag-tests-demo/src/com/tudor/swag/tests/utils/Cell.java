package com.tudor.swag.tests.utils;

public class Cell {

	public Cell(State state, String value) {
		this.setState(state);
		this.value = value;
	}

	public Cell(String value) {
		this.value = value;
	}

	public Cell(Integer position, String value) {
		this.setPosition(position);
		this.value = value;
	}

	public enum State {
		READ, WRITE, READ_WRITE;
	}

	private String value;
	private State state;
	private Integer position;

	public void setValue(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}

	public State getState() {
		return state;
	}

	public void setState(State state) {
		this.state = state;
	}

	public Integer getPosition() {
		return position;
	}

	public void setPosition(Integer position) {
		this.position = position;
	}

}
