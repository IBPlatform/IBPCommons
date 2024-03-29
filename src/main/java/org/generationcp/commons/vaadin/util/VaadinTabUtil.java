/***************************************************************
 * Copyright (c) 2012, All Rights Reserved.
 * 
 * Generation Challenge Programme (GCP)
 * 
 * @author Kevin L. Manansala
 * 
 * This software is licensed for use under the terms of the 
 * GNU General Public License (http://bit.ly/8Ztv8M) and the 
 * provisions of Part F of the Generation Challenge Programme 
 * Amended Consortium Agreement (http://bit.ly/KQX1nL)
 * 
 **************************************************************/
package org.generationcp.commons.vaadin.util;

import com.vaadin.ui.TabSheet;
import com.vaadin.ui.TabSheet.Tab;


public class VaadinTabUtil{
    
    public static boolean isTabExist(TabSheet tabSheet, String tabCaption) {

        int countTabSheet = tabSheet.getComponentCount();

        for (int i = 0; i < countTabSheet; i++) {
            Tab tab = tabSheet.getTab(i);
            if (tab.getCaption().equals(tabCaption)) {
                return true;
            }
        }
        return false;
    }
    
    public static Tab getTabAlreadyExist(TabSheet tabSheet, String tabCaption) {

        for (int i = 0; i < tabSheet.getComponentCount(); i++) {
            Tab tab = tabSheet.getTab(i);
            if (tab.getCaption().equals(tabCaption)) {
                return tab;
            }
        }
        return null;

    }
}
