package org.reactome.web.gwtCytoscapeJs.events;

import org.reactome.web.gwtCytoscapeJs.handlers.EdgeHoveredHandler;

import com.google.gwt.event.shared.GwtEvent;

public class EdgeHoveredEvent extends GwtEvent<EdgeHoveredHandler>{
    public static Type<EdgeHoveredHandler> TYPE = new Type<>();

    private String edgeId;
    private int x;
    private int y;
    
    public EdgeHoveredEvent(String edgeId, int x, int y) {
    	this.edgeId = edgeId;
    	this.x = x;
    	this.y = y;
    }
    
	@Override
	public Type<EdgeHoveredHandler> getAssociatedType() {
		return TYPE;
	}

	@Override
	protected void dispatch(EdgeHoveredHandler handler) {
		handler.onEdgeHovered(this);
	}
	
	public String getEdgeId() {
		return edgeId;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}
}
