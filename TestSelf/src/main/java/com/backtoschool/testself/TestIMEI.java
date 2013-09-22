package com.backtoschool.testself;

import android.app.Activity;
import android.content.Context;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by Shana on 9/22/13.
 */
public class TestIMEI extends Activity {

    Button bt;
    TextView txt_View;

    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.testimei_layout);

        bt=(Button)findViewById(R.id.button1);
        txt_View =(TextView)findViewById(R.id.textView1);
        bt.setOnClickListener((View.OnClickListener) this);

    }


    public void onClick(View v) {
        // TODO Auto-generated method stub

        String imeistring=null;
        String imsistring=null;


        TelephonyManager telephonyManager  = (TelephonyManager)getSystemService( Context.TELEPHONY_SERVICE );

       /*
        * getDeviceId() function Returns the unique device ID.
        * for example,the IMEI for GSM and the MEID or ESN for CDMA phones.
        */
        imeistring = telephonyManager.getDeviceId();
        txt_View.append("IMEI No : "+imeistring+"\n");


       /*
        * getSubscriberId() function Returns the unique subscriber ID,
        * for example, the IMSI for a GSM phone.
        */
        imsistring = telephonyManager.getSubscriberId();
        txt_View.append("IMSI No : "+imsistring+"\n");

/*
        * returns the MacAddress
        */

        WifiManager wifiManager =
                (WifiManager) getSystemService(Context.WIFI_SERVICE);
        WifiInfo wInfo = wifiManager.getConnectionInfo();
        String macAddress = wInfo.getMacAddress();
        if (macAddress == null)
            txt_View.append( "MAC Address : " + macAddress + "\n" );
        else
            txt_View.append( "MAC Address : " + macAddress + "\n" );
    }

}
