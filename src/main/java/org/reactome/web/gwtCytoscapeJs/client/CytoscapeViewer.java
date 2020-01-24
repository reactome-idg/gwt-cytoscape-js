package org.reactome.web.gwtCytoscapeJs.client;

import org.reactome.web.gwtCytoscapeJs.events.EdgeClickedEvent;
import org.reactome.web.gwtCytoscapeJs.events.NodeClickedEvent;
import org.reactome.web.gwtCytoscapeJs.handlers.EdgeClickedHandler;
import org.reactome.web.gwtCytoscapeJs.handlers.NodeClickedHandler;
import org.reactome.web.gwtCytoscapeJs.client.CytoscapeWrapper.Handler;
import org.reactome.web.gwtCytoscapeJs.client.clientBundle.Resources;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.AbsolutePanel;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.DockLayoutPanel;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.SimplePanel;
import com.google.gwt.user.client.ui.Widget;

/**
 * 
 * @author brunsont
 *
 */
public class CytoscapeViewer extends Composite implements Handler{
	private CytoscapeWrapper cy;
	private EventBus eventBus;
	
	private Button btn;
	private Button test;
	
	public CytoscapeViewer(EventBus eventBus) {
		this.eventBus = eventBus;
		cy = new CytoscapeWrapper(Resources.INSTANCE.cytoscapeStyle().getText(), this);
	
		initialise();
		//init handlers and button click events
		initHandlers();
	}
	
	private void initialise() {
		DockLayoutPanel view = new DockLayoutPanel(Unit.PX);

		SimplePanel panel = new SimplePanel();
		panel.getElement().setId("cy");
		panel.setSize("100%", "100%");
		
		Image img = new Image();
		img.setSize("50px", "50px");
		img.getElement().setId("jpg-test");
		
		btn = new Button("Generate test graph");
		test = new Button("test");
		
		view.addNorth(btn, 25);
		view.addNorth(test, 25);
		view.addSouth(img, 55);
		view.add(panel);
		view.setSize("100%", "100%");
		view.forceLayout();
		initWidget(view);
		bind();
	}
	
	private void initHandlers() {

		//register eventBus handlers & override action methods
		eventBus.addHandler(NodeClickedEvent.TYPE, new NodeClickedHandler() {
			@Override
			public void onNodeClicked(NodeClickedEvent event) {
				//cy.highlightSelectedEdgeGroup(event.getNodeId());
			}

		});
		eventBus.addHandler(EdgeClickedEvent.TYPE, new EdgeClickedHandler() {
			@Override
			public void onEdgeClicked(EdgeClickedEvent event) {/*nothing here*/}});
	}

	private void bind() {
		btn.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				cy.cytoscapeInit();
			}			
		});
		test.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				
			}
			
		});
	}

	@Override
	public void onNodeClicked(String id, String name) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onEdgeClicked(String id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onNodeHovered(String id, String name, int x, int y) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onEdgeHovered(String id, int x, int y) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onNodeMouseOut() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onEdgeMouseOut() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onCytoscapeCoreContextEvent(int x, int y) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onCytoscapeCoreSelectedEvent() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onEdgeContextSelectEvent(String id, int x, int y) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onNodeContextSelectEvent(String id, String name, int x, int y) {
		// TODO Auto-generated method stub
		
	}

}
