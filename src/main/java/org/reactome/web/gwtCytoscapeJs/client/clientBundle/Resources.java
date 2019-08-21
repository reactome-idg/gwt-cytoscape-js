package org.reactome.web.gwtCytoscapeJs.client.clientBundle;

import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.TextResource;

/**
 * 
 * @author brunsont
 *
 */

public interface Resources extends ClientBundle{
	public static final Resources INSTANCE = GWT.create(Resources.class);
	
	@Source("cytoscape-style.json")
	public TextResource cytoscapeStyle();
	
}
