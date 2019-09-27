package org.reactome.web.gwtCytoscapeJs.handlers;

import org.reactome.web.gwtCytoscapeJs.events.EdgeMouseOutEvent;

import com.google.gwt.event.shared.EventHandler;

public interface EdgeMouseOutHandler extends EventHandler{
	void onEdgeMouseOut(EdgeMouseOutEvent event);
}
