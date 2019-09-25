package org.reactome.web.gwtCytoscapeJs.events;

import org.reactome.web.gwtCytoscapeJs.handlers.NodeClickedHandler;

import com.google.gwt.event.shared.GwtEvent;
import com.google.gwt.user.client.Window;

/**
 * @author brunsont
 */
public class NodeClickedEvent extends GwtEvent<NodeClickedHandler>{
    public static Type<NodeClickedHandler> TYPE = new Type<>();

    private String nodeId;
    private String xCoordinate;
    private String yCoordinate;

    public NodeClickedEvent(String nodeId, String xCoordinate, String yCoordinate) {
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
	
	public String getNodeId() {
		return nodeId;
	}

	@Override
	public Type<NodeClickedHandler> getAssociatedType() {
		return TYPE;
	}

	@Override
	protected void dispatch(NodeClickedHandler handler) {
		handler.onNodeClicked(this);
		
	}
	
    @Override
    public String toString() {
        return "NodeClickedEvent{" +
                "content=" + getNodeId() + "}";
    }

}
