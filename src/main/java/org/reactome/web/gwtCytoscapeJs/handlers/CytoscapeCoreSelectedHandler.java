package org.reactome.web.gwtCytoscapeJs.handlers;

import org.reactome.web.gwtCytoscapeJs.events.CytoscapeCoreSelectedEvent;

import com.google.gwt.event.shared.EventHandler;

/**
 * 
 * @author brunsont
 *
 */
public interface CytoscapeCoreSelectedHandler extends EventHandler{
	void onCytoscapeCoreSelected(CytoscapeCoreSelectedEvent event);
}
