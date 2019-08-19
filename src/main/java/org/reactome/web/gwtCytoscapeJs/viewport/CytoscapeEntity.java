package org.reactome.web.gwtCytoscapeJs.viewport;

/**
 * 
 * @author brunsont
 *
 */
public class CytoscapeEntity {

	/**
	 * generic class for testing
	 */
	public native void cytoscapeInit() /*-{
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
	
	/**
	 * adds a node to cytoscape
	 * @param node
	 */
	public native void addCytoscapeNodes(String nodes) /*-{
	
	//convert incoming string to node format
	var nodes = $wnd.nodes = $wnd.JSON.parse(nodes);
	
	//add node to cytoscape
	$wnd.cy.add(nodes);
	
	}-*/;
	
	/**
	 * removes node of Id specified by passed in node Id as a string.
	 * @param node
	 */
	public native void removeCytoscapeNode(String node) /*-{
		var node = cy.$('#'+node);
		$wnd.cy.remove(node);
	}-*/;
	
	/**
	 * adds an edge to cytoscape
	 * @param edge
	 */
	public native void addCytoscapeEdge(String edges) /*-{
	
	//convert incoming string to node format
	var edges = $wnd.edges = $wnd.JSON.parse(edges);
	
	//add node to cytoscape
	$wnd.cy.add(edges);
	
	}-*/;
	
	public native void clearCytoscapeGraph() /*-{
		$wnd.cy.$('edge').remove();
		$wnd.cy.$('node').remove();
	}-*/;
	
	/**
	 * call to reset view of cytoscape to position (0,0) and zoom 1
	 */
	public native void resetCytoscapeView() /*-{
		$wnd.cy.reset();
	}-*/;
	
	/**
	 * fits overall cytoscape display to size of viewport
	 */
	public native void fitCytoscape() /*-{
		$wnd.cy.fit();
	}-*/;
	
	/**
	 * call to adjust zoom of cytoscape viewport. Zoom must be a positive integer
	 * reset by passing in int zoom = 1;
	 * @param zoom
	 */
	public native void zoomCytoscape(int zoom) /*-{
		$wnd.cy.zoom(zoom);
	}-*/;
	
	/**
	 * centers cytoscape viewpoint but does not adjust zoom
	 */
	public native void centerCytoscape() /*-{
		$wnd.cy.center();
	}-*/;
	
	/**
	 * center viewport around node corresponding to protein accession passed in as string
	 * @param node
	 */
	public native void centerCytoscapeonNode(String node) /*-{
		$wnd.cy.center(cy.elements('node[name = "'+node+'"]'));
	}-*/;
	
	/**
	 * console.logs id of selected node. Override to provide access to GWT Java class.
	 */
	public native  void nodeSelected() /*-{
		$wnd.cy.$('node').on('tap', function(evt){
			console.log('node selected: ' + evt.target.id());
			//@org.reactome.web.gwtCytoscapeJs.client.TestGWTCytoscapeJs::selected(*)(evt.target.id());
		});
	}-*/;
	
	/**
	 * console.logs id of selected edge. Override to provide access to GWT Java class.
	 */
	public native void edgeSelected() /*-{
		$wnd.cy.$('edge').on('tap', function(evt){
			console.log('edge selected: ' + evt.target.id());
		});
	}-*/;
}
