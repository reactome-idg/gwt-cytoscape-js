package org.reactome.web.gwtCytoscapeJs.handlers;

import org.reactome.web.gwtCytoscapeJs.events.NodeHoveredEvent;

import com.google.gwt.event.shared.EventHandler;

/**
 * 
 * @author brunsont
 *
 */
public interface NodeHoveredHandler extends EventHandler {
	void onNodeHovered(NodeHoveredEvent event);

}
