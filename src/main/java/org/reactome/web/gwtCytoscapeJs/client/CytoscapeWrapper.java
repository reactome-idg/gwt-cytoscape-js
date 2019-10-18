package org.reactome.web.gwtCytoscapeJs.client;

import org.reactome.web.gwtCytoscapeJs.events.CytoscapeCoreContextEvent;
import org.reactome.web.gwtCytoscapeJs.events.CytoscapeCoreSelectedEvent;
import org.reactome.web.gwtCytoscapeJs.events.EdgeClickedEvent;
import org.reactome.web.gwtCytoscapeJs.events.EdgeContextSelectEvent;
import org.reactome.web.gwtCytoscapeJs.events.EdgeHoveredEvent;
import org.reactome.web.gwtCytoscapeJs.events.EdgeMouseOutEvent;
import org.reactome.web.gwtCytoscapeJs.events.NodeClickedEvent;
import org.reactome.web.gwtCytoscapeJs.events.NodeContextSelectEvent;
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
	private String style;
	
	public CytoscapeWrapper(EventBus eventBus, String style) {
		this.eventBus = eventBus;
		this.style = style;
	}
	
	/**
	 * generic class for testing
	 */
	public native void cytoscapeInit() /*-{
		var obj = new $wnd.Object();
		var zoom = $doc.zoom = 1;
		
		var styleJSON = $wnd.JSON.parse(this.@org.reactome.web.gwtCytoscapeJs.client.CytoscapeWrapper::style);
		
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
	    this.@org.reactome.web.gwtCytoscapeJs.client.CytoscapeWrapper::cytoscapeCoreContextSelected(*)();
	    
	   	$wnd.cy.zoom(zoom);
	    
	}-*/;

	/**
	 * JSNI to display cytoscape given a JSON string of nodes, edges, style, and layout
	 * @param nodes
	 * @param edges
	 * @param style
	 * @param layout
	 */
	public native void cytoscapeInit(String nodes, String edges, String layout) /*-{
		
		//create object to pass into cytoscape.js library.
		var obj = new $wnd.Object();
		var zoom = $doc.zoom = 1;
		
		
		var nodes = $wnd.JSON.parse(nodes);
		var edges = $wnd.JSON.parse(edges);
		var styleJSON = $wnd.JSON.parse(this.@org.reactome.web.gwtCytoscapeJs.client.CytoscapeWrapper::style);
		
	    obj.container = $doc.getElementById('cy');
	    obj.elements = nodes;
	    obj.style = styleJSON;
	    obj.layout = { name: ''+layout+''};
	    var cy = $wnd.cy = $wnd.cytoscape(obj);
	    cy.add(edges);	    
	    
	   	//setup link node and edge selectors
	    this.@org.reactome.web.gwtCytoscapeJs.client.CytoscapeWrapper::nodeSelected(*)();
	    this.@org.reactome.web.gwtCytoscapeJs.client.CytoscapeWrapper::edgeSelected(*)();
	   	this.@org.reactome.web.gwtCytoscapeJs.client.CytoscapeWrapper::nodeHovered(*)();
	   	this.@org.reactome.web.gwtCytoscapeJs.client.CytoscapeWrapper::edgeHovered(*)();
	    this.@org.reactome.web.gwtCytoscapeJs.client.CytoscapeWrapper::cytoscapeCoreContextSelected(*)();
	   	
	   	
	   	$wnd.cy.zoom(zoom);
	   	
	   	
	    
	}-*/;
	
	/**
	 * adds a node to cytoscape
	 * @param node
	 */
	public native void addCytoscapeNodes(String nodes) /*-{
	//convert incoming string to node format
	var nodes = $wnd.JSON.parse(nodes);
	
	//add node to cytoscape
	$wnd.cy.add(nodes);
	
	this.@org.reactome.web.gwtCytoscapeJs.client.CytoscapeWrapper::nodeSelected(*)();
	this.@org.reactome.web.gwtCytoscapeJs.client.CytoscapeWrapper::edgeSelected(*)();
	this.@org.reactome.web.gwtCytoscapeJs.client.CytoscapeWrapper::nodeHovered(*)();
	this.@org.reactome.web.gwtCytoscapeJs.client.CytoscapeWrapper::edgeHovered(*)();
	this.@org.reactome.web.gwtCytoscapeJs.client.CytoscapeWrapper::cytoscapeCoreContextSelected(*)();
	
	
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
	this.@org.reactome.web.gwtCytoscapeJs.client.CytoscapeWrapper::cytoscapeCoreContextSelected(*)();
	
	}-*/;
	
	/**
	 * Clears all edges and nodes from Cytoscape.js graph. Nodes and edges are stored in memory by Cytoscape.js for reuse.
	 */
	public native void clearCytoscapeGraph() /*-{
		$wnd.cy.elements('edge').remove();
		$wnd.cy.elements('node').remove();
	}-*/;
	
	public native void setCytoscapeLayout(String layout) /*-{
		var layout = $wnd.cy.layout({name:''+layout+'', componentSpacing:50});
		layout.run();
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
		$wnd.cy.panBy({x:0, y:-px});
	}-*/;
	public native void panLeft(int px) /*-{
		$wnd.cy.panBy({x:-px, y:0});
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
	 */
	public native void highlightSelectedEdgeGroup(String node) /*-{
		$wnd.cy.edges('[target = "'+node+'"]').select();
	}-*/;
	
	/**
	 * Fires NodeClickedEvent with id of node selected.
	 */
	protected native void nodeSelected() /*-{
		var that = this;
		$wnd.cy.elements('node').on('tap', function(evt){
			var id = evt.target.id();
			
			evt.target.connectedEdges().addClass('highlighted');
			
			that.@org.reactome.web.gwtCytoscapeJs.client.CytoscapeWrapper::fireNodeClickedEvent(*)(evt.target.id(), evt.target.json().data.name);
		});
		
		$wnd.cy.elements('node').on('tapunselect', function(evt){
			var id = evt.target.id();
			evt.target.connectedEdges().removeClass('highlighted');
		});
	}-*/;
	
	/**
	 * Fires EdgeClickedEvent with id of edge selected.
	 */
	protected native void edgeSelected() /*-{
		var that = this;
		$wnd.cy.elements('edge').on('tap', function(evt){			
			var id = evt.target.id();
			evt.target.removeClass("highlighted");
			that.@org.reactome.web.gwtCytoscapeJs.client.CytoscapeWrapper::fireEdgeClickedEvent(*)(id);
		});
		$wnd.cy.elements('edge').on('tapunselect', function(evt){
			//testing to see what removing next line breaks
			//$wnd.cy.style().selector('edge[id = "'+evt.target.id()+'"]').style({'line-color': '#bbb'}).update();
		});
	}-*/;
	
	/**
	 * Fires NodeHoveredEvent with id of node hovered on.
	 */
	protected native void nodeHovered() /*-{
		var that = this;
		$wnd.cy.elements('node').on('mouseover', function(evt){
			var x = evt.originalEvent.x;
			var y = evt.originalEvent.y;
			that.@org.reactome.web.gwtCytoscapeJs.client.CytoscapeWrapper::fireNodeHoveredEvent(*)(evt.target.id(), evt.target.json().data.name, x, y);
		});
		$wnd.cy.elements('node').on('mouseout', function(evt){
			that.@org.reactome.web.gwtCytoscapeJs.client.CytoscapeWrapper::fireNodeMouseOutEvent(*)();
		});
	}-*/;
	
	/**
	 * Fires edge hovered event
	 */
	protected native void edgeHovered() /*-{
		var that = this;
		$wnd.cy.elements('edge').on('mouseover', function(evt){
			var id = evt.target.id();
			var x = evt.originalEvent.x;
			var y = evt.originalEvent.y;
			
			evt.target.addClass('hovered');
			
			that.@org.reactome.web.gwtCytoscapeJs.client.CytoscapeWrapper::fireEdgeHoveredEvent(*)(id, x, y);
		});
		$wnd.cy.elements('edge').on('mouseout', function(evt){
			var ele = evt.target;
			
			evt.target.removeClass('hovered');
			
			that.@org.reactome.web.gwtCytoscapeJs.client.CytoscapeWrapper::fireEdgeMouseOutEvent(*)();
		});
	
	}-*/;
	
	private native void cytoscapeCoreContextSelected() /*-{
		var that = this;
		$wnd.cy.on('cxttapstart', function (evt){
			if(evt.target == $wnd.cy){
				var x = evt.originalEvent.x;
				var y = evt.originalEvent.y;
				that.@org.reactome.web.gwtCytoscapeJs.client.CytoscapeWrapper::fireCytoscapeCoreContextEvent(*)(x,y);
			}
		});
		$wnd.cy.on('tap', function(evt){
			if(evt.target == $wnd.cy){
				that.@org.reactome.web.gwtCytoscapeJs.client.CytoscapeWrapper::fireCytoscapeCoreSelectedEvent(*)();
			}
		});
		$wnd.cy.elements('edge').on('cxttapstart', function(evt){			
			var id = evt.target.id();
			var x = evt.originalEvent.x;
			var y = evt.originalEvent.y;
			evt.target.select();
			evt.target.removeClass("highlighted");
			that.@org.reactome.web.gwtCytoscapeJs.client.CytoscapeWrapper::fireEdgeContextEvent(*)(id, x, y);
		});
		$wnd.cy.elements('node').on('cxttapstart', function(evt){
			var id = evt.target.id();
			var name = evt.target.json().data.name;
			var x = evt.originalEvent.x;
			var y = evt.originalEvent.y;
			evt.target.select();
			console.log(id + name);
			that.@org.reactome.web.gwtCytoscapeJs.client.CytoscapeWrapper::fireNodeContextEvent(*)(id, name, x, y);
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
	
	/*
	 * returns an unflattened string of the JSON data for download or other use
	 * @return
	 */
	protected native String exportCytoscapeJSON() /*-{
		var json = JSON.stringify($wnd.cy.json());
		return json;
	}-*/;
	
	/**
	 * Function to output the graph as a png file and place it on an image tag.
	 * Pass in the id name of an image tag for this to be placed on without the "#".
	 * eg. passing in 'png-eg' will place the image data on an image element with an id of 'png-eg'.
	 * @param imgTag
	 * @return
	 */
	protected native void exportCytoscapePNG(String imgTag) /*-{
		var png = $wnd.cy.png();
		$doc.querySelector("#" + imgTag).setAttribute('src', png);
	}-*/;
	
	/**
	 * Function to output the graph as a JPG file and place it on an image tag.
	 * Pass in the id name of an image tag for this to be placed on without the "#".
	 * eg. passing in 'jpg-eg' will place the image data on an image element with an id of 'jpg-eg'.
	 * @param imgTag
	 */
	protected native void exportCytoscapeJPG(String imgTag) /*-{
		var jpg = $wnd.cy.jpg();
		$doc.querySelector("#" + imgTag).setAttribute('src', jpg);
	}-*/;
	
	/**
	 * Highlights all edges and with a value of id for a passed in selector. Use when you want to have nodes be selected.
	 * @param selector
	 * @param id
	 */
	public native void hierarchySelect(String selector, String value) /*-{
		$wnd.cy.edges().removeClass('highlighted');
		$wnd.cy.edges().removeClass('hovered');
		$wnd.cy.edges().unselect();
		$wnd.cy.edges('['+selector+' = "' + value +'"]').select();		
	}-*/;
	
	/**
	 * Highlights all edges with a value of id for a passed in selector.
	 * Use when nodes need to be highlighted on hover while other nodes are already selected.
	 * 
	 * @param selector
	 * @param value
	 */
	public native void hierarchyHover(String selector, String value) /*-{
		var eles = $wnd.cy.edges('['+selector+' = "' + value +'"]');
		eles.addClass('hovered');
	}-*/;
	
	public native void highlightNode(String node, String color) /*-{
		$wnd.cy.style().selector('node#' + node).style({'background-color':color}).update();
	}-*/;
	
	public native void addClass(String cssClass) /*-{
		$wnd.cy.elemtents().addClass(cssClass);
	}-*/;
	
	public native void removeClass(String cssClass)/*-{
		$wnd.cy.elements().removeClass(cssClass);
	}-*/;
	
	public native void addNodeClass(String cssClass)/*-{
		$wnd.cy.nodes().addClass(cssClass);
	}-*/;
	
	public native void addNodeClass(String selector, String value, String cssClass)/*-{	
		$wnd.cy.node('['+selector+' = "'+value+'"]').select();

	}-*/;
	
	public native void removeNodeClass(String cssClass)/*-{
		$wnd.cy.nodes().removeClass(cssClass);
	}-*/;
	
	public native void addEdgeClass(String cssClass)/*-{
		$wnd.cy.edges().addClass(cssClass);
	}-*/;
	
	public native void removeEdgeClass(String cssClass) /*-{
		$wnd.cy.edges().removeClass(cssClass);
	}-*/;
	
	/**
	 * resets to base style
	 */
	public native void resetStyle()/*-{
		var styleJSON = $wnd.JSON.parse(this.@org.reactome.web.gwtCytoscapeJs.client.CytoscapeWrapper::style);
		$wnd.cy.style().fromJson(styleJSON).update();
	}-*/;
	
	public native void setNodeFill(String color)/*-{
		$wnd.cy.style().selector('node').style({'background-color':color}).update();
	}-*/;
	
	public native void resetSelection()/*-{
		$wnd.cy.nodes().unselect();
	}-*/;
	
	/**
	 * Called by JSNI to fire node clicked event
	 * @param node
	 */ 
	private void fireNodeClickedEvent(String id, String name) { 
		eventBus.fireEventFromSource(new NodeClickedEvent(id, name), this);
	}
	
	/**
	 * Called by JSNI to fire edge clicked event
	 * @param edge
	 */
	private void fireEdgeClickedEvent(String id) {
		eventBus.fireEventFromSource(new EdgeClickedEvent(id), this);
	}
	
	/**
	 * Called by JSNI to fire node hovered event
	 * @param node
	 */
	private void fireNodeHoveredEvent(String id, String name, int x, int y) {
		eventBus.fireEventFromSource(new NodeHoveredEvent(id, name, x, y), this);
	}
	
	/**
	 * fires event for when an edge is hovered
	 */
	private void fireEdgeHoveredEvent(String id, int x, int y) {
		eventBus.fireEventFromSource(new EdgeHoveredEvent(id, x, y), this);
	}
	
	/**
	 * Fires node mouse out event
	 */
	private void fireNodeMouseOutEvent() {
		eventBus.fireEventFromSource(new NodeMouseOutEvent(), this);
	}
	
	/**
	 * Fires edge mouse out event
	 */
	private void fireEdgeMouseOutEvent() {
		eventBus.fireEventFromSource(new EdgeMouseOutEvent(), this);
	}
	
	private void fireCytoscapeCoreContextEvent(int x, int y) {
		eventBus.fireEventFromSource(new CytoscapeCoreContextEvent(x, y), this);
	}
	
	private void fireCytoscapeCoreSelectedEvent() {
		eventBus.fireEventFromSource(new CytoscapeCoreSelectedEvent(), this);
	}
	
	private void fireEdgeContextEvent(String id, int x, int y) {
		eventBus.fireEventFromSource(new EdgeContextSelectEvent(id, x, y), this);
	}
	
	private void fireNodeContextEvent(String id, String name, int x, int y) {
		eventBus.fireEventFromSource(new NodeContextSelectEvent(id, name, x, y), this);
	}
}
