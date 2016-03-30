package temperature.analyzer.project;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import javax.swing.event.ListDataListener;
import javax.swing.ListModel;
import java.util.ArrayList;

/** Implement ListModel for use in Search module's rendering of location list.
 *
 * @author james
 */
public class SensorListModel implements ListModel<Integer> {
    private final ArrayList<ListDataListener> listeners;
    private Integer[] sensors;
    
    public SensorListModel() {
        this.sensors = null;
        this.listeners = new ArrayList<>();
    }
    
    public SensorListModel(Integer[] sens) {
        this.sensors = sens;
        this.listeners = new ArrayList<>();
    }
    
    public SensorListModel(ArrayList<Integer> sens) {
        Integer[] sensorList = new Integer[sens.size()];
        // Use for-loop because casting locations.toArray() to type String[]
        // causes a runtime exception since Java's type rules are STUPID
        for (int i = 0; i < sens.size(); i++) {
            sensorList[i] = sens.get(i);
        }
        this.sensors = sensorList;
        this.listeners = new ArrayList<>();
    }
    
    public void setLocationArray(Integer[] sens) {
        this.sensors = sens;
    }
    
    public boolean isNull() {
        return sensors == null;
    }
    
    public boolean isEmpty() {
        return sensors.length == 0;
    }
    
    public ArrayList<Integer> getArrayList() {
        ArrayList<Integer> sensList = new ArrayList<>();
        for (Integer s : sensors) {
            sensList.add(s);
        }
        return sensList;
    }
    
    
    @Override
    public void addListDataListener(ListDataListener l) {
        listeners.add(l);
    }
    
    @Override
    public Integer getElementAt(int index) {
        return sensors[index];
    }
    
    @Override
    public int getSize() {
        return sensors.length;
    }
    
    @Override
    public void removeListDataListener(ListDataListener l) {
        listeners.remove(l);
    }
}
