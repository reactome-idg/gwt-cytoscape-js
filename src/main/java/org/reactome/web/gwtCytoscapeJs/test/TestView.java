package org.reactome.web.gwtCytoscapeJs.test;

import org.reactome.web.gwtCytoscapeJs.client.CytoscapeWrapper;
import org.reactome.web.gwtCytoscapeJs.events.EdgeClickedEvent;
import org.reactome.web.gwtCytoscapeJs.events.NodeClickedEvent;
import org.reactome.web.gwtCytoscapeJs.handlers.EdgeClickedHandler;
import org.reactome.web.gwtCytoscapeJs.handlers.NodeClickedHandler;

import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.DockLayoutPanel;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.SimplePanel;
import com.google.gwt.user.client.ui.Widget;

/**
 * 
 * @author brunsont
 *
 */
public class TestView extends Composite implements IsWidget {
	private Button staticPath;
	private CytoscapeWrapper cy;
	private EventBus eventBus;
	
	public TestView(EventBus eventBus) {
		this.eventBus = eventBus;
		DockLayoutPanel view = new DockLayoutPanel(Unit.PX);
		SimplePanel panel = new SimplePanel();
		staticPath = new Button("show static example");
		panel.getElement().setId("cy");
		view.addNorth(staticPath, 25);
		view.add(panel);
		view.setSize("100%", "100%");
		view.forceLayout();
		initWidget(view);
		bind();
		
		
		
		eventBus.addHandler(NodeClickedEvent.TYPE, new NodeClickedHandler() {

			@Override
			public void onNodeClicked(NodeClickedEvent event) {
				Window.alert("Node Clicked");
				
			}
		});
		eventBus.addHandler(EdgeClickedEvent.TYPE, new EdgeClickedHandler() {

			@Override
			public void onEdgeClicked(EdgeClickedEvent event) {
				Window.alert("Edge Clicked");
				
			}
			
		});
	}
	
	/**
	 * Add click handler
	 */
	private void bind() {
		staticPath.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				cy = new CytoscapeWrapper(eventBus);
				cy.cytoscapeInit();
			}
		});
	}	
	
	/**
	 * Called by JSNI to fire node clicked event
	 * @param node
	 */
	public void fireNodeClickedEvent(String node) {
		eventBus.fireEventFromSource(new NodeClickedEvent(node), this);
	}
	
	/**
	 * Called by JSNI to fire edge clicked event
	 * @param edge
	 */
	public void fireEdgeClickedEvent(String edge) {
		eventBus.fireEventFromSource(new EdgeClickedEvent(edge), this);
	}

	@Override
	public Widget asWidget() {
		// TODO Auto-generated method stub
		return null;
	}

}
