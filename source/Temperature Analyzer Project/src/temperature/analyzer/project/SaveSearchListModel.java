package temperature.analyzer.project;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import javax.swing.event.ListDataListener;
import javax.swing.ListModel;
import java.util.ArrayList;
import static java.util.Arrays.sort;

/** Implement ListModel for use in Search module's rendering of location list.
 *
 * @author rcatlett
 */
public class SaveSearchListModel implements ListModel<String> {
    private final ArrayList<ListDataListener> listeners;
    private String[] locations;
    
    public SaveSearchListModel() {
        this.locations = null;
        this.listeners = new ArrayList<>();
    }
    
    public SaveSearchListModel(String[] locations) {
        this.locations = locations;
        this.listeners = new ArrayList<>();
    }
    
    public SaveSearchListModel(ArrayList<String> locations) {
        String[] temp = new String[locations.size()];
        // Use for-loop because casting locations.toArray() to type String[]
        // causes a runtime exception since Java's type rules are STUPID
        for (int i = 0; i < locations.size(); i++) {
            temp[i] = locations.get(i);
        }
        sort(temp);
        this.locations = temp;
        this.listeners = new ArrayList<>();
    }
    
    public void setLocationArray(String[] locations) {
        this.locations = locations;
    }
    
    public boolean isNull() {
        return locations == null;
    }
    
    public boolean isEmpty() {
        return locations.length == 0;
    }
    
    public ArrayList<String> getArrayList() {
        ArrayList<String> temp = new ArrayList<>();
        for (String s : locations) {
            temp.add(s);
        }
        return temp;
    }
    
    
    @Override
    public void addListDataListener(ListDataListener l) {
        listeners.add(l);
    }
    
    @Override
    public String getElementAt(int index) {
        return locations[index];
    }
    
    @Override
    public int getSize() {
        return locations.length;
    }
    
    @Override
    public void removeListDataListener(ListDataListener l) {
        listeners.remove(l);
    }
}
