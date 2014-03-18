package com.example.TelephonyManagerExample;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.widget.TextView;

public class MyActivity extends Activity {

    private TextView textView;
    private TelephonyManager telephonyManager;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        textView = (TextView)findViewById(R.id.textview);

        telephonyManager = (TelephonyManager) getSystemService(Context.TELEPHONY_SERVICE);

        getPhoneState();
        append("DeviceId", telephonyManager.getDeviceId());
        append("DeviceSoftwareVersion", telephonyManager.getDeviceSoftwareVersion());
        append("Line1Number", telephonyManager.getLine1Number());
        append("Subscriber", telephonyManager.getSubscriberId());
        append("NetworkCountryISO", telephonyManager.getNetworkCountryIso());
        append("NetworkOperator", telephonyManager.getNetworkOperator());
        append("NetworkOperatorName", telephonyManager.getNetworkOperatorName());
        append("SimCountryISO", telephonyManager.getSimCountryIso());
        append("SimOperator", telephonyManager.getSimOperator());
        append("SimOperatorName", telephonyManager.getSimOperatorName());
        append("SimSerialNumber", telephonyManager.getSimSerialNumber());
        append("VoiceMailNumber", telephonyManager.getVoiceMailNumber());
        append("VoiceMailAlphaTag", telephonyManager.getVoiceMailAlphaTag());
    }

    private void append(String title, String message){
        textView.append(title + ": " + message + "\n");
    }

    private void getPhoneState(){
        int phoneState = telephonyManager.getPhoneType();
        String phoneType = "";

        switch (phoneState){
            case 0: phoneType = "NONE";
                break;
            case 1: phoneType = "GSM";
                break;
            case 2: phoneType = "CDMA";
                break;
            case 3: phoneType = "SIP";
                break;

        }

        append("PhoneType", phoneType);
    }

}
