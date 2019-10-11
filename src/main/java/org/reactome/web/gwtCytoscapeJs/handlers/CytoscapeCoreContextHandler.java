package org.reactome.web.gwtCytoscapeJs.handlers;

import org.reactome.web.gwtCytoscapeJs.events.CytoscapeCoreContextEvent;

import com.google.gwt.event.shared.EventHandler;

/**
 * 
 * @author brunsont
 *
 */
public interface CytoscapeCoreContextHandler extends EventHandler{
	void onCytoscapeContextSelect(CytoscapeCoreContextEvent event);
}
