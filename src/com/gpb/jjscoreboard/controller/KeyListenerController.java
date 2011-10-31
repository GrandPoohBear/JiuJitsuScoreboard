package com.gpb.jjscoreboard.controller;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import com.gpb.jjscoreboard.JJSConstants;
import com.gpb.jjscoreboard.model.MatchModel;
import com.gpb.jjscoreboard.model.PlayerModel;

public class KeyListenerController implements KeyListener, JJSConstants {
	
	private final MatchModel model;
	private final PlayerModel left;
	private final PlayerModel right;
	
	public KeyListenerController(MatchModel model) {
		this.model = model;
		left = model.getLeftPlayer();
		right = model.getRightPlayer();
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// NOOP
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// NOOP
	}

	@Override
	public void keyTyped(KeyEvent e) {
		char c = e.getKeyChar();
		
		// Left
		if (c == left.getDecScoreChar()) {
			left.setScore(left.getScore() - 1);
		} else if (c == left.getIncScoreChar()) {
			left.setScore(left.getScore() + 1);
		} else if (c == left.getDecAdvChar()) {
			left.setAdvantages(left.getAdvantages() - 1);
		} else if (c == left.getIncAdvChar()) {
			left.setAdvantages(left.getAdvantages() + 1);
		} else if (c == left.getDecPenChar()) {
			left.setPenalties(left.getPenalties() - 1);
		} else if (c == left.getIncPenChar()) {
			left.setPenalties(left.getPenalties() + 1);
		}
		
		// Right
		else if (c == right.getDecScoreChar()) {
			right.setScore(right.getScore() - 1);
		} else if (c == right.getIncScoreChar()) {
			right.setScore(right.getScore() + 1);
		} else if (c == right.getDecAdvChar()) {
			right.setAdvantages(right.getAdvantages() - 1);
		} else if (c == right.getIncAdvChar()) {
			right.setAdvantages(right.getAdvantages() + 1);
		} else if (c == right.getDecPenChar()) {
			right.setPenalties(right.getPenalties() - 1);
		} else if (c == right.getIncPenChar()) {
			right.setPenalties(right.getPenalties() + 1);
		}
		
	}

}
