package org.reactome.web.gwtCytoscapeJs.handlers;

import org.reactome.web.gwtCytoscapeJs.events.EdgeClickedEvent;

import com.google.gwt.event.shared.EventHandler;

/**
 * 
 * @author brunsont
 *
 */
public interface EdgeClickedHandler extends EventHandler{
	void onEdgeClicked(EdgeClickedEvent event);
}
