package com.carcompany.consoleconnector.view;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ListClipboardView extends View {

    private Map map;

    public ListClipboardView(Map map) {

        this.map = map;

	}

	@Override
    public void print() {

        Set<String> keys = (String) map.keySet();

        keys.stream().forEach(e -> System.out.println(e));

            
        }
        

    }

    @Override
    public void update() {
        // TODO Auto-generated method stub

    }
    
    
}
