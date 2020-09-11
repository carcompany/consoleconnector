package com.carcompany.consoleconnector.command;

import com.carcompany.carreservationservice.structure.resourceservice.structure.Resource;
import com.carcompany.consoleconnector.Clipboard;
import com.carcompany.consoleconnector.exception.ArgumentsException;
import com.carcompany.consoleconnector.view.ShowResourceView;
import com.carcompany.consoleconnector.view.View;

public class ShowResourceCommand extends Command{

    @Override
    public void executeCommand(String[] arguments) throws Exception {



        if(arguments.length == 1){
            Resource resource = (Resource) Clipboard.getInstance().get(Resource.class.getName() + ":" + arguments[0]);

            View view = new ShowResourceView(resource);

            view.print();
        } else {
            throw new ArgumentsException(
					String.format("One argument is required. Got %s arguments.", arguments.length));
        }
        
        

    }
    
}
