package com.mycompany.a3.ImmovableObjects;
import com.codename1.charts.models.Point;
import com.mycompany.a3.*;
// Fixed Objects class
public abstract class FixedObjects extends GameObjects{
    public FixedObjects(int size, int color) {
    	super(size, color);
    }
    @Override
    // To not allow a new location to be set for these objects
    public void setLocation(Point x) {
    	
    }
    // toString method
    public String toString() {
    	return super.toString();
    }
}