package com.viktex.gwtfuse.widgets.client.ui.examples;

import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.VerticalPanel;

public class AdsenseTesting extends Composite {
	//This is for a testing and advertisment of GWT as a technology
	
	String adsenseExample = "<form action='http://www.google.com/cse' id='cse-search-box' target='_blank'>  <div>    <input type='hidden' name='cx' value='partner-pub-0927393053009522:e1aixx-el0p' />    <input type='hidden' name='ie' value='ISO-8859-1' />    <input type='text' name='q' size='31' />    <input type='submit' name='sa' value='Search' />  </div></form><script type='text/javascript' src='http://www.google.com/coop/cse/brand?form=cse-search-box&amp;lang=en'></script>'";
	
	public AdsenseTesting() {
		
		//TODO: add search result to the same page.
		
		VerticalPanel panel = new VerticalPanel();
		panel.add(new HTML("Search by Google Adsense: "+ adsenseExample));
		
		initWidget(panel);
	}
}
