package org.reactome.web.gwtCytoscapeJs.handlers;

import org.reactome.web.gwtCytoscapeJs.events.NodeMouseOutEvent;

import com.google.gwt.event.shared.EventHandler;

public interface NodeMouseOutHandler extends EventHandler{
	void onMouseOut(NodeMouseOutEvent event);
}
