package org.reactome.web.gwtCytoscapeJs.client;

import org.reactome.web.gwtCytoscapeJs.events.EdgeClickedEvent;
import org.reactome.web.gwtCytoscapeJs.events.NodeClickedEvent;
import org.reactome.web.gwtCytoscapeJs.util.Console;

import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.Window;

/**
 * 
 * @author brunsont
 *
 */
public class CytoscapeWrapper {
	
	EventBus eventBus;
	
	public CytoscapeWrapper(EventBus eventBus) {
		this.eventBus = eventBus;
	}
	
	/**
	 * generic class for testing
	 */
	public native void cytoscapeInit(String style) /*-{
		var obj = new $wnd.Object();
		
		var styleJSON = $wnd.JSON.parse(style);
		
	    obj.container = $doc.getElementById('cy');
	    obj.elements = $wnd.glyElements;
	    obj.style = styleJSON;
	    obj.layout = { name: 'cose'};
	    var cy = $wnd.cy = $wnd.cytoscape(obj);
	    
	    //setup link node and edge selectors
	    this.@org.reactome.web.gwtCytoscapeJs.client.CytoscapeWrapper::nodeSelected(*)();
	    this.@org.reactome.web.gwtCytoscapeJs.client.CytoscapeWrapper::edgeSelected(*)();
	    
	}-*/;

	/**
	 * JSNI to display cytoscape given a JSON string of nodes, edges, style, and layout
	 * @param nodes
	 * @param edges
	 * @param style
	 * @param layout
	 */
	public native void cytoscapeInit(String nodes, String edges, String style, String layout) /*-{
		
		//create object to pass into cytoscape.js library.
		var obj = new $wnd.Object();
		
		var nodes = $wnd.JSON.parse(nodes);
		var edges = $wnd.JSON.parse(edges);
		var styleJSON = $wnd.JSON.parse(style);
		
	    obj.container = $doc.getElementById('cy');
	    obj.elements = nodes;
	    obj.style = styleJSON;
	    obj.layout = { name: layout};
	    var cy = $wnd.cy = $wnd.cytoscape(obj);
	    cy.add(edges);
	    
	   	//setup link node and edge selectors
	    this.@org.reactome.web.gwtCytoscapeJs.client.CytoscapeWrapper::nodeSelected(*)();
	    this.@org.reactome.web.gwtCytoscapeJs.client.CytoscapeWrapper::edgeSelected(*)();
	}-*/;
	
	/**
	 * adds a node to cytoscape
	 * @param node
	 */
	public native void addCytoscapeNodes(String nodes) /*-{
	console.log(nodes);
	//convert incoming string to node format
	var nodes = $wnd.JSON.parse(nodes);
	
	//add node to cytoscape
	$wnd.cy.add(nodes);
	
	this.@org.reactome.web.gwtCytoscapeJs.client.CytoscapeWrapper::nodeSelected(*)();
	this.@org.reactome.web.gwtCytoscapeJs.client.CytoscapeWrapper::edgeSelected(*)();
	
	}-*/;
	
	/**
	 * removes node of Id specified by passed in node Id as a string.
	 * @param node
	 */
	public native void removeCytoscapeNode(String node) /*-{
		var node = $wnd.cy.$('#'+node);
		$wnd.cy.remove(node);
	}-*/;
	
	/**
	 * adds an edge to Cytoscape.js
	 * @param edge
	 */
	public native void addCytoscapeEdge(String edges) /*-{
	
	//convert incoming string to node format
	var edges = $wnd.edges = $wnd.JSON.parse(edges);
	
	//add node to cytoscape
	$wnd.cy.add(edges);
	
	this.@org.reactome.web.gwtCytoscapeJs.client.CytoscapeWrapper::nodeSelected(*)();
	this.@org.reactome.web.gwtCytoscapeJs.client.CytoscapeWrapper::edgeSelected(*)();
	
	}-*/;
	
	/**
	 * Clears all edges and nodes from Cytoscape.js graph. Nodes and edges are stored in memory by Cytoscape.js for reuse.
	 */
	public native void clearCytoscapeGraph() /*-{
		$wnd.cy.elements('edge').remove();
		$wnd.cy.elements('node').remove();
	}-*/;
	
	/**
	 * call to reset view of Cytoscape.js to position (0,0) and zoom 1
	 */
	public native void resetCytoscapeView() /*-{
		$wnd.cy.reset();
	}-*/;
	
	/**
	 * fits overall Cytoscape.Js display to size of viewport
	 */
	public native void fitCytoscape() /*-{
		$wnd.cy.fit();
	}-*/;
	
	/**
	 * call to adjust zoom of Cytoscape.js viewport. Zoom must be a positive integer
	 * reset by passing in int zoom = 1;
	 * @param zoom
	 */
	public native void zoomCytoscape(int zoom) /*-{
		$wnd.cy.zoom(zoom);
	}-*/;
	
	/**
	 * pan methods will pan in a given direction specified by an int of pixels.
	 * @param px
	 */
	public native void panUp(int px) /*-{
		$wnd.cy.panBy({x:0, y:px});
	}-*/;
	public native void panDown(int px) /*-{
		$wnd.cy.panBy({x:0, y:(1-px)});
	}-*/;
	public native void panLeft(int px) /*-{
		$wnd.cy.panBy({x:(1-px), y:0});
	}-*/;
	public native void panRight(int px) /*-{
		$wnd.cy.panBy({x:px, y:0});
	}-*/;
	
	/**
	 * centers Cytoscape.js viewpoint but does not adjust zoom
	 */
	public native void centerCytoscape() /*-{
		$wnd.cy.center();
	}-*/;
	
	/**
	 * center viewport around node corresponding to protein accession passed in as string
	 * @param node
	 */
	public native void centerCytoscapeonNode(String node) /*-{
		$wnd.cy.center($wnd.cy.$('#'+node));
	}-*/;
	
	public native void highlightSelectedEdgeGroup(String node, String baseStyle) /*-{
		var styleJSON = $wnd.JSON.parse(baseStyle);
		$wnd.cy.style().fromJson(styleJSON).update();
		$wnd.cy.style().selector('edge[target = "'+node+'"], edge[source="'+node+'"]').style({'line-color': 'red'}).update();
	}-*/;
	
	/**
	 * Fires NodeClickedEvent with id of node selected.
	 */
	private native void nodeSelected() /*-{
		var that = this;
		$wnd.cy.elements('node').on('tap', function(evt){
			that.@org.reactome.web.gwtCytoscapeJs.client.CytoscapeWrapper::fireNodeClickedEvent(*)(evt.target.id());
		});
	}-*/;
	
	/**
	 * Fires EdgeClickedEvent with id of edge selected.
	 */
	private native void edgeSelected() /*-{
		var that = this;
		$wnd.cy.elements('edge').on('tap', function(evt){
			that.@org.reactome.web.gwtCytoscapeJs.client.CytoscapeWrapper::fireEdgeClickedEvent(*)(evt.target.id());
		});
	}-*/;
	
	/**
	 * Called by JSNI to fire node clicked event
	 * @param node
	 */ 
	private void fireNodeClickedEvent(String node) { 
		eventBus.fireEventFromSource(new NodeClickedEvent(node), this);
	}
	
	/**
	 * Called by JSNI to fire edge clicked event
	 * @param edge
	 */
	private void fireEdgeClickedEvent(String edge) {
		eventBus.fireEventFromSource(new EdgeClickedEvent(edge), this);
	}
	
}
