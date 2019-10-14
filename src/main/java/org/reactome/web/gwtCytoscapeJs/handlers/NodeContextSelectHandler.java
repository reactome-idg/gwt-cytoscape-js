package org.reactome.web.gwtCytoscapeJs.handlers;

import org.reactome.web.gwtCytoscapeJs.events.NodeContextSelectEvent;

import com.google.gwt.event.shared.EventHandler;

public interface NodeContextSelectHandler extends EventHandler {
	void onNodeContextSelect(NodeContextSelectEvent event);
}
