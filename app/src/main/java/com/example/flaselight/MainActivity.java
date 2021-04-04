package com.example.flaselight;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraManager;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;
import android.widget.ToggleButton;

@RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
public class MainActivity extends AppCompatActivity {
private ToggleButton btn;
private CameraManager cameraManager;
private String getCameraId;
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn=findViewById(R.id.toggle_btn);
        cameraManager= (CameraManager) getSystemService(CAMERA_SERVICE);
        try {
            getCameraId=cameraManager.getCameraIdList()[0];
        } catch (CameraAccessException e) {
            e.printStackTrace();
        }
    }
    @RequiresApi(api = Build.VERSION_CODES.M)
    public void ToggleFlashLight(View view){
        if(btn.isChecked()){
            try {
                cameraManager.setTorchMode(getCameraId,true);
                Toast.makeText(this,"flash light On:",Toast.LENGTH_SHORT).show();
            } catch (CameraAccessException e) {
                e.printStackTrace();
            }
        }else{
            try {
                cameraManager.setTorchMode(getCameraId,false);
                Toast.makeText(this,"flash light Off:",Toast.LENGTH_SHORT).show();
            } catch (CameraAccessException e) {
                e.printStackTrace();
            }
        }
    }
}