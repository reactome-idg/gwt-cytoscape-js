package org.reactome.web.gwtCytoscapeJs.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.DockLayoutPanel;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.SimplePanel;

public class gwtCytoscapeJs implements EntryPoint {
	private Button staticPath;

	  public void onModuleLoad() {
		  
		  DockLayoutPanel view = new DockLayoutPanel(Unit.PX);
			SimplePanel panel = new SimplePanel();
			staticPath = new Button("show static example");
			panel.getElement().setId("cy");
			view.addNorth(staticPath, 25);
			view.add(panel);
			view.setSize("100%", "100%");
			view.forceLayout();
			RootPanel.get("panel").add(view);;
			bind();
	  }
	  
		
		public void bind() {
			staticPath.addClickHandler(new ClickHandler() {
				@Override
				public void onClick(ClickEvent event) {
					//using real data
//				cy = new CytoscapeInitializer();
//				cy.cytoscapeInit();
			}
		});
	}
}
