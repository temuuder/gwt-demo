package com.toto.test.client.view.impl;

import com.google.gwt.core.client.GWT;
import com.google.gwt.editor.client.Editor;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.TabLayoutPanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Widget;
import com.toto.test.client.view.ViewInterface;
import com.toto.test.shared.TestEntityProxy;

public class TestUI extends Composite implements ViewInterface, Editor<TestEntityProxy> {

	//ui binder init 
	private static TestUIUiBinder uiBinder = GWT.create(TestUIUiBinder.class);

	interface TestUIUiBinder extends UiBinder<Widget, TestUI> {
	}

	public TestUI() {
		initWidget(uiBinder.createAndBindUi(this));
	}
	
	//instances variables
	private ViewPresenter presenter;
	@UiField @Ignore Label labelTab1;
	@UiField @Ignore Label labelTab2;
	@UiField @Ignore TextBox textbox1;
	@UiField @Ignore TextBox textbox2;
	@UiField TabLayoutPanel tabLayoutPanel;
	@UiField TextBox name;
	
	public void setPresenter(ViewPresenter presenter) {
		this.presenter = presenter;
	}

	@UiHandler("buttonTab1")
	public void onButtonTab1(ClickEvent e) {
		presenter.onButtonTab1Click();
	}
	
	@UiHandler("buttonTab2")
	public void onButtonTab2(ClickEvent e) {
		presenter.onButtonTab2Click();
	}
	
	@UiHandler("editorTrigger")
	public void onTriggerSave(ClickEvent e) {
		presenter.onTriggerSave();
	}
	
	public void setLabel1Text(String text) {
		labelTab1.setText(text);		
	}

	public void setLabel2Text(String text) {
		labelTab2.setText(text);
	}
	
	public void setDisplayedTab(int tabNumber) {
		tabLayoutPanel.selectTab(tabNumber);
	}

	public String getTextbox1Text() {
		return textbox1.getText();
	}
	
	public String getTextbox2Text() {
		return textbox2.getText();
	}
}
