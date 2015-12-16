/*
 * Copyright (C) 2015 David Lázaro Esparcia
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.cuelogic.android;

import android.graphics.Rect;

/**
 * Created by david on 23/5/15.
 */
public class WheelIndicatorItem {

    private float weight;
    private int color;
    private int value;

    private Rect rect;

    public WheelIndicatorItem() {
        weight = 0;
        value = 0;
    }

    public WheelIndicatorItem(float weight, int color, int value) {
        if (weight < 0)
            throw new IllegalArgumentException("weight value should be positive");

        this.weight = weight;
        this.color = color;
        this.value = value;
    }

    public void setWeight(float weight) {
        if (weight < 0)
            throw new IllegalArgumentException("weight value should be positive");

        this.weight = weight;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public Rect getRect() {
        return rect;
    }

    public void setRect(Rect rect) {
        this.rect = rect;
    }

    public float getWeight() {
        return weight;
    }

    public void setColor(int color) {
        this.color = color;
    }

    public int getColor() {
        return color;
    }

}
