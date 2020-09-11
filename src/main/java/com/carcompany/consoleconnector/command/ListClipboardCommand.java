package com.carcompany.consoleconnector.command;

import com.carcompany.consoleconnector.view.ListClipboardView;
import com.carcompany.consoleconnector.view.View;

public class ListClipboardCommand extends Command{

    @Override
    public void executeCommand(String[] arguments) throws Exception {
        
        View view = new ListClipboardView(clipboard.getMap());


        view.print();

    }
    
}
