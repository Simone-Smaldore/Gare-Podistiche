package it.unibas.gestoreGare.modello;

import java.util.HashMap;
import java.util.Map;

public class Modello {
    
    private Map<String, Object> beans = new HashMap<>();
    
    public void putBean(String key, Object bean) {
        this.beans.put(key, bean);
    }
    
    public Object getBean(String key) {
        return this.beans.get(key);
    }
}
