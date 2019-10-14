package org.reactome.web.gwtCytoscapeJs.events;

import org.reactome.web.gwtCytoscapeJs.handlers.NodeContextSelectHandler;

import com.google.gwt.event.shared.GwtEvent;

public class NodeContextSelectEvent extends GwtEvent<NodeContextSelectHandler> {
    public static Type<NodeContextSelectHandler> TYPE = new Type<>();

	
	private String name;
	private String id;
	private int x;
	private int y;
	
	public NodeContextSelectEvent(String id, String name, int x, int y) {
		this.name = name;
		this.id = id;
		this.x = x;
		this.y = y;
	}
	
	@Override
	public Type<NodeContextSelectHandler> getAssociatedType() {
		return TYPE;
	}

	@Override
	protected void dispatch(NodeContextSelectHandler handler) {
		handler.onNodeContextSelect(this);
	}

	public String getName() {
		return name;
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
	public String toString() {
		return "Node with Id: "
				+ getId() + "right clicked.";
	}
}
