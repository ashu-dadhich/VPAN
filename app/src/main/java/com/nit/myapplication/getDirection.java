package com.nit.myapplication;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.util.Log;

/**
 * Created by dragneel on 11/12/17.
 */

public class getDirection implements SensorEventListener {

    private double currentDegree;
    private double bearingValue;
    public getDirection(double bearingVal)
    {
        currentDegree = 0f;
        bearingValue = bearingVal;
    }
    public double getRotationAngle() {

        //double degree = Math.round(new SensorEvent().values[0]);
        //currentDegree = -degree;
        return currentDegree;
    }

    @Override
    public void onSensorChanged(SensorEvent event) {

        float degree = Math.round(event.values[0]);
        Log.e("anglevalue", Float.toString(degree));
        currentDegree = -degree;
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {
    }
}
