package com.gpb.jjscoreboard.view;

import java.io.IOException;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

import com.gpb.jjscoreboard.JJSConstants;
import com.gpb.jjscoreboard.model.MatchModel;
import com.gpb.jjscoreboard.model.ModelListener;

public class Buzzer implements ModelListener, JJSConstants {
	private final MatchModel model;
	private final Clip buzzClip;
	
	public Buzzer(MatchModel model) throws LineUnavailableException, UnsupportedAudioFileException, IOException {
		this.model = model;
		
		buzzClip = AudioSystem.getClip();
		AudioInputStream audioInStream = 
			AudioSystem.getAudioInputStream(
					Buzzer.class.getResourceAsStream(BUZZ_RESOURCE_PATH));
		buzzClip.open(audioInStream);
		
		//If we got this far, then we can add the buzzer as a listener
		this.model.addModelListener(this);
	}
	
	@Override
	public void updateFromModel() {
		if (model.isBuzzPending()) {
			//Need to stop the clip explicitly or it won't replay the second time around
			buzzClip.stop();
			buzzClip.start();
			
			model.clearBuzzPending();
		}
	}
	
}
