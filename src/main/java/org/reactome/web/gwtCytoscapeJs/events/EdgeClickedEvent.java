package org.reactome.web.gwtCytoscapeJs.events;

import org.reactome.web.gwtCytoscapeJs.handlers.EdgeClickedHandler;

import com.google.gwt.event.shared.GwtEvent;

/**
 * 
 * @author brunsont
 *
 */
public class EdgeClickedEvent extends GwtEvent<EdgeClickedHandler>{
    public static Type<EdgeClickedHandler> TYPE = new Type<>();

    private String edgeId;
    
	public EdgeClickedEvent(String edgeId) {
		this.edgeId = edgeId;
	}
    
	@Override
	public Type<EdgeClickedHandler> getAssociatedType() {
		return TYPE;
	}

	@Override
	protected void dispatch(EdgeClickedHandler handler) {
		handler.onEdgeClicked(this);
	}
	
	public String getEdgeId() {
		return edgeId;
	}
	
	@Override
	public String toString() {
		return "EdgeClickedEvent{" +
                "content=" + getEdgeId() + "}";
	}

}
