package org.reactome.web.gwtCytoscapeJs.util;

import java.util.Date;

import org.reactome.web.gwtCytoscapeJs.util.Console;

import com.google.gwt.event.shared.GwtEvent;
import com.google.gwt.event.shared.SimpleEventBus;
import com.google.gwt.i18n.client.DateTimeFormat;

/**
 * @author brunsont
 */
public class CytoscapeEventBus extends SimpleEventBus {
	
    private DateTimeFormat fmt = DateTimeFormat.getFormat("HH:mm:ss");

	
	@Override
    public void fireEvent(GwtEvent<?> event) {
        String msg = "Please do not use fireEvent. Use fireEventFromSource instead.";
        throw new RuntimeException(msg);
    }

    @Override
    public void fireEventFromSource(GwtEvent<?> event, Object source) {

        Console.info(
                this.fmt.format(new Date()) + " " +
                        source.getClass().getSimpleName() + " >> " +
                        event
        );
        
        super.fireEventFromSource(event, source);
    }
}
