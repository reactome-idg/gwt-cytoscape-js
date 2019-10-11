package org.reactome.web.gwtCytoscapeJs.events;

import org.reactome.web.gwtCytoscapeJs.handlers.CytoscapeCoreContextHandler;

import com.google.gwt.event.shared.GwtEvent;

/**
 * 
 * @author brunsont
 *
 */
public class CytoscapeCoreContextEvent extends GwtEvent<CytoscapeCoreContextHandler> {
    public static Type<CytoscapeCoreContextHandler> TYPE = new Type<>();

    private int x;
	private int y;
    
    public CytoscapeCoreContextEvent(int x, int y) {
    	this.x = x;
    	this.y = y;
    }
    
	@Override
	public Type<CytoscapeCoreContextHandler> getAssociatedType() {
		return TYPE;
	}

	@Override
	protected void dispatch(CytoscapeCoreContextHandler handler) {
		handler.onCytoscapeContextSelect(this);
	}
	
	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}
	
	@Override
	public String toString() {
		return "cytoscape core context event";
	}

}
