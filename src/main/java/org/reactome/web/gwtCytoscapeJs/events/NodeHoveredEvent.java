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
	 
	 String nodeId;
	 String xCoordinate;
	 String yCoordinate;
	 
	 public NodeHoveredEvent(String nodeId, String xCoordinate, String yCoordinate) {
		 this.nodeId = nodeId;
		 this.xCoordinate = xCoordinate;
		 this.yCoordinate = yCoordinate;
	 }
	 
	public String getxCoordinate() {
		return xCoordinate;
	}

	public String getyCoordinate() {
		return yCoordinate;
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
	
    @Override
    public String toString() {
        return "NodeHoveredEvent{" +
                "content=" + getNodeId() + "}";
    }

}
