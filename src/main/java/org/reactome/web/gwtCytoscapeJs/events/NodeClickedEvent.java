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
    private String name;

    public NodeClickedEvent(String nodeId, String name) {
        this.nodeId = nodeId;
        this.name = name;
    }
	
	public String getNodeId() {
		return nodeId;
	}
	public String getName() {
		return name;
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
