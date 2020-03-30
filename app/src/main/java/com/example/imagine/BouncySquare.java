package com.example.imagine;

import android.opengl.GLSurfaceView;
//import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.WindowManager;

import androidx.appcompat.app.AppCompatActivity;

//import androidx.appcompat.app.AppCompatActivity;

public class BouncySquare extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        GLSurfaceView view = new GLSurfaceView(this);
        view.setRenderer(new SquareRenderer(this.getApplicationContext()));
        setContentView(view);

    }
}

// OKAY