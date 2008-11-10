package com.viktex.gwtfuse.widgets.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.ui.AbstractImagePrototype;
import com.google.gwt.user.client.ui.ClickListener;
import com.google.gwt.user.client.ui.DockPanel;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Hyperlink;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.ImageBundle;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.SimplePanel;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;
import com.viktex.gwtfuse.widgets.client.ui.examples.AdsenseTesting;
import com.viktex.gwtfuse.widgets.client.ui.examples.HyperlinkButtonExample;
import com.viktex.gwtfuse.widgets.client.ui.examples.OutlookStackPanelExample;
import com.viktex.gwtfuse.widgets.client.ui.stacks.OutlookStackPanel;

/**
 * Example of using GWTFuse widgets
 * 
 * @author <a href="mailto:v.zaprudnev at gmail.com">Viktor Zaprudnev</a>
 * More information here: http://gwtfuse.blogspot.com/
 *
 */
public class Showcase implements EntryPoint, ClickListener {
	public interface ShowcaseImages extends ImageBundle{
		AbstractImagePrototype folder();
		AbstractImagePrototype information();
		AbstractImagePrototype wink();
		
	}
	
	private ShowcaseImages images = (ShowcaseImages) GWT.create(ShowcaseImages.class);
	private HorizontalPanel dock = new HorizontalPanel();
	private HorizontalPanel header = new HorizontalPanel();
	private VerticalPanel center = new VerticalPanel();
	
	
	/***************************************************
	 * Links to examples
	 */
	Hyperlink buttonContent ;
	Hyperlink stackContent ;
	Hyperlink otherContent ;
	
	
	public void onModuleLoad() {
		
		/*
		 * Menu elements
		 */
		OutlookStackPanel menuPanel = new OutlookStackPanel();
		menuPanel.setHeight("400px");
		
		buttonContent = new Hyperlink("HyperlinkButton", "HyperlinkButton");
		stackContent = new Hyperlink("OutlookStackPanel", "OutlookStackPanel");
		otherContent = new Hyperlink("Coming soon...", "Coming soon...");
		
		buttonContent.addClickListener(this);
		stackContent.addClickListener(this);

		menuPanel.add(buttonContent, images.information(), "Buttons");
		menuPanel.add(stackContent, images.folder(), "Panels");
		menuPanel.add(otherContent, images.wink(), "Other");
		menuPanel.setWidth("120px");
		/*
		 * Header component 
		 */
		//header.setBorderWidth(2);
		HTML headerHtml; 
		header.add(headerHtml = new HTML("<h1>GWTFuse</h1><p><span>GWTFuse - make an easy start with GWT</span></p> " ));
		
		headerHtml.setStyleName("header");
		//header.setHeight('2px');
		
		center.setBorderWidth(2);
		
		/*
		 * Main layout
		 */
		VerticalPanel vertical = new VerticalPanel();
		vertical .add(header);
		vertical .add(center);
		
		dock.add(menuPanel);
		dock.add(vertical);
		dock.add(new AdsenseTesting());
		dock.setSize("100%", "100%");
		
		
		/*
		 * Initialization
		 */
		center.setSize("100%", "100%");
		center.add(new HyperlinkButtonExample());
		
		RootPanel.get().add(dock);
	}

	public void onClick(Widget sender) {
		try {
			if (sender == buttonContent) {
				center.clear();
				center.add(new HyperlinkButtonExample());
			} else if (sender == stackContent) {
				center.clear();
				center.add(new OutlookStackPanelExample());
			}	
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
