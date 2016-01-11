package com.anim;

import com.anim.CustomAnimDrawable.AnimationDrawableListener;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

/**
 * 测试各种动画效果
 */
public class TestEffectActivity extends Activity {
	private final String TAG = "xmp";
	private Context mContext;
	private View effectView ;
	private TextView textWidget;
	public final static String TYPE = "type";
	public final static int EFFECT_ALPHA = 1;
	public final static int EFFECT_TRANS = 2;
	public final static int EFFECT_SCALE = 3;
	public final static int EFFECT_ROTATE = 4;
	public final static int EFFECT_SCALE_ROTATE = 5;
	public final static int EFFECT_FRAME = 6;


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.test_effect);
		mContext = this;
	}
	@Override
	protected void onStart() {
		super.onStart();
		handleEffect();
	}

	private void handleEffect() {
		Intent intent = getIntent();
		int effectType = intent.getIntExtra(TYPE, 0);
		switch (effectType) {
		case EFFECT_ALPHA:
			handleAlphaEffect();
			break;
		case EFFECT_TRANS:
			handleTransEffect();
			break;
		case EFFECT_SCALE:
			handleScaleEffect();
			break;
		case EFFECT_ROTATE:
			handleRotateEffect();
			break;
		case EFFECT_SCALE_ROTATE:
			handleScaleRotateEffect();
			break;
		case EFFECT_FRAME:
			handleFrameEffect();
			break;
		default:
			break;
		}
	}
	private void exit(){
		finish();
	}
	
	/*
	 * 监听是否播放状态
	 */
	class EffectAnimationListener implements AnimationListener{
		@Override
		public void onAnimationEnd(Animation animation) {
			exit();
		}
		@Override
		public void onAnimationRepeat(Animation animation) {}
		@Override
		public void onAnimationStart(Animation animation) {}
	}
	private void handleAlphaEffect() {
		Animation anim = AnimationUtils.loadAnimation(mContext, R.anim.alpha);
		anim.setAnimationListener(new EffectAnimationListener());
		textWidget = (TextView)findViewById(R.id.text_widget);
		textWidget.setText(" 渐变透明度动画效果");
		textWidget.startAnimation(anim);
		Log.v(TAG,"--------------->handleAlphaEffect");
	}

	private void handleTransEffect() {
		Animation anim = AnimationUtils.loadAnimation(mContext, R.anim.trans);
		anim.setAnimationListener(new EffectAnimationListener());
		textWidget = (TextView)findViewById(R.id.text_widget);
		textWidget.setText(" 转换位置移动动画效果");
		textWidget.startAnimation(anim);
		Log.v(TAG,"--------------->handleTransEffect");
	}

	private void handleScaleEffect() {
		Animation anim = AnimationUtils.loadAnimation(mContext, R.anim.scale);
		anim.setAnimationListener(new EffectAnimationListener());
		textWidget = (TextView)findViewById(R.id.text_widget);
		textWidget.setText(" 渐变尺寸伸缩动画效果");
		textWidget.startAnimation(anim);
		Log.v(TAG,"--------------->handleTransEffect");
	}

	private void handleRotateEffect() {
		Animation anim = AnimationUtils.loadAnimation(mContext, R.anim.rotate);
		anim.setAnimationListener(new EffectAnimationListener());
		textWidget = (TextView)findViewById(R.id.text_widget);
		textWidget.setText(" 画面转移旋转动画效果");
		textWidget.startAnimation(anim);
		Log.v(TAG,"--------------->handleRotateEffect");
	}
	private void handleScaleRotateEffect(){
		Animation anim = AnimationUtils.loadAnimation(mContext, R.anim.scale_rotate);
		anim.setAnimationListener(new EffectAnimationListener());
		textWidget = (TextView)findViewById(R.id.text_widget);
		textWidget.setText(" 画面缩放旋转动画效果");
		textWidget.startAnimation(anim);
		Log.v(TAG,"--------------->handleRotateEffect");
	}
	
	/*
	 * 监听是否播放状态
	 */
	class FrameAnimationListener implements AnimationDrawableListener{
		@Override
		public void onAnimationEnd(AnimationDrawable animation) {
			exit();
		}
		@Override
		public void onAnimationStart(AnimationDrawable animation) {
			
		}
	}
	private void handleFrameEffect() {
		AnimationDrawable anim = (AnimationDrawable)getResources().
				getDrawable(R.drawable.frame);
		CustomAnimDrawable cusAnim = new CustomAnimDrawable(anim);
		cusAnim.setAnimationListener(new FrameAnimationListener());
		textWidget = (TextView)findViewById(R.id.text_widget);
		textWidget.setText(" 画面逐帧动画效果");
		textWidget.setBackgroundDrawable(anim);
		cusAnim.start();
		Log.v(TAG,"--------------->handleFrameEffect");
	}
}
