package com.carcompany.consoleconnector;

import java.util.HashMap;
import java.util.Map;

public class Clipboard {



    static private Clipboard clipboard;


    private Map<String, Object> map;



    Clipboard(){

        this.map = new HashMap<String, Object>();


    }


    public static Clipboard getInstance(){
        if(clipboard == null) clipboard = new Clipboard();
        return clipboard;

    }

    
    public Object retrieve(String key){
        Object object = map.get(key);
        map.remove(key);
        return object;
    }

    public Object get(String key){

        return object = map.get(key);


    }
    public String store(String key, Object object){


        return null;
    }




    
    
}
