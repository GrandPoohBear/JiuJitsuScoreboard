package com.gpb.jjscoreboard.model;

import java.util.Set;

import com.google.common.collect.Sets;

public class BroadcastingModel {
	private final Set<ModelListener> listeners = Sets.newHashSet();
	
	public void addModelListener(ModelListener ml) {
		listeners.add(ml);
	}
	
	public void removeModelListener(ModelListener ml) {
		listeners.remove(ml);
	}
	
	protected void broadcastModelChange() {
		for (ModelListener ml : listeners) {
			ml.updateFromModel();
		}
	}
}
