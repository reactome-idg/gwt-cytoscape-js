package org.reactome.web.gwtCytoscapeJs.events;

import org.reactome.web.gwtCytoscapeJs.handlers.EdgeHoveredHandler;

import com.google.gwt.event.shared.GwtEvent;

public class EdgeHoveredEvent extends GwtEvent<EdgeHoveredHandler>{
    public static Type<EdgeHoveredHandler> TYPE = new Type<>();

	@Override
	public Type<EdgeHoveredHandler> getAssociatedType() {
		return TYPE;
	}

	@Override
	protected void dispatch(EdgeHoveredHandler handler) {
		handler.onEdgeHovered(this);
	}

}
