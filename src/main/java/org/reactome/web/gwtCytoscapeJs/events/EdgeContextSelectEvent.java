package org.reactome.web.gwtCytoscapeJs.events;

import org.reactome.web.gwtCytoscapeJs.handlers.EdgeContextSelectHandler;

import com.google.gwt.event.shared.GwtEvent;

public class EdgeContextSelectEvent extends GwtEvent<EdgeContextSelectHandler> {
    public static Type<EdgeContextSelectHandler> TYPE = new Type<>();

    private String id;
    private int x;
    private int y;
    
    public EdgeContextSelectEvent(String id, int x, int y) {
    	this.id = id;
    	this.x = x;
    	this.y = y;
    }
    
	public String getId() {
		return id;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	@Override
	public Type<EdgeContextSelectHandler> getAssociatedType() {
		return TYPE;
	}

	@Override
	protected void dispatch(EdgeContextSelectHandler handler) {
		handler.onEdgeContextSelect(this);
	}
	
	@Override
	public String toString() {
		return "Edge context selected for edge with id: " + getId();
	}

}
