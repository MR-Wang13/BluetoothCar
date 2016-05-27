package com.example.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import java.io.IOException;

import java.io.OutputStream;
import java.util.UUID;

import android.app.Activity;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;

import android.bluetooth.BluetoothSocket;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

import android.os.Bundle;
import android.provider.ContactsContract.CommonDataKinds.Event;

import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

import android.widget.Button;
import android.widget.Toast;



public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    private static final boolean D = true;
    private BluetoothAdapter mBluetoothAdapter = null;
    private BluetoothSocket btSoket = null;
    private OutputStream outStream = null;
    Button mButtonF;
    Button mButtonB;
    Button mButtonL;
    Button mButtonR;
    Button mButtonS;

    private static final UUID MY_UUID = UUID.fromString("00001101-0000-1000-8000-00805F9B34FB");

    private static String address = "98:D3:32:10:58:71";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //前进
        mButtonF=(Button)findViewById(R.id.btnF);
        mButtonF.setOnTouchListener(new Button.OnTouchListener(){
            @Override
            public boolean onTouch(View v, MotionEvent event){
                String message;
                byte[] msgBuffer;
                int action = event.getAction();
                switch(action)
                {
                    case MotionEvent.ACTION_DOWN:
                        try{
                           outStream = btSoket.getOutputStream();
                        }catch(IOException e){
                            Log.e(TAG,"ON RESUME: Output stream creation failed.",e);
                        }
                        message = "1";
                        msgBuffer = message.getBytes();
                        try{
                            outStream.write(msgBuffer);
                        }catch (IOException e){
                            Log.e(TAG,"ON RESUME: Exception during write.",e);
                        }
                        break;

                    case MotionEvent.ACTION_UP:
                        try{
                            outStream = btSoket.getOutputStream();
                        }catch(IOException e){
                            Log.e(TAG,"ON RESUME: Output stream creation failed.",e);
                        }
                        message = "0";
                        msgBuffer = message.getBytes();

                        try{
                            outStream.write(msgBuffer);
                        }catch (IOException e){
                            Log.e(TAG,"ON RESUME: Exception during write.",e);
                        }
                        break;
                }
                return false;
            }
        });
        //Backward
        mButtonB=(Button)findViewById(R.id.btnB);
        mButtonB.setOnTouchListener(new Button.OnTouchListener(){
            @Override
            public boolean onTouch(View v,MotionEvent event){
                //TODO Auto-generated method stub
                String message;
                byte[] msgBuffer;
                int action = event.getAction();
                switch(action)
                {
                    case MotionEvent.ACTION_DOWN:
                        try{
                            outStream = btSoket.getOutputStream();
                        }catch (IOException e){
                            Log.e(TAG, "ON RESUME: Output stream creation failed.",e);
                        }
                        message = "3";
                        msgBuffer = message.getBytes();
                        try{
                            outStream.write(msgBuffer);
                        }catch(IOException e){
                            Log.e(TAG, "ON RESUME: Exceptiopn during write.",e);
                        }
                        break;
                    case MotionEvent.ACTION_UP:
                        try{
                            outStream = btSoket.getOutputStream();
                        }catch(IOException e){
                            Log.e(TAG,"ON RESUME:Output stram creation failed.",e);
                        }
                        message = "0";
                        msgBuffer = message.getBytes();
                        try{
                            outStream.write(msgBuffer);
                        }catch(IOException e){
                            Log.e(TAG,"ON RESUME: Exception during write.",e);
                        }
                        break;
                }
                return false;
            }
        });

        //Turn Left
        mButtonL=(Button)findViewById(R.id.btnL);
        mButtonL.setOnTouchListener(new Button.OnTouchListener(){

            @Override
            public boolean onTouch(View v,MotionEvent event){
                //TODO Auto-generated method stub
                String message;
                byte[] msgBuffer;
                int action = event.getAction();
                switch(action)
                {
                    case MotionEvent.ACTION_DOWN:
                        try{
                            outStream = btSoket.getOutputStream();
                        }catch(IOException e){
                            Log.e(TAG,"ON RESUME: Output stream creation failed.",e);
                        }
                        message = "2";
                        msgBuffer = message.getBytes();
                        try{
                            outStream.write(msgBuffer);
                        }catch(IOException e){
                            Log.e(TAG,"ON RESUME:Exception during write.",e);
                        }
                        break;
                    case MotionEvent.ACTION_UP:
                        try{
                            outStream = btSoket.getOutputStream();
                        }catch(IOException e){
                            Log.e(TAG,"ON RESUME: Output stream creation failed.",e);
                        }

                        message = "0";
                        msgBuffer = message.getBytes();
                        try{
                            outStream.write(msgBuffer);
                        }catch(IOException e){
                            Log.e(TAG,"ON RESUME: Exception during write.",e);
                        }
                        break;
                }
                return false;
            }
        });

        //Turn Right
        mButtonR = (Button)findViewById(R.id.btnR);
        mButtonR.setOnTouchListener(new Button.OnTouchListener(){

            @Override
            public boolean onTouch(View v,MotionEvent event){
                //TODO Auto-generated method stub
                String message;
                byte[] msgBuffer;
                int action = event.getAction();
                switch(action)
                {
                    case MotionEvent.ACTION_DOWN:
                        try{
                            outStream = btSoket.getOutputStream();
                        }catch(IOException e){
                            Log.e(TAG,"ON RESUME: Output stream creation failed.",e);
                        }
                        message = "4";
                        msgBuffer = message.getBytes();
                        try{
                            outStream.write(msgBuffer);
                        }catch(IOException e){
                            Log.e(TAG,"ON RESUME:Exception during write.",e);
                        }
                        break;
                    case MotionEvent.ACTION_UP:
                        try{
                            outStream = btSoket.getOutputStream();
                        }catch(IOException e){
                            Log.e(TAG,"ON RESUME: Output stream creation failed.",e);
                        }
                        message = "0";
                        msgBuffer = message.getBytes();
                        try{
                            outStream.write(msgBuffer);
                        }catch(IOException e){
                            Log.e(TAG,"ON RESUME: Exception during write.",e);
                        }
                        break;
                }
                return false;
            }
        });

        //Stop
        mButtonS = (Button)findViewById(R.id.btnS);
        mButtonS.setOnTouchListener(new Button.OnTouchListener(){

            @Override
            public boolean onTouch(View v,MotionEvent event){
                //TODO Auto-generated method stub
                if(event.getAction()==MotionEvent.ACTION_DOWN)
                    try{
                        outStream = btSoket.getOutputStream();
                    }catch(IOException e){
                        Log.e(TAG,"ON RESUME: Output stream creation failed.",e);
                    }
                String message = "0";
                byte[] msgBuffer = message.getBytes();
                try{
                    outStream.write(msgBuffer);
                }catch(IOException e){
                    Log.e(TAG,"ON RESUME: Exception during write.",e);
                }
                return false;
            }
        });

        if(D)
            Log.e(TAG,"+++ON CREATE+++");
        mBluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        if(mBluetoothAdapter == null){
            Toast.makeText(this,"Bluetooth is not available.",Toast.LENGTH_LONG).show();
            finish();
            return;
        }
        if(!mBluetoothAdapter.isEnabled()){
            Toast.makeText(this,"Please enable your Bluetooth and re-run this program.",Toast.LENGTH_LONG).show();
            finish();
            return;
        }
        if(D)
            Log.e(TAG,"+++DONE IN ON CREATE,GOT LOCAL BT ADAPTER+++");
    }

    @Override
    protected void onStart() {
        super.onStart();
        if(D)Log.e(TAG,"++ON START++");
    }
    public void onResume(){
        super.onResume();
        if(D){
            Log.e(TAG,"+ON RESUME+");
            Log.e(TAG,"+ABOUT TO ATTEMPT CLIENT CONNECT+");
        }
        BluetoothDevice device = mBluetoothAdapter.getRemoteDevice(address);
        try{
            btSoket = device.createRfcommSocketToServiceRecord(MY_UUID);
        }catch(IOException e){
            Log.e(TAG,"ON RESUME: Socket creation failed.",e);
        }
        mBluetoothAdapter.cancelDiscovery();
        try{
            btSoket.connect();
            Log.e(TAG,"ON RESUME:BT connection established, data transfer link open.");
        }catch(IOException e){
            try{
                btSoket.close();
            }catch(IOException e2){
                Log.e(TAG,"ON RESUME:Unable to close socket during connection failure.",e2);
            }
        }
        //Create a data stream so we can talk to server.
        if(D)
            Log.e(TAG,"+ABOUT TO SAY SOMETHING TO SERVER+");
        /*try{
            outputStream = btSocket.getOutputStream();
        }catch(IOException e){
            Log.e(TAG,"ON RESUME:Output stream creation failed.",e);
        }
        String message = "1";
        byte[] msgBuffer = message.getBytes();
        try{
            outputStream.write(msgBuffer);
        }catch(IOException e){
            Log.e(TAG, "ON RESUME: Exception during write.",e);
        }
        */
    }
    @Override
    public void onPause(){
        super.onPause();
        if(D)
            Log.e(TAG,"-ON PAUSE-");
        if(outStream != null){
            try{
                outStream.flush();
            }catch(IOException e){
                Log.e(TAG,"ON PAUSE: Couldn't flush output stream.",e);
            }
        }
        try{
            btSoket.close();
        }catch(IOException e2){
            Log.e(TAG,"ON PAUSE:Unable to close socket.",e2);
        }
    }
    @Override
    public void onStop(){
        super.onStop();
        if(D)Log.e(TAG,"-ON STOP-");
    }
    @Override
    public void onDestroy(){
        super.onDestroy();
        if(D)
            Log.e(TAG,"--ON DESTROY--");
    }
}
