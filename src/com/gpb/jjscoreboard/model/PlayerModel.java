package com.gpb.jjscoreboard.model;

import java.awt.Color;

public class PlayerModel extends BroadcastingModel {
	private int score;
	private int advantages;
	private int penalties;
	private String name;
	private Color color;
	
	public PlayerModel(String name, Color color) {
		this.name = name;
		this.color = color;
		resetPlayer();
	}

	public void resetPlayer() {
		score = advantages = penalties = 0;
		broadcastModelChange();
	}

	public int getScore() {
		return score;
	}
	
	public void setScore(int score) {
		this.score = score;
		broadcastModelChange();
	}
	
	public int getAdvantages() {
		return advantages;
	}
	
	public void setAdvantages(int advantages) {
		this.advantages = advantages;
		broadcastModelChange();
	}
	
	public int getPenalties() {
		return penalties;
	}
	
	public void setPenalties(int penalties) {
		this.penalties = penalties;
		broadcastModelChange();
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
		broadcastModelChange();
	}
	
	public Color getColor() {
		return color;
	}
	
	public void setColor(Color color) {
		this.color = color;
		broadcastModelChange();
	}
}
