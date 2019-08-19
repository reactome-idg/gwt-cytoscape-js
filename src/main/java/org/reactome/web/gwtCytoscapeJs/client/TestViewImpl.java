package org.reactome.web.gwtCytoscapeJs.client;

import org.reactome.web.gwtCytoscapeJs.viewport.CytoscapeEntity;

import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.DockLayoutPanel;
import com.google.gwt.user.client.ui.SimplePanel;
import com.google.gwt.user.client.ui.Widget;

/**
 * 
 * @author brunsont
 *
 */
public class TestViewImpl extends Composite implements TestView{
	private Button staticPath;
	
	/**
	 * constructor to create widget
	 */
	public TestViewImpl() {
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
			cy.nodeSelected();
			cy.edgeSelected();
		}
	});
}

	@Override
	public Widget asWidget() {
		// TODO Auto-generated method stub
		return null;
	}

}
