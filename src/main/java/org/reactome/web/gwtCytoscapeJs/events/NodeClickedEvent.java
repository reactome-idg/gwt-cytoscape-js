package org.reactome.web.gwtCytoscapeJs.events;

import org.reactome.web.gwtCytoscapeJs.handlers.NodeClickedHandler;

import com.google.gwt.event.shared.GwtEvent;

public class NodeClickedEvent extends GwtEvent<NodeClickedHandler>{
    public static Type<NodeClickedHandler> TYPE = new Type<>();

    private String nodeAccession;

    public NodeClickedEvent(String nodeAccession) {
        this.nodeAccession = nodeAccession;
    }
    
	@Override
	public Type<NodeClickedHandler> getAssociatedType() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected void dispatch(NodeClickedHandler handler) {
		handler.onNodeClicked(this);
		
	}
	
	public String getNodeAccession() {
		return nodeAccession;
	}
	
    @Override
    public String toString() {
        return "GraphLoadedEvent{" +
                " content= " + getNodeAccession() 
                + " "
                + '}';
    }

}
