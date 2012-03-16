package com.zonyitoo;

import min3d.core.Object3dContainer;
import min3d.core.RendererActivity;
import min3d.objectPrimitives.Box;
import min3d.vos.Color4;
import min3d.vos.Light;
import android.graphics.PointF;
import android.os.Bundle;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;

public class ExampleScrollingBox extends RendererActivity {
	Object3dContainer _box;
	Object3dContainer _desk;
	GestureDetector gestureDetec;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		gestureDetec = new GestureDetector(this, new GestureListener());
	}
	
	public void initScene() {
		
		
		Light light = new Light();
		//light.ambient.setAll((short)64, (short)64, (short)64, (short)255);
		//light.position.setAll(3, 3, 3);
		scene.lights().add(light);
		
		Color4[] colors = new Color4[6];
		colors[0] = new Color4(255,0,0,255);
		colors[1] = new Color4(0,255,0,255);
		colors[2] = new Color4(0,0,255,255);
		colors[3] = new Color4(255,255,0,255);
		colors[4] = new Color4(0,255,255,255);
		colors[5] = new Color4(255,0,255,255);
		
		Color4[] deskcolor = new Color4[6];
		for (int i = 0; i < 6; ++ i)
			deskcolor[i] = new Color4(0xFF, 0xFF, 0xFF, 0xFF);
		
		_box = new Box(.6f, .6f, .6f, colors, false, false, true);
		_box.normalsEnabled(false);
		_box.position().y = .5f;
		_desk = new Box(3f, 3f, .01f, deskcolor, false, false, true);
		_desk.rotation().x -= 40;
		
		scene.addChild(_box);
		scene.addChild(_desk);
	}
	/*
	@Override
	public void updateScene() {
		_box.rotation().y ++;
		_box.rotation().z ++;
		_box.rotation().x ++;
	}
	*/
	@Override
	public boolean onTouchEvent(MotionEvent event) {
		return gestureDetec.onTouchEvent(event);
	}
	
	class GestureListener extends GestureDetector.SimpleOnGestureListener {
		@Override
		public boolean onSingleTapUp(MotionEvent ev) {
			Log.d("GestureDbg", "onSingleTapUp ev " + ev.toString());
			return true;
		}
		
		@Override
		public void onShowPress(MotionEvent ev) {
			Log.d("GestureDbg", "onShowPress ev " + ev.toString());
		}
		
		@Override
		public void onLongPress(MotionEvent ev) {
			Log.d("GestureDbg", "onLongPress ev " + ev.toString());
		}

		@Override
		public boolean onDown(MotionEvent e) {
			Log.d("GestureDbg", "onDown e " + e.toString());
			return true;
		}

		@Override
		public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX,
				float velocityY) {
			Log.d("GestureDbg", "onScroll e1 " + e1.toString());
			Log.d("GestureDbg", "onScroll e2 " + e2.toString());
			return true;
		}

		@Override
		public boolean onScroll(MotionEvent e1, MotionEvent e2,
				float distanceX, float distanceY) {
			Log.d("GestureDbg", "onScroll e1 " + e1.toString());
			Log.d("GestureDbg", "onScroll e2 " + e2.toString());
			
			_box.rotation().y += distanceX;
			_box.position().x += distanceX / 1000;
			_box.rotation().x += distanceY;
			_box.position().y += distanceY / 1000;
			_box.position().z += Math.sqrt(distanceX * distanceX + distanceY * distanceY) / 1000 * ((distanceX < 0) ? -1 : 1);
			
			return true;
		}
		
		
	}
}
