package com.viktex.gwtfuse.widgets.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.AbstractImagePrototype;
import com.google.gwt.user.client.ui.ClickListener;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.ImageBundle;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.TabPanel;
import com.google.gwt.user.client.ui.Widget;
import com.viktex.gwtfuse.widgets.client.ui.buttons.HyperlinkButton;
import com.viktex.gwtfuse.widgets.client.ui.stacks.OutlookStackPanel;

/**
 * Example of using GWT for nice looking buttons
 * 
 * @author <a href="mailto:v.zaprudnev at gmail.com">Viktor Zaprudnev</a>
 * More information here: http://gwtfuse.blogspot.com/
 *
 */
public class Example implements EntryPoint {
	public interface OutlookStackPanelImages extends ImageBundle{
		AbstractImagePrototype mail();
		AbstractImagePrototype calendar();
		AbstractImagePrototype contacts();
		AbstractImagePrototype tasks();
		AbstractImagePrototype notes();
	}
	
	private OutlookStackPanelImages images = (OutlookStackPanelImages) GWT.create(OutlookStackPanelImages.class);

	public void onModuleLoad() {
		
		TabPanel panel = new TabPanel();
		panel.setSize("100%", "100%");
		
		HorizontalPanel horizont = new HorizontalPanel();
		horizont.setSize("100%", "100%");
		horizont.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
		
		final HyperlinkButton disabled = new HyperlinkButton("Disabled button!", false, new ClickListener() {
			public void onClick(Widget sender) {
				Window.alert("Thanks!");
				((HyperlinkButton) sender).setText("Disabled button!");
				((HyperlinkButton) sender).setEnabled(false);
			}
		});
		
		HyperlinkButton enabled = new HyperlinkButton("Click me!", new ClickListener() {
			public void onClick(Widget sender) {
				Window.alert("Have a nice day, my friend!\n");
				disabled.setText("I'm Enabled!");
				disabled.setEnabled(true);
			}
		});
		
		
		
		horizont.add(enabled);

		horizont.add(disabled);

		panel.add(horizont, "Hyperlink Button");
		
		
		
		OutlookStackPanel outlookStack = new OutlookStackPanel();
		HorizontalPanel hpanel = new HorizontalPanel();
		outlookStack.setHeight("150px");
		
		/**
		 * Example
		 */
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
		hpanel.add(new HTML("...."));
		panel.add(hpanel, "Outlook Stack Panel");

		
		panel.selectTab(0);
		RootPanel.get().add(panel);

		
	}

}
