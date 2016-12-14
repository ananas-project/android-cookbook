package com.boluozhai.androidcookbook;

import android.hardware.Camera;
import android.os.Bundle;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import com.boluozhai.androidcookbook.life.AbstractLife;
import com.boluozhai.androidcookbook.life.LifeCompatActivity;

import java.io.IOException;


public class CameraActivity extends LifeCompatActivity {


    private SurfaceHolder mSurfaceHolder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_camera);

        SurfaceView surfaceView = (SurfaceView) findViewById(R.id.surface_view);
        mSurfaceHolder = surfaceView.getHolder();
        mSurfaceHolder.addCallback(new CameraCtrl());

    }


    @Override
    public void onCreating(Bundle savedInstanceState) {
        super.onCreating(savedInstanceState);
        //     LifeManager life_man = this.getLifeManager();
        //   life_man.add(new CameraCtrl());
    }


    private class AutoFocusHandler implements Camera.AutoFocusCallback {


        @Override
        public void onAutoFocus(boolean b, Camera camera) {

        }

    }

    private class CameraCtrl extends AbstractLife implements SurfaceHolder.Callback {


        private Camera mCamera;


        public CameraCtrl() {
        }


        @Override
        public void surfaceCreated(SurfaceHolder surfaceHolder) {


            try {

                //  = Camera.class ;
                mCamera = Camera.open();

                //settings

                Camera.Parameters settings = mCamera.getParameters();
                settings.setPreviewFrameRate(10);


                mCamera.setParameters(settings);
                mCamera.setDisplayOrientation(90);

                // bind
                mCamera.setPreviewDisplay(surfaceHolder);


                //AF
                AutoFocusHandler af = new AutoFocusHandler();
                mCamera.autoFocus(af);


                //start
                mCamera.startPreview();


            } catch (IOException e) {
                e.printStackTrace();

            } finally {

            }


        }

        @Override
        public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i1, int i2) {

        }

        @Override
        public void surfaceDestroyed(SurfaceHolder surfaceHolder) {

            Camera cam = mCamera;
            if (cam != null) {
                mCamera = null;
                cam.stopPreview();
                cam.release();
            }

        }
    }


}
