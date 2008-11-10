package com.viktex.gwtfuse.widgets.client.ui.examples;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.ui.AbstractImagePrototype;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.ImageBundle;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;
import com.viktex.gwtfuse.widgets.client.ui.stacks.OutlookStackPanel;

/**
 * Example of using GWTFuse widget: OutlookStackPanel
 * 
 * @author <a href="mailto:v.zaprudnev at gmail.com">Viktor Zaprudnev</a>
 * More information here: http://gwtfuse.blogspot.com/
 *
 */

public class OutlookStackPanelExample extends VerticalPanel {
	public interface OutlookStackPanelImages extends ImageBundle{
		AbstractImagePrototype mail();
		AbstractImagePrototype calendar();
		AbstractImagePrototype contacts();
		AbstractImagePrototype tasks();
		AbstractImagePrototype notes();
	}
	
	private OutlookStackPanelImages images = (OutlookStackPanelImages) GWT.create(OutlookStackPanelImages.class);

	public OutlookStackPanelExample() {

		OutlookStackPanel outlookStack = new OutlookStackPanel();
		HorizontalPanel hpanel = new HorizontalPanel();
		outlookStack.setHeight("150px");
		
		Widget mailContent = new HTML("> message: 2008-01-01: Hey, how is going?</br>> message: 2008-01-01: Very good, my friend!</br>");
		Widget calendarContent = new HTML("> 2008.01.01 - New Year</br>> 2009.03.13: Birthday</br>");
		Widget contactsContent = new HTML("> Contact: Alexey</br>> Contact: Victor</br>> Contact: Manuel</br>> Contact: Anna</br>> Contact: Zaprudnev</br>> Contact: Manuel</br>> Contact: Anna</br>> Contact: Zaprudnev</br>");
		Widget tasksContent = new HTML("> Make nice outlook component!</br>> Publish it online</br>Wait for people ideas</br>");
		Widget notesContent = new HTML("> Have a nice day!");
		
		outlookStack.add(mailContent, images.mail(), "Mail");
		outlookStack.add(calendarContent, images.calendar(), "Calendar");
		outlookStack.add(contactsContent, images.contacts(), "Contacts");
		outlookStack.add(tasksContent, images.tasks(), "Tasks");
		outlookStack.add(notesContent, images.notes(), "Notes");
		
		
		hpanel.add(outlookStack);
		add(hpanel);
	}

	
	
	
}
