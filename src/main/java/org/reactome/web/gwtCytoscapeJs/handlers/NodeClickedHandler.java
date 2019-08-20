package org.reactome.web.gwtCytoscapeJs.handlers;

import org.reactome.web.gwtCytoscapeJs.events.NodeClickedEvent;

import com.google.gwt.event.shared.EventHandler;

/**
 * @author brunsont
 */
public interface NodeClickedHandler extends EventHandler {
	void onNodeClicked(NodeClickedEvent event);

}
