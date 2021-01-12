package com.example.myapplication;

import android.Manifest;
import android.app.Instrumentation;
import android.bluetooth.BluetoothAdapter;
import android.content.Context;
import android.content.Intent;
import android.gesture.GesturePoint;
import android.graphics.Point;
import android.graphics.Rect;
import android.net.Uri;
import android.view.MotionEvent;

import androidx.test.platform.app.InstrumentationRegistry;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.rule.GrantPermissionRule;
import androidx.test.uiautomator.By;
import androidx.test.uiautomator.BySelector;
import androidx.test.uiautomator.Direction;
import androidx.test.uiautomator.UiDevice;
import androidx.test.uiautomator.UiObject;
import androidx.test.uiautomator.UiObject2;
import androidx.test.uiautomator.UiObjectNotFoundException;
import androidx.test.uiautomator.UiSelector;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {
    @Rule
    public GrantPermissionRule permissionRule = GrantPermissionRule.grant(
            Manifest.permission.BLUETOOTH,
            Manifest.permission.BLUETOOTH_ADMIN
    );

    @Test
    public void useAppContext() throws UiObjectNotFoundException, InterruptedException {
        for (int x =0;x<10;x++) {
            UiDevice uiDevice = UiDevice.getInstance(InstrumentationRegistry.getInstrumentation());
            Context context = InstrumentationRegistry.getInstrumentation().getTargetContext();
            String format = "geo:0,0?q=" + Double.toString(50.42) + "," + Double.toString(30.50) + "(" + 5 + ")";
            Uri uri = Uri.parse(format);
            Intent intent = new Intent(Intent.ACTION_VIEW, uri);
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(intent);

            Thread.sleep(2000);
            UiObject map = uiDevice.findObject(new UiSelector().resourceId("com.google.android.apps.maps:id/action_bar_root"));

            Rect rect = map.getBounds();
            int centerX = rect.centerX();
            int centerY = rect.centerY();


            MotionEvent.PointerCoords point1 = new MotionEvent.PointerCoords();
            point1.x = centerX - 50;
            point1.y = centerY;
            point1.pressure = 1;
            point1.size = 1;

            MotionEvent.PointerCoords point2 = new MotionEvent.PointerCoords();
            point2.x = centerX - 40;
            point2.y = centerY - 20;
            point2.pressure = 1;
            point2.size = 1;

            MotionEvent.PointerCoords point3 = new MotionEvent.PointerCoords();
            point3.x = centerX - 30;
            point3.y = centerY - 40;
            point3.pressure = 1;
            point3.size = 1;

            MotionEvent.PointerCoords point4 = new MotionEvent.PointerCoords();
            point4.x = centerX - 20;
            point4.y = centerY - 70;
            point4.pressure = 1;
            point4.size = 1;

            MotionEvent.PointerCoords point5 = new MotionEvent.PointerCoords();
            point5.x = centerX - 10;
            point5.y = centerY - 90;
            point5.pressure = 1;
            point5.size = 1;


            // ---------------


            MotionEvent.PointerCoords point11 = new MotionEvent.PointerCoords();
            point11.x = centerX + 50;
            point11.y = centerY;
            point11.pressure = 1;
            point11.size = 1;

            MotionEvent.PointerCoords point22 = new MotionEvent.PointerCoords();
            point22.x = centerX + 40;
            point22.y = centerY + 20;
            point22.pressure = 1;
            point22.size = 1;

            MotionEvent.PointerCoords point33 = new MotionEvent.PointerCoords();
            point33.x = centerX + 30;
            point33.y = centerY + 40;
            point33.pressure = 1;
            point33.size = 1;

            MotionEvent.PointerCoords point44 = new MotionEvent.PointerCoords();
            point44.x = centerX + 20;
            point44.y = centerY + 70;
            point44.pressure = 1;
            point44.size = 1;

            MotionEvent.PointerCoords point55 = new MotionEvent.PointerCoords();
            point55.x = centerX + 10;
            point55.y = centerY + 90;
            point55.pressure = 1;
            point55.size = 1;


            MotionEvent.PointerCoords[] pointerCoordsArray = new MotionEvent.PointerCoords[]{point1, point2, point3, point4,point5};
            MotionEvent.PointerCoords[] pointerCoordsArray2 = new MotionEvent.PointerCoords[]{point11, point22, point33, point44,point55};



            uiDevice.swipe(centerX, centerY, centerX + 200, centerY, 20);
            Thread.sleep(500);
            uiDevice.swipe(centerX, centerY, centerX + 200, centerY - 50, 20);
            Thread.sleep(500);
            uiDevice.swipe(centerX, centerY, centerX + 200, centerY - 50, 20);
            Thread.sleep(500);
            uiDevice.swipe(centerX, centerY, centerX + 200, centerY + 100, 20);
            Thread.sleep(500);
            uiDevice.swipe(centerX, centerY, centerX + 200, centerY + 100, 20);
            Thread.sleep(2500);

            map.performMultiPointerGesture(
                    pointerCoordsArray,
                    pointerCoordsArray2
            );

            Thread.sleep(3500);

            uiDevice.swipe(centerX, centerY, centerX + 100, centerY - 200, 20);
            Thread.sleep(500);
            uiDevice.swipe(centerX, centerY, centerX + 100, centerY - 200, 20);
            Thread.sleep(500);
            uiDevice.swipe(centerX, centerY, centerX + 50, centerY - 200, 20);
            Thread.sleep(500);
            uiDevice.swipe(centerX, centerY, centerX - 50, centerY - 200, 20);
            Thread.sleep(500);
            uiDevice.swipe(centerX, centerY, centerX - 100, centerY - 200, 20);
            Thread.sleep(500);
            uiDevice.swipe(centerX, centerY, centerX - 100, centerY - 200, 20);
            Thread.sleep(500);
            uiDevice.swipe(centerX, centerY, centerX - 100, centerY - 200, 20);
            Thread.sleep(500);
            uiDevice.swipe(centerX, centerY, centerX + 100, centerY - 200, 20);
            Thread.sleep(500);
            uiDevice.swipe(centerX, centerY, centerX , centerY - 200, 20);
            Thread.sleep(500);
            uiDevice.swipe(centerX, centerY, centerX + 200, centerY, 20);
            Thread.sleep(500);
            uiDevice.swipe(centerX, centerY, centerX + 200, centerY, 20);
            Thread.sleep(500);
            uiDevice.swipe(centerX, centerY, centerX + 200, centerY, 20);
            Thread.sleep(2500);

            map.performMultiPointerGesture(
                    pointerCoordsArray,
                    pointerCoordsArray2
            );

            Thread.sleep(2500);

            uiDevice.swipe(centerX, centerY, centerX - 50, centerY+200, 20);
            Thread.sleep(2500);


        }

    }


}