package com.gpb.jjscoreboard.view;

import info.clearthought.layout.TableLayout;

import java.awt.event.HierarchyEvent;
import java.awt.event.HierarchyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JLabel;
import javax.swing.JPanel;

import com.gpb.jjscoreboard.JJSConstants;
import com.gpb.jjscoreboard.model.MatchModel;
import com.gpb.jjscoreboard.model.ModelListener;

public class ConsoleMatchPanel implements ModelListener, JJSConstants {
	private final MatchModel model;
	
	private final JPanel panel;
	private final JLabel timerLabel;
	private final ConsolePlayerPanel leftPlayer;
	private final ConsolePlayerPanel rightPlayer;
	
	public ConsoleMatchPanel(MatchModel model) {
		this.model = model;
		model.addModelListener(this);
		
		double[][] tableLayoutCodes = {{10,F,10,P,10,F,10},{10,P,10,F,10}};
		panel = new JPanel(new TableLayout(tableLayoutCodes));
		
		timerLabel = new JLabel("0:00");
		timerLabel.setFont(timerLabel.getFont().deriveFont(100.f));
		panel.add(timerLabel, "1,1,5,1,c,c");
		
		leftPlayer = new ConsolePlayerPanel(model.getLeftPlayer());
		panel.add(leftPlayer.getDisplayComponent(), "1,3");
		
		rightPlayer = new ConsolePlayerPanel(model.getRightPlayer());
		panel.add(rightPlayer.getDisplayComponent(), "5,3");
		
		// Want to make sure that if the user clicks off of the text box,
		// that we get focus so we keep listening for keys
		panel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				panel.requestFocusInWindow();
			}
		});
		
		// I'd prefer the text box not have focus immediately.  This will
		// make it so that the panel gets focus at the beginning.
		panel.addHierarchyListener(new HierarchyListener() {
			@Override
			public void hierarchyChanged(HierarchyEvent arg0) {
				panel.requestFocusInWindow();
			}
		});
	}
	
	public JPanel getDisplayComponent() {
		return panel;
	}
	
	@Override
	public void updateFromModel() {
		timerLabel.setText(model.getTimeDisplayString());
	}
	
}
