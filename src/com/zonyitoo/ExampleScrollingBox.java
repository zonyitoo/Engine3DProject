package com.zonyitoo;

import min3d.core.Object3dContainer;
import min3d.core.RendererActivity;
import min3d.objectPrimitives.Box;
import min3d.vos.Color4;
import min3d.vos.Light;

public class ExampleScrollingBox extends RendererActivity {
	Object3dContainer _box;
	
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
		
		_box = new Box(.6f, .6f, .6f, colors, false, false, true);
		_box.normalsEnabled(false);
		_box.position().y = 1.2f;
		
		scene.addChild(_box);
	}
	
	@Override
	public void updateScene() {
		_box.rotation().y ++;
		_box.rotation().z ++;
		_box.rotation().x ++;
	}
}
