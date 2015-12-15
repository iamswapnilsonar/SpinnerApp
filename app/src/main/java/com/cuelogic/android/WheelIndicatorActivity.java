package com.cuelogic.android;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/**
 * @author Swapnil Sonar
 * @version 1.0.0
 * @Date 15/12/2015
 */
public class WheelIndicatorActivity extends Activity {

    private WheelIndicatorView wheelIndicatorView;
    private Button btnRandomVal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wheel_indicator);

        wheelIndicatorView = (WheelIndicatorView) findViewById(R.id.wheel_indicator_view);
        wheelIndicatorView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        btnRandomVal = (Button) findViewById(R.id.btnRandomVal);
        btnRandomVal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int value = getRandomNumber(0, 20);
                value = value * 5;

                wheelIndicatorView.setFilledPercent(value);
                wheelIndicatorView.startItemsAnimation(); // Animate!

            }
        });

        int i = 0;
        do {

            float weight = 1.8f * i;
            wheelIndicatorView.addWheelIndicatorItem(new WheelIndicatorItem(weight,
                    Color.parseColor("#FFFFFF")));

            i++;
        } while (i < 20);


        wheelIndicatorView.setFilledPercent(30);

        // Or you can add it as
        //wheelIndicatorView.setWheelIndicatorItems(Arrays.asList(runningActivityIndicatorItem,walkingActivityIndicatorItem,bikeActivityIndicatorItem));

        wheelIndicatorView.startItemsAnimation(); // Animate!
    }

    private int getRandomNumber(int min, int max) {
        return (min + (int)(Math.random() * ((max - min) + 1)));
    }
}
