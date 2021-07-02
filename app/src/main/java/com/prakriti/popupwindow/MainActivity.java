package com.prakriti.popupwindow;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;

public class MainActivity extends AppCompatActivity {

    private PopupWindow popupWindow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RelativeLayout relativeLayout = findViewById(R.id.relativeLayout); // in activity_main.xml

        findViewById(R.id.btnPopup).setOnClickListener(v -> {
            // inflate layout for popup
            LayoutInflater inflater = (LayoutInflater) getBaseContext().getSystemService(LAYOUT_INFLATER_SERVICE);
            View popupView = inflater.inflate(R.layout.popup_window, null); // root is null as popup window will be on activity_main.xml

            // create Popup Window obj, pass context, width & height of window
            popupWindow = new PopupWindow(popupView, RelativeLayout.LayoutParams.MATCH_PARENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
                // parent is Relative L/O
            popupWindow.showAtLocation(relativeLayout, Gravity.CENTER, 0,0);
                // location of window inside activity -> pass parent, gravity, X & Y


            // init Popup Window UI using inflated View
            popupView.findViewById(R.id.btnClose).setOnClickListener(v1 -> {
                popupWindow.dismiss();
            });
        });
    }

}