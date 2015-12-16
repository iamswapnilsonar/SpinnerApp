package com.cuelogic.android;

import android.app.Activity;
import android.graphics.Color;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.List;

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
        wheelIndicatorView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {

//                Toast.makeText(WheelIndicatorActivity.this, "Got Touch", Toast.LENGTH_SHORT).show();

                int xTouch = (int) event.getX();
                int yTouch = (int) event.getY();

                List<WheelIndicatorItem> listIndicatorItems = wheelIndicatorView.getWheelIndicatorItems();

                outer:
                for (int i = 0; i < listIndicatorItems.size(); i++) {

                    WheelIndicatorItem item = listIndicatorItems.get(i);
                    Rect rectangle = item.getRect();

                    if(rectangle.contains(xTouch, yTouch)) {

                        Toast.makeText(WheelIndicatorActivity.this, "Animate the view!", Toast.LENGTH_SHORT).show();

                        int value = item.getValue() * 5;
                        wheelIndicatorView.setFilledPercent(value);
                        wheelIndicatorView.startItemsAnimation(); // Animate!

                        break outer;
                    }

                }

                return false;
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
                    Color.parseColor("#FFFFFF"), i));

            i++;
        } while (i < 20);


        wheelIndicatorView.setFilledPercent(100);

        // Or you can add it as
        //wheelIndicatorView.setWheelIndicatorItems(Arrays.asList(runningActivityIndicatorItem,walkingActivityIndicatorItem,bikeActivityIndicatorItem));

        wheelIndicatorView.startItemsAnimation(); // Animate!
    }

    private int getRandomNumber(int min, int max) {
        return (min + (int) (Math.random() * ((max - min) + 1)));
    }
}
