package org.reactome.web.gwtCytoscapeJs.events;

import org.reactome.web.gwtCytoscapeJs.handlers.NodeHoveredHandler;

import com.google.gwt.event.shared.GwtEvent;

/**
 * 
 * @author brunsont
 *
 */
public class NodeHoveredEvent extends GwtEvent<NodeHoveredHandler>{
	 public static Type<NodeHoveredHandler> TYPE = new Type<>();
	 
	 private String nodeId;
	 private String name;
	 private int x;
	 private int y;
	 
	 public NodeHoveredEvent(String nodeId, String name, int x, int y) {
		 this.nodeId = nodeId;
		 this.name = name;
		 this.x = x;
		 this.y = y;
	 }

	@Override
	public Type<NodeHoveredHandler> getAssociatedType() {
		return TYPE;
	}
	
	@Override
	protected void dispatch(NodeHoveredHandler handler) {
		handler.onNodeHovered(this);	
	}
	
	public String getNodeId() {
		return nodeId;
	}
	
	public String getName() {
		return name;
	}
	
    public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	@Override
    public String toString() {
        return "NodeHoveredEvent{" +
                "content=" + getNodeId() + "}";
    }
}