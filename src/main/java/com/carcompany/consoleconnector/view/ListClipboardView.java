package com.carcompany.consoleconnector.view;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ListClipboardView extends View {

    private Map<String, Object> map;

    public ListClipboardView(Map<String, Object> map) {

        this.map = map;

	}

	@Override
    public void print() {

        Set<String> keys = map.keySet();

        keys.stream().forEach(e -> System.out.println(e));

            
        }
        

    }

    @Override
    public void update() {
        // TODO Auto-generated method stub

    }
    
    
}
