package org.reactome.web.gwtCytoscapeJs.events;

import org.reactome.web.gwtCytoscapeJs.handlers.CytoscapeCoreSelectedHandler;

import com.google.gwt.event.shared.GwtEvent;

/**
 * 
 * @author brunsont
 *
 */
public class CytoscapeCoreSelectedEvent extends GwtEvent<CytoscapeCoreSelectedHandler> {
    public static Type<CytoscapeCoreSelectedHandler> TYPE = new Type<>();

	@Override
	public Type<CytoscapeCoreSelectedHandler> getAssociatedType() {
		return TYPE;
	}

	@Override
	protected void dispatch(CytoscapeCoreSelectedHandler handler) {
		handler.onCytoscapeCoreSelected(this);
	}
	
	@Override
	public String toString() {
		return "cytoscape core selected";
	}

}
