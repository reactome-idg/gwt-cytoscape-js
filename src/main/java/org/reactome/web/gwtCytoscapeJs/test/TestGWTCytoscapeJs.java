package org.reactome.web.gwtCytoscapeJs.test;

import org.reactome.web.gwtCytoscapeJs.util.CytoscapeEventBus;
import org.reactome.web.gwtCytoscapeJs.client.CytoscapeViewer;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.RootPanel;

public class TestGWTCytoscapeJs implements EntryPoint{

	  public void onModuleLoad() {
		
		 EventBus eventBus = new CytoscapeEventBus();
		  
		 CytoscapeViewer view = new CytoscapeViewer(eventBus);
		 RootPanel.get().add(view);		  
	  }
}
