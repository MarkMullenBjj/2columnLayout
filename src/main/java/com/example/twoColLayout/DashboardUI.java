package com.example.twoColLayout;

import javax.servlet.annotation.WebServlet;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.shared.ui.ContentMode;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.CssLayout;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.TextField;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.themes.ValoTheme;


@Theme("mytheme")
public class DashboardUI extends UI {

    @Override
    protected void init(VaadinRequest vaadinRequest) {
        final VerticalLayout layoutContainer = new VerticalLayout();
        layoutContainer.setDefaultComponentAlignment(Alignment.MIDDLE_CENTER);
        //layoutContainer.addStyleName("Blueprint");
        
        CssLayout layoutHeader = new CssLayout();
        layoutHeader.setWidth(50,Unit.PERCENTAGE);
        Label titleTop = new Label("My Responsive Layout Title");
        layoutHeader.addStyleName("header");
        //titleTop.addStyleName(ValoTheme.LABEL_H1);
        //layoutHeader.setDefaultComponentAlignment(Alignment.MIDDLE_CENTER);
        //layoutHeader.setMargin(false);
        layoutHeader.addComponent(titleTop);
        
        
        //layout of menu and main content body
        HorizontalLayout layoutBody = new HorizontalLayout(); 
        layoutBody.setSizeFull();
        
        //the menu layout
        CssLayout layoutMenu = new CssLayout();
        layoutMenu.setStyleName("menu");
        layoutMenu.setWidth("100%");
        
        Label menuTop = new Label("Menu Title");
        menuTop.addStyleName(ValoTheme.LABEL_BOLD);
        layoutMenu.addComponent(menuTop);
        
        Button buttonStart = new Button("Start");
        Button buttonAdmin = new Button("Admin");
        Button buttonSettings = new Button("Settings");
        layoutMenu.addComponents(buttonStart, buttonAdmin, buttonSettings);
        
        
        //the main content layout
        VerticalLayout layoutContent = new VerticalLayout(); 
        //this sets the width of the form component to use only as much space as required
        //formLayout.setWidthUndefined();
        layoutContent.setSpacing(true);
        layoutContent.setMargin(true);
        //layoutContent.setWidth(500, Unit.PIXELS);
        
        Label contentHeader = new Label("Loren Ipsum");
        contentHeader.addStyleName(ValoTheme.LABEL_H2); 
        layoutContent.addComponent(contentHeader);
        
        //main content
        Label contentText = new Label("<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.</p><p> Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.</p> <p>Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.</p>",ContentMode.HTML);
        contentText.setWidth("100%");
        layoutContent.addComponent(contentText);
        contentText.addStyleName(ValoTheme.LABEL_H4);
        
        //add form to main content
        FormLayout myform = new FormLayout();
        //myform.setSpacing(true);
        
        TextField nameFirst = new TextField("FirstName");
        TextField nameLast = new TextField("Last Name");
        TextField email = new TextField("Email");
        Button submitButton = new Button("Submit");
        submitButton.addStyleName(ValoTheme.BUTTON_FRIENDLY);
        Button clearButton = new Button("Clear");
        myform.addComponents(nameFirst, nameLast, email, submitButton, clearButton);
        
        layoutContent.addComponent(myform);
        
        
        
        layoutBody.addComponents(layoutMenu, layoutContent);
        //set the proportions of the menu / page content
        layoutBody.setExpandRatio(layoutMenu, 2);
        layoutBody.setExpandRatio(layoutContent, 8);
        
        
        //layout the footer
        HorizontalLayout layoutFooter = new HorizontalLayout(); 
        Label footerTitle = new Label("Footer");
        footerTitle.addStyleName(ValoTheme.LABEL_BOLD);
        layoutFooter.addComponent(footerTitle);
        
        
        layoutContainer.addComponents(layoutHeader, layoutBody, layoutFooter);
        
        setContent(layoutContainer);
    }

    @WebServlet(urlPatterns = "/*", name = "DashboardUIServlet", asyncSupported = true)
    @VaadinServletConfiguration(ui = DashboardUI.class, productionMode = false)
    public static class DashboardUIServlet extends VaadinServlet {
    }
}
