/*******************************************************************************
 * Copyright (c) 2012, All Rights Reserved.

 * 
 * Generation Challenge Programme (GCP)
 * 
 * 
 * This software is licensed for use under the terms of the GNU General Public
 * License (http://bit.ly/8Ztv8M) and the provisions of Part F of the Generation
 * Challenge Programme Amended Consortium Agreement (http://bit.ly/KQX1nL)
 * 
 *******************************************************************************/

package org.generationcp.commons.vaadin.spring;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;

import org.springframework.context.support.ResourceBundleMessageSource;

import com.vaadin.data.Property;
import com.vaadin.ui.AbstractComponent;
import com.vaadin.ui.Component;
import com.vaadin.ui.Table;

public class SimpleResourceBundleMessageSource extends ResourceBundleMessageSource implements Serializable {
    private static final long serialVersionUID = 1L;

    private Locale locale;
    
    private List<SimpleResourceBundleMessageSourceListener> listeners = new LinkedList<SimpleResourceBundleMessageSourceListener>();
    
    public Locale getLocale() {
        return locale;
    }

    public void setLocale(Locale locale) {
        Locale oldLocale = this.locale;
        
        this.locale = locale;
        
        // notify listeners that the locale has changed
        notifyLocaleChanged(oldLocale, locale);
    }
    
    public void addListener(SimpleResourceBundleMessageSourceListener listener) {
        listeners.add(listener);
    }
    
    public void removeListener(SimpleResourceBundleMessageSourceListener listener) {
        listeners.remove(listener);
    }
    
    public String getMessage(String code) {
        return super.getMessage(code, null, locale);
    }
    
    public String getMessage(Enum<?> code) {
        return super.getMessage(code.name(), null, locale);
    }
    
    public String getMessage(String code, Object... args) {
        return super.getMessage(code, args, locale);
    }
    
    public String getMessage(Enum<?> code, Object... args) {
        return super.getMessage(code.name(), args, locale);
    }
    
    public void setValue(Property component, String messageCode) {
        component.setValue(getMessage(messageCode));
    }
    
    public void setValue(Property component, Enum<?> messageCode) {
        component.setValue(getMessage(messageCode.name()));
    }
    
    public void setValue(Property component, Enum<?> messageCode, Object... args) {
        component.setValue(getMessage(messageCode.name(), args));
    }
    
    public void setCaption(Component component, String messageCode) {
        component.setCaption(getMessage(messageCode));
    }
    
    public void setCaption(Component component, Enum<?> messageCode) {
        component.setCaption(getMessage(messageCode.name()));
    }
    
    public void setDescription(AbstractComponent abstractComponent, String messageCode) {
    	abstractComponent.setDescription(getMessage(messageCode));
    }
    
    public void setDescription(AbstractComponent abstractComponent, Enum<?> messageCode) {
    	abstractComponent.setDescription(getMessage(messageCode.name()));
    }
    
    public void setColumnHeader(Table table, String propertyId, String messageCode) {
        table.setColumnHeader(propertyId, getMessage(messageCode));
    }
    
    public void setColumnHeader(Table table, String propertyId, Enum<?> messageCode) {
        table.setColumnHeader(propertyId, getMessage(messageCode.name()));
    }
    
    private void notifyLocaleChanged(Locale oldLocale, Locale newLocale) {
        for (SimpleResourceBundleMessageSourceListener listener : listeners) {
            listener.localeChanged(oldLocale, newLocale);
        }
    }
}
