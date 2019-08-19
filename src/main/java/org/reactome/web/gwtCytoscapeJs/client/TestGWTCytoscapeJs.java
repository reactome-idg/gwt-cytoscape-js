package org.reactome.web.gwtCytoscapeJs.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.RootPanel;

public class TestGWTCytoscapeJs implements EntryPoint{

	  public void onModuleLoad() {
		
		 TestViewImpl view = new TestViewImpl();
		 RootPanel.get().add(view);		  
	  }
	  
	  public static void selected(String node) {
		  Window.alert("node selected" + node);
	  }
}
