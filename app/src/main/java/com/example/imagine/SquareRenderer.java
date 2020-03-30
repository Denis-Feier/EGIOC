package com.example.imagine;

import javax.microedition.khronos.opengles.GL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL11;
import android.opengl.GLSurfaceView;
import java.lang.Math;
import android.content.Context;

public class SquareRenderer implements GLSurfaceView.Renderer {

    private Square mSquare;
    private float mTransY=-1;
    private Context context;

    public SquareRenderer(Context context)
    {

        float squareColorsYMCA[] =
                {
                        1.0f, 1.0f, 0.0f, 1.0f,
                        0.0f, 1.0f, 1.0f, 1.0f,
                        0.0f, 0.0f, 0.0f, 1.0f,
                        1.0f, 0.0f, 1.0f, 1.0f
                };

        /*float squareColorsRGBA[] =
                {
                        1.0f, 0.0f, 0.0f, 1.0f,
                        0.0f, 1.0f, 0.0f, 1.0f,
                        0.0f, 0.0f, 1.0f, 1.0f,
                        1.0f, 1.0f, 1.0f, 1.0f
                };*/

        this.context = context;
        this.mSquare = new Square(squareColorsYMCA);
    }

    public void onDrawFrame(GL10 gl)
    {

        //lab 6
        gl.glClearColor(0.0f, 0.0f, 0.0f, 1.0f);
        gl.glClear(GL11.GL_COLOR_BUFFER_BIT | GL11.GL_DEPTH_BUFFER_BIT);
        gl.glMatrixMode(GL11.GL_MODELVIEW);

        gl.glLoadIdentity();
        gl.glTranslatef(0.0f,(float)Math.sin(mTransY), -3.0f);
        gl.glColor4f(0.0f, 0.0f, 1.0f, 1.0f);
        mSquare.draw(gl);

        gl.glLoadIdentity();
        gl.glTranslatef((float)(Math.sin(mTransY)/2.0f),0.0f, -2.9f);
        gl.glColor4f(1.0f, 0.0f, 0.0f, 1.0f);
        mSquare.draw(gl);
        mTransY += .075f;

        gl.glEnableClientState(GL10.GL_VERTEX_ARRAY);
        gl.glEnableClientState(GL10.GL_COLOR_ARRAY);

        gl.glEnable(GL10.GL_BLEND);
        mSquare.draw(gl);
    }




    public void onSurfaceChanged(GL10 gl, int width, int height)
    {
        gl.glViewport(0, 0, width, height);
        gl.glMatrixMode(GL10.GL_PROJECTION);
        gl.glLoadIdentity();

        float ratio = (float) width / height;
        gl.glFrustumf(-ratio, ratio, -1, 1, 1, 10);
    }

    public void onSurfaceCreated(GL10 gl, EGLConfig config)
    {

        //gl.glDisable(GL10.GL_DITHER);
        gl.glHint(GL10.GL_PERSPECTIVE_CORRECTION_HINT, GL10.GL_FASTEST);
        gl.glClearColor(0,0,50,100);
        gl.glEnable(GL10.GL_CULL_FACE);
        gl.glShadeModel(GL10.GL_SMOOTH);
        gl.glEnable(GL10.GL_DEPTH_TEST);




        gl.glDisable(GL11.GL_DITHER);

        gl.glHint(GL11.GL_PERSPECTIVE_CORRECTION_HINT,
                GL11.GL_FASTEST);

        gl.glClearColor(.0f,.5f,.5f,1.0f);


        gl.glEnable(GL11.GL_CULL_FACE);
        gl.glShadeModel(GL11.GL_SMOOTH);

        gl.glBlendFunc(GL10.GL_SRC_ALPHA, GL10.GL_ONE_MINUS_SRC_ALPHA);

        gl.glDisable(GL11.GL_DEPTH_TEST);
        gl.glEnable(GL11.GL_BLEND);

        mSquare.setTextures(gl,context,R.drawable.im1,R.drawable.im2);
    }


}