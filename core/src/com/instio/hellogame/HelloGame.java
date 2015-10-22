package com.instio.hellogame;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class HelloGame extends ApplicationAdapter {
	SpriteBatch batch;
	Texture img;

	float x = 0;
	float y = 0;
	float xv= 0;
	float yv =0;

	final float Max_VELOCITY = 100; //this is a constant


	
	@Override
	public void create () {  //runs only once loading jpeg
		batch = new SpriteBatch();
		img = new Texture("badlogic.jpg");
	}

	@Override
	public void render () {//this is spriteBatch draws on screen. rendering things. constantly runs FPS
		if (Gdx.input.isKeyPressed(Input.Keys.UP)) {
			yv = Max_VELOCITY;
		}
		if (Gdx.input.isKeyPressed(Input.Keys.DOWN)) {
			yv = Max_VELOCITY * -1;
		}
		if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)) {
			xv = Max_VELOCITY;
		}
		if (Gdx.input.isKeyPressed(Input.Keys.LEFT)) {
			xv = Max_VELOCITY * -1;
		}

		x += xv * Gdx.graphics.getDeltaTime();
		y += yv * Gdx.graphics.getDeltaTime();

		xv *= .9; //this is acting as a damper slows the image down. reducing the fraction allows different slow down.
		yv *= .9;


		Gdx.gl.glClearColor(1, 0, 0, 1); // drawing background color, red,green,blue,
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT); //clearing what ever was on the screen before it.
		batch.begin();
		batch.draw(img, x, y);
		batch.end();
	}
}
