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
 * @author james
 */
public class SensorListModel implements ListModel<String> {
    private final ArrayList<ListDataListener> listeners;
    private String[] sensors;
    
    public SensorListModel() {
        this.sensors = null;
        this.listeners = new ArrayList<>();
    }
    
    public SensorListModel(String[] sens) {
        this.sensors = sens;
        this.listeners = new ArrayList<>();
    }
    
    public SensorListModel(ArrayList<String> sens) {
        String[] sensorList = new String[sens.size()];
        // Use for-loop because casting locations.toArray() to type String[]
        // causes a runtime exception since Java's type rules are STUPID
        for (int i = 0; i < sens.size(); i++) {
            sensorList[i] = sens.get(i);
        }
        sort(sensorList);
        this.sensors = sensorList;
        this.listeners = new ArrayList<>();
    }
    
    public void setLocationArray(String[] sens) {
        this.sensors = sens;
    }
    
    public boolean isNull() {
        return sensors == null;
    }
    
    public boolean isEmpty() {
        return sensors.length == 0;
    }
    
    public ArrayList<String> getArrayList() {
        ArrayList<String> sensList = new ArrayList<>();
        for (String s : sensors) {
            sensList.add(s);
        }
        return sensList;
    }
    
    
    @Override
    public void addListDataListener(ListDataListener l) {
        listeners.add(l);
    }
    
    @Override
    public String getElementAt(int index) {
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
