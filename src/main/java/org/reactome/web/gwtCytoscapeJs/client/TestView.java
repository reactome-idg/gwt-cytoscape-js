package org.reactome.web.gwtCytoscapeJs.client;

import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
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
	
	/**
	 * constructor to create widget
	 */
	public TestView() {
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
	}
	
	/**
	 * Add click handlers
	 */
	public void bind() {
		staticPath.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
			CytoscapeEntity cy = new CytoscapeEntity();
			cy.cytoscapeInit();
			cy.addListeners();
		}
	});
}

	@Override
	public Widget asWidget() {
		// TODO Auto-generated method stub
		return null;
	}

}
