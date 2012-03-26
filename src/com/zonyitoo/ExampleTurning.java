package com.zonyitoo;

import android.graphics.Bitmap;
import min3d.Shared;
import min3d.Utils;
import min3d.core.Object3dContainer;
import min3d.core.RendererActivity;
import min3d.objectPrimitives.HollowCylinder;
import min3d.objectPrimitives.Sphere;
import min3d.vos.Light;

import com.zonyitoo.R;

public class ExampleTurning extends RendererActivity {
	
	Object3dContainer _cylinder;
	Object3dContainer _sphere;
	
	@Override
	public void initScene() {
		
		Light light = new Light();
		
		light.ambient.setAll((short)64, (short)64, (short)64, (short)255);
		light.position.setAll(3, 3, 3);
		scene.lights().add(light);
		
		Light l2 = new Light();
		l2.ambient.setAll((short) 64, (short) 64, (short) 64, (short) 255);
		l2.position.setAll(-3, -3, -3);
		scene.lights().add(l2);
		
		_cylinder = new HollowCylinder(1f, 0.7f, 0.66f, 25);
		
		_cylinder.scale().setAll(1.2f,1.2f,1.2f);
		//_cylinder.normalsEnabled(false);
		_cylinder.vertexColorsEnabled(true);
		_cylinder.doubleSidedEnabled(true);
		
		_sphere = new Sphere(0.7f, 12, 9, true,true,false);
		
		scene.addChild(_cylinder);
		scene.addChild(_sphere);
		
		Bitmap b = Utils.makeBitmapFromResourceId(this, R.drawable.msk);
		Shared.textureManager().addTextureId(b, "masaike", false);
		b.recycle();
		
		_sphere.textures().addById("masaike");
		
		Bitmap c = Utils.makeBitmapFromResourceId(this, R.drawable.flw);
		Shared.textureManager().addTextureId(c, "flower", false);
		c.recycle();
		
		_cylinder.textures().addById("flower");
	}

	@Override
	public void updateScene() {
		_cylinder.rotation().y += 5;
		_cylinder.rotation().z ++;
		_cylinder.rotation().x ++;
		
		_sphere.rotation().y ++;
	}
	
	
}
