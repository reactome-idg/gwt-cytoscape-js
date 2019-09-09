package org.reactome.web.gwtCytoscapeJs.client;

import org.reactome.web.gwtCytoscapeJs.events.EdgeClickedEvent;
import org.reactome.web.gwtCytoscapeJs.events.NodeClickedEvent;
import org.reactome.web.gwtCytoscapeJs.handlers.EdgeClickedHandler;
import org.reactome.web.gwtCytoscapeJs.handlers.NodeClickedHandler;
import org.reactome.web.gwtCytoscapeJs.client.clientBundle.Resources;

import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.AbsolutePanel;
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
public class CytoscapeViewer extends Composite implements IsWidget {
	private CytoscapeWrapper cy;
	private EventBus eventBus;
	
	private Button btn;
	
	public CytoscapeViewer(EventBus eventBus) {
		this.eventBus = eventBus;
		cy = new CytoscapeWrapper(eventBus);
	
		initialise();
		//init handlers and button click events
		initHandlers();
	}
	
	private void initialise() {
		DockLayoutPanel view = new DockLayoutPanel(Unit.PX);

		SimplePanel panel = new SimplePanel();
		panel.getElement().setId("cy");
		
		btn = new Button("Test Button");
		
		view.addNorth(btn, 12);
		view.add(panel);
		view.setSize("100", "100");
		view.forceLayout();
		initWidget(view);
	}
	
	private void initHandlers() {

		//register eventBus handlers & override action methods
		eventBus.addHandler(NodeClickedEvent.TYPE, new NodeClickedHandler() {
			@Override
			public void onNodeClicked(NodeClickedEvent event) {
				cy.highlightSelectedEdgeGroup(event.getNodeId(), Resources.INSTANCE.cytoscapeStyle().getText());
			}

		});
		eventBus.addHandler(EdgeClickedEvent.TYPE, new EdgeClickedHandler() {
			@Override
			public void onEdgeClicked(EdgeClickedEvent event) {/*nothing here*/}});
	}

	@Override
	public Widget asWidget() {
		return this;
	}

}
