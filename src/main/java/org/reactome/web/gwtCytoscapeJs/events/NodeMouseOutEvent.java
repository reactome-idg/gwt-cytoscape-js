package org.reactome.web.gwtCytoscapeJs.events;

import org.reactome.web.gwtCytoscapeJs.handlers.NodeMouseOutHandler;

import com.google.gwt.event.shared.GwtEvent;

public class NodeMouseOutEvent extends GwtEvent<NodeMouseOutHandler>{
	 public static Type<NodeMouseOutHandler> TYPE = new Type<>();

	@Override
	public Type<NodeMouseOutHandler> getAssociatedType() {
		return TYPE;
	}

	@Override
	protected void dispatch(NodeMouseOutHandler handler) {
		handler.onMouseOut(this);
	}

    @Override
    public String toString() {
        return "NodeMouseOutEvent fired!";
    }
	
}
