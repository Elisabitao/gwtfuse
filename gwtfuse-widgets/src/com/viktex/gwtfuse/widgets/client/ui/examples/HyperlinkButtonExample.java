package com.viktex.gwtfuse.widgets.client.ui.examples;

import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.ClickListener;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Widget;
import com.viktex.gwtfuse.widgets.client.ui.buttons.HyperlinkButton;

/**
 * Example of using GWTFuse widget: HyperlinkButton
 * 
 * @author <a href="mailto:v.zaprudnev at gmail.com">Viktor Zaprudnev</a>
 * More information here: http://gwtfuse.blogspot.com/
 *
 */
public class HyperlinkButtonExample extends Composite {

	public HyperlinkButtonExample() {
		
		HorizontalPanel panel = new HorizontalPanel();
		panel.setSize("100%", "100%");
		panel.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);

		final HyperlinkButton disabled = new HyperlinkButton(
				"Disabled button!", false, new ClickListener() {
					public void onClick(Widget sender) {
						Window.alert("Thanks!");
						((HyperlinkButton) sender).setText("Disabled button!");
						((HyperlinkButton) sender).setEnabled(false);
					}
				});

		HyperlinkButton enabled = new HyperlinkButton("Click me!",
				new ClickListener() {
					public void onClick(Widget sender) {
						Window.alert("Have a nice day, my friend!\n");
						disabled.setText("I'm Enabled!");
						disabled.setEnabled(true);
					}
				});

		panel.add(enabled);

		panel.add(disabled);
		
		initWidget(panel);
	}
}
