package com.carcompany.consoleconnector;

import java.util.HashMap;
import java.util.Map;

public class Context {
    private Map<Integer, CommandEnumeration> menuItems;
    private Context context;
    private String name;

    public Context(Context context, String name) {
        this.menuItems = new HashMap<>();
        this.context = context;
        this.name = name;
    }

    public Context getContext() {
        return this.context;
    }

    public String getName() {
        return this.name;
    }

    public void setMenuItems(CommandEnumeration... commandEnumerations) {
        for (int i = 0; i < commandEnumerations.length; i++) {
            this.menuItems.put(i + 1, commandEnumerations[i]);
        }
    }

    public Map<Integer, CommandEnumeration> getMenuItems() {
        return this.menuItems;
    }
}
