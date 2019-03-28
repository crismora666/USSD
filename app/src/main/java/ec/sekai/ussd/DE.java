package ec.sekai.ussd;

import android.accessibilityservice.AccessibilityService;
import android.accessibilityservice.AccessibilityServiceInfo;
import android.content.Intent;
import android.util.Log;
import android.view.accessibility.AccessibilityEvent;

public class DE extends AccessibilityService {
    public static String TAG = "DE";

    @Override
    public void onAccessibilityEvent(AccessibilityEvent event){
        Log.d(TAG, "onAccessibilityEvent");
        System.out.println("onAccessibilityEvent");
        String text = event.getText().toString();

        if(event.getClassName().equals("android.app.AlertDialog")){
            performGlobalAction(GLOBAL_ACTION_BACK);
            Log.d(TAG,text);
            Intent intent = new Intent("com.times.ussd.action.REFRESH");
            intent.putExtra("message",text);
            //****
        }
    }

    @Override
    public void onInterrupt(){

    }

    @Override
    protected void onServiceConnected(){
        super.onServiceConnected();
        Log.d(TAG, "onServiceConnected");
        AccessibilityServiceInfo info = new AccessibilityServiceInfo();
        info.flags = AccessibilityServiceInfo.DEFAULT;
        info.eventTypes = AccessibilityEvent.TYPE_WINDOW_STATE_CHANGED;
        info.feedbackType = AccessibilityServiceInfo.FEEDBACK_GENERIC;
        setServiceInfo(info);
    }
}
