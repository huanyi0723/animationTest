package com.anim;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class AnimationTestActivity extends Activity {
	private final String TAG = "xmp";
	private Button alphaBtn;
	private Button transBtn;
	private Button scaleBtn;
	private Button rotateBtn;
	private Button scaleRotateBtn;
	private Button frameBtn;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		initControls();
	}

	private void initControls() {
		alphaBtn = (Button) findViewById(R.id.alpha);
		transBtn = (Button) findViewById(R.id.translate);
		scaleBtn = (Button) findViewById(R.id.scale);
		rotateBtn = (Button) findViewById(R.id.rotate);
		scaleRotateBtn = (Button)findViewById(R.id.scale_rotate);
		frameBtn = (Button) findViewById(R.id.frame);
		
		alphaBtn.setOnClickListener(new BtnOnClickListener());
		transBtn.setOnClickListener(new BtnOnClickListener());
		scaleBtn.setOnClickListener(new BtnOnClickListener());
		rotateBtn.setOnClickListener(new BtnOnClickListener());
		scaleRotateBtn.setOnClickListener(new BtnOnClickListener());
		frameBtn.setOnClickListener(new BtnOnClickListener());
	}

	class BtnOnClickListener implements OnClickListener {
		@Override
		public void onClick(View v) {
			Log.v(TAG,"--------------->onClick");
			switch (v.getId()) {
				case R.id.alpha:
					testAlphaEffect();
					break;
				case R.id.translate:
					testTransEffect();
					break;
				case R.id.scale:
					testScaleEffect();
					break;
				case R.id.rotate:
					testRotateEffect();
					break;
				case R.id.scale_rotate:
					testScaleRotateEffect();
					break;
				case R.id.frame:
					testFrameEffect();
					break;
				default:
					break;
			}
		}
	}

	private void testAlphaEffect() {
		Intent intent = new Intent("anim.test");
		intent.addCategory(Intent.CATEGORY_DEFAULT);
		intent.putExtra(TestEffectActivity.TYPE, TestEffectActivity.EFFECT_ALPHA);
		startActivity(intent);
		Log.v(TAG,"--------->testAlphaEffect");
	}
	private void testTransEffect() {
		Intent intent = new Intent("anim.test");
		intent.addCategory(Intent.CATEGORY_DEFAULT);
		intent.putExtra(TestEffectActivity.TYPE, TestEffectActivity.EFFECT_TRANS);
		startActivity(intent);
		Log.v(TAG,"--------->testTransEffect");
	}
	private void testScaleEffect() {
		Intent intent = new Intent("anim.test");
		intent.addCategory(Intent.CATEGORY_DEFAULT);
		intent.putExtra(TestEffectActivity.TYPE, TestEffectActivity.EFFECT_SCALE);
		startActivity(intent);
		Log.v(TAG,"--------->testTransEffect");
	}
	private void testRotateEffect() {
		Intent intent = new Intent("anim.test");
		intent.addCategory(Intent.CATEGORY_DEFAULT);
		intent.putExtra(TestEffectActivity.TYPE, TestEffectActivity.EFFECT_ROTATE);
		startActivity(intent);
		Log.v(TAG,"--------->testTransEffect");
	}
	private void testScaleRotateEffect(){
		Intent intent = new Intent("anim.test");
		intent.addCategory(Intent.CATEGORY_DEFAULT);
		intent.putExtra(TestEffectActivity.TYPE, TestEffectActivity.EFFECT_SCALE_ROTATE);
		startActivity(intent);
		Log.v(TAG,"--------->testTransEffect");
	}
	private void testFrameEffect(){
		Intent intent = new Intent("anim.test");
		intent.addCategory(Intent.CATEGORY_DEFAULT);
		intent.putExtra(TestEffectActivity.TYPE, TestEffectActivity.EFFECT_FRAME);
		startActivity(intent);
		Log.v(TAG,"--------->testFrameEffect");
	}
}