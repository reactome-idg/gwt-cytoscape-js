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
	 String name;
	 
	 public NodeHoveredEvent(String nodeId, String name) {
		 this.nodeId = nodeId;
		 this.name = name;
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
	
    @Override
    public String toString() {
        return "NodeHoveredEvent{" +
                "content=" + getNodeId() + "}";
    }

}
