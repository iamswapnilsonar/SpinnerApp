package com.cardinalsolutions.progressindicator.wheel_indicator;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.cardinalsolutions.progressindicator.R;

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

        //WheelIndicatorView wheelIndicatorView = new WheelIndicatorView(this);

        // dummy data
        float dailyKmsTarget = 4.0f; // 4.0Km is the user target, for example
        float totalKmsDone = 3.0f; // User has done 3 Km
        int percentageOfExerciseDone = (int) (totalKmsDone / dailyKmsTarget * 100); //

//        wheelIndicatorView.setFilledPercent(percentageOfExerciseDone);

//        WheelIndicatorItem bikeActivityIndicatorItem = new WheelIndicatorItem(0f, Color.parseColor("#FF9000"));
//
////        WheelIndicatorItem walkingActivityIndicatorItem = new WheelIndicatorItem(0.9f, Color.argb(255, 194, 30, 92));
////        WheelIndicatorItem runningActivityIndicatorItem = new WheelIndicatorItem(0.3f,
////                getResources().getColor(R.color.my_wonderful_blue_color));
//
//        wheelIndicatorView.addWheelIndicatorItem(bikeActivityIndicatorItem);
//        wheelIndicatorView.addWheelIndicatorItem(new WheelIndicatorItem(1.8f,
//                Color.parseColor("#FF9000")));
//
//        wheelIndicatorView.addWheelIndicatorItem(new WheelIndicatorItem(3.6f,
//                Color.parseColor("#FFFFFF")));
//
//        wheelIndicatorView.addWheelIndicatorItem(new WheelIndicatorItem(5.4f,
//                Color.parseColor("#FFFFFF")));

        int i = 0;
        do {

            float weight = 1.8f * i;
            wheelIndicatorView.addWheelIndicatorItem(new WheelIndicatorItem(weight,
                    Color.parseColor("#FFFFFF")));

            i++;
        } while (i < 20);


        wheelIndicatorView.setFilledPercent(30);

//        wheelIndicatorView.addWheelIndicatorItem(walkingActivityIndicatorItem);
//        wheelIndicatorView.addWheelIndicatorItem(runningActivityIndicatorItem);

        // Or you can add it as
        //wheelIndicatorView.setWheelIndicatorItems(Arrays.asList(runningActivityIndicatorItem,walkingActivityIndicatorItem,bikeActivityIndicatorItem));

        wheelIndicatorView.startItemsAnimation(); // Animate!
    }

    private int getRandomNumber(int min, int max) {
        return (min + (int)(Math.random() * ((max - min) + 1)));
    }
}
