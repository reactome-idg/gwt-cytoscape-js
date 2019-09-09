package org.reactome.web.gwtCytoscapeJs.client;

import org.reactome.web.gwtCytoscapeJs.events.EdgeClickedEvent;
import org.reactome.web.gwtCytoscapeJs.events.NodeClickedEvent;
import org.reactome.web.gwtCytoscapeJs.events.NodeHoveredEvent;
import org.reactome.web.gwtCytoscapeJs.events.NodeMouseOutEvent;

import com.google.gwt.event.shared.EventBus;

/**
 * 
 * @author brunsont
 *
 */
public class CytoscapeWrapper {
	
	private EventBus eventBus;
	
	public CytoscapeWrapper(EventBus eventBus) {
		this.eventBus = eventBus;
	}
	
	/**
	 * generic class for testing
	 */
	public native void cytoscapeInit(String style) /*-{
		var obj = new $wnd.Object();
		var zoom = $doc.zoom = 1;
		
		var styleJSON = $wnd.JSON.parse(style);
		
	    obj.container = $doc.getElementById('cy');
	    obj.elements = $wnd.glyElements;
	    obj.style = styleJSON;
	    obj.layout = { name: 'cose'};
	    var cy = $wnd.cy = $wnd.cytoscape(obj);
	    
	    //setup link node and edge selectors
	    this.@org.reactome.web.gwtCytoscapeJs.client.CytoscapeWrapper::nodeSelected(*)();
	    this.@org.reactome.web.gwtCytoscapeJs.client.CytoscapeWrapper::edgeSelected(*)();
	    this.@org.reactome.web.gwtCytoscapeJs.client.CytoscapeWrapper::nodeHovered(*)();
	    this.@org.reactome.web.gwtCytoscapeJs.client.CytoscapeWrapper::edgeHovered(*)();
	    
	   	$wnd.cy.zoom(zoom);
	    
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
		var zoom = $doc.zoom = 1;
		
		
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
	   	this.@org.reactome.web.gwtCytoscapeJs.client.CytoscapeWrapper::nodeHovered(*)();
	   	this.@org.reactome.web.gwtCytoscapeJs.client.CytoscapeWrapper::edgeHovered(*)();
	   	
	   	$wnd.cy.zoom(zoom);
	   	
	   	
	    
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
	this.@org.reactome.web.gwtCytoscapeJs.client.CytoscapeWrapper::nodeHovered(*)();
	this.@org.reactome.web.gwtCytoscapeJs.client.CytoscapeWrapper::edgeHovered(*)();
	
	
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
	this.@org.reactome.web.gwtCytoscapeJs.client.CytoscapeWrapper::nodeHovered(*)();
	this.@org.reactome.web.gwtCytoscapeJs.client.CytoscapeWrapper::edgeHovered(*)();
	
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
	public native void zoomCytoscape(int zoomBy) /*-{
		if($doc.zoom == 1 && zoomBy == -1){
			$doc.zoom = 1;
			$wnd.cy.zoom($doc.zoom);
		} else if(zoomBy == -1){
			$doc.zoom--;
			$wnd.cy.zoom($doc.zoom);
		} else if(zoomBy == 1){
			$doc.zoom++;
			$wnd.cy.zoom($doc.zoom);
		}
		
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
	
	/**
	 * Higlights edges connected to a selected node
	 * @param node
	 * @param baseStyle
	 */
	public native void highlightSelectedEdgeGroup(String node, String baseStyle) /*-{
		var styleJSON = $wnd.JSON.parse(baseStyle);
		$wnd.cy.style().fromJson(styleJSON).update();
		$wnd.cy.style().selector('edge[target = "'+node+'"], edge[source="'+node+'"]').style({'line-color': 'red'}).update();
	}-*/;
	
	/**
	 * Fires NodeClickedEvent with id of node selected.
	 */
	protected native void nodeSelected() /*-{
		var that = this;
		$wnd.cy.elements('node').on('tap', function(evt){
			var node = evt.target;
			var x = node.position().x + '';
			var y = node.position().y + '';
			that.@org.reactome.web.gwtCytoscapeJs.client.CytoscapeWrapper::fireNodeClickedEvent(*)(evt.target.id(), x, y);
		});
	}-*/;
	
	/**
	 * Fires EdgeClickedEvent with id of edge selected.
	 */
	protected native void edgeSelected() /*-{
		var that = this;
		$wnd.cy.elements('edge').on('tap', function(evt){
			that.@org.reactome.web.gwtCytoscapeJs.client.CytoscapeWrapper::fireEdgeClickedEvent(*)(evt.target.id());
		});
	}-*/;
	
	/**
	 * Fires NodeHoveredEvent with id of node hovered on.
	 */
	protected native void nodeHovered() /*-{
		var that = this;
		$wnd.cy.elements('node').on('mouseover', function(evt){
			var node = evt.target;
			var x = node.position().x + '';
			var y = node.position().y + '';
			that.@org.reactome.web.gwtCytoscapeJs.client.CytoscapeWrapper::fireNodeHoveredEvent(*)(evt.target.id(), x, y);
		});
		$wnd.cy.elements('node').on('mouseout', function(evt){
			that.@org.reactome.web.gwtCytoscapeJs.client.CytoscapeWrapper::fireNodeMouseOutEvent(*)();
		});
	}-*/;
	
	/**
	 * sets layout equal to passed in string.
	 * String options include: "random", "grid", "circle", "concentric", "breadthfirst", and "cose".
	 * The layout, "preset" can also be used if node locations are specified manually.
	 * @param layoutString
	 */
	protected native void setLayout(String layoutString) /*-{
		var layout = $wnd.cy.layout({name: '' + layoutString + ''});
		layout.run();
	}-*/;
	
	/**
	 * This method resets the style of the Cytoscape.js canvas. 
	 * Pass in the JSON of the desired style as a string.
	 * @param BaseStyle
	 */
	protected native void setStyle(String BaseStyle) /*-{
		var styleJSON = $wnd.JSON.parse(baseStyle);
		$wnd.cy.style().fromJson(styleJSON).update();
	}-*/;
	
	
	/**
	 * Fires node hovered event
	 */
	protected native void edgeHovered() /*-{}-*/;
	
	/**
	 * Called by JSNI to fire node clicked event
	 * @param node
	 */ 
	private void fireNodeClickedEvent(String node, String x, String y) { 
		eventBus.fireEventFromSource(new NodeClickedEvent(node, x, y), this);
	}
	
	/**
	 * Called by JSNI to fire edge clicked event
	 * @param edge
	 */
	private void fireEdgeClickedEvent(String edge) {
		eventBus.fireEventFromSource(new EdgeClickedEvent(edge), this);
	}
	
	/**
	 * Called by JSNI to fire node hovered event
	 * @param node
	 */
	private void fireNodeHoveredEvent(String node, String x, String y) {
		eventBus.fireEventFromSource(new NodeHoveredEvent(node, x, y), this);
	}
	
	/**
	 * Called when mouse leaves a node area
	 */
	private void fireNodeMouseOutEvent() {
		eventBus.fireEventFromSource(new NodeMouseOutEvent(), this);
	}
	
}
