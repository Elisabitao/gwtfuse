package com.viktex.gwtfuse.widgets.client.ui.buttons;

import com.google.gwt.user.client.ui.ClickListener;
import com.google.gwt.user.client.ui.Hyperlink;

/**
 * Example of using GWT for nice looking buttons
 * 
 * @author <a href="mailto:v.zaprudnev at gmail.com">Viktor Zaprudnev</a>
 *
 */
public class HyperlinkButton extends Hyperlink {
	String disabledHTML = "<table class='HyperlinkButton-disabled' cellpadding='0' cellspacing='0'>" +
			"					<tbody><tr>" +
			"					<td class='HyperlinkButton-left-disabled'><img src='images/HyperlinkButton-spacer.gif' width='6' border='0' height='1'></td>" +
			"					<td class='HyperlinkButton-bg-disabled'>{TEXT}</td>" +
			"					<td class='HyperlinkButton-right-disabled'><img src='images/HyperlinkButton-spacer.gif' width='6' border='0' height='1'></td>" +
			"					</tr></tbody></table>";
	String enabledHTML = "<table class='HyperlinkButton' cellpadding='0' cellspacing='0'>" +
			"					<tbody><tr>" +
			"					<td class='HyperlinkButton-left'><img src='images/HyperlinkButton-spacer.gif' width='6' border='0' height='1'></td>" +
			"					<td class='HyperlinkButton-bg'>{TEXT}</td>" +
			"					<td class='HyperlinkButton-right'><di><img src='images/HyperlinkButton-spacer.gif' width='6' border='0' height='1'></td>" +
			"					</tr></tbody></table>";

	private String text;
	
	private boolean enabled;
	
	private ClickListener listener;

	public HyperlinkButton(String text) {
		this(text, true, null);
	}

	public HyperlinkButton(String text, boolean enabled) {
		this(text, enabled, null);
	}

	public HyperlinkButton(String text, ClickListener listener) {
		this(text, true, listener);
	}

	public HyperlinkButton(String text, boolean enabled, ClickListener listener) {
		this.enabled = enabled;
		this.text = text;
		this.listener = listener;

		updateGUI();
	}

	@Override
	public void setText(String text) {
		this.text = text;
		updateGUI();
	}

	/*
	 * Return button status
	 */
	public boolean isEnabled() {
		return enabled;
	}

	/*
	 * Change button status
	 */
	public void setEnabled(boolean enabled) {
		if (enabled == this.enabled)
			return;
		this.enabled = enabled;
		updateGUI();

	}

	/*
	 * Used to update UI after status was changed
	 */
	protected void updateGUI() {
		String html;
		if (enabled) {
			html = enabledHTML.replace("{TEXT}", text);
		} else {
			html = disabledHTML.replace("{TEXT}", text);
		}

		setHTML(html);

		if (enabled && listener != null) {
			addClickListener(listener);
		} else {
			removeClickListener(listener);
		}
	}
}
