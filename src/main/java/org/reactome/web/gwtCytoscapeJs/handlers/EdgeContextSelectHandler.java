package org.reactome.web.gwtCytoscapeJs.handlers;

import com.google.gwt.event.shared.EventHandler;

import org.reactome.web.gwtCytoscapeJs.events.EdgeContextSelectEvent;

public interface EdgeContextSelectHandler extends EventHandler{
	void onEdgeContextSelect(EdgeContextSelectEvent event);
}
