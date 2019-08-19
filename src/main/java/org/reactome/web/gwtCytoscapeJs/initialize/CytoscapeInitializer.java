package org.reactome.web.gwtCytoscapeJs.initialize;

public class CytoscapeInitializer {

	/**
	 * generic class for testing
	 */
	public static native void cytoscapeInit() /*-{
		var obj = new $wnd.Object();
		console.log($wnd.glyElements);
	    obj.container = $doc.getElementById('cy');
	    obj.elements = $wnd.glyElements;
	    obj.style = [ { selector: 'node', style: { 'background-color': '#666', 'label': 'data(id)' } }, 
	            { selector: 'edge', style: { 'width': 3, 'line-color': '#ccc', 'target-arrow-color': '#ccc',
					'target-arrow-shape': 'triangle' } } ];
	    obj.layout = { name: 'random'};
	    var cy = $wnd.cy = $wnd.cytoscape(obj);
	}-*/;

	/**
	 * JSNI to display cytoscape given a JSON string of nodes, edges, and style
	 * @param nodes
	 * @param edges
	 * @param style
	 */
	public native void cytoscapeInit(String nodes, String edges, String style) /*-{
		
		//create object to pass into cytoscape.js library.
		var obj = new $wnd.Object();
		
		var nodes = $wnd.nodes = $wnd.JSON.parse(nodes);
		var edges = $wnd.edges = $wnd.JSON.parse(edges);
		var styleJSON = $wnd.styleJSON = $wnd.JSON.parse(style);
		
	    obj.container = $doc.getElementById('cy');
	    obj.elements = $wnd.nodes;
	    obj.style = $wnd.styleJSON;
	    obj.layout = { name: 'cose'};
	    var cy = $wnd.cy = $wnd.cytoscape(obj);
	    cy.add(edges);
	}-*/;
	
}
