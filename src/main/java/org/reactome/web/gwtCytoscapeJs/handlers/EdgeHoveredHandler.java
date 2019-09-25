package org.reactome.web.gwtCytoscapeJs.handlers;

import org.reactome.web.gwtCytoscapeJs.events.EdgeHoveredEvent;

import com.google.gwt.event.shared.EventHandler;


public interface EdgeHoveredHandler extends EventHandler{
	void onEdgeHovered(EdgeHoveredEvent event);
}
