package org.reactome.web.gwtCytoscapeJs.test;

import org.reactome.web.gwtCytoscapeJs.util.CytoscapeEventBus;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.RootPanel;

public class TestGWTCytoscapeJs implements EntryPoint{

	  public void onModuleLoad() {
		
		 EventBus eventBus = new CytoscapeEventBus();
		  
		 TestView view = new TestView(eventBus);
		 RootPanel.get().add(view);		  
	  }
	  
	  public static void selected(String node) {
		  Window.alert("node selected" + node);
	  }
}