package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.utils.viewport.ScreenViewport;

public class MyGame extends ApplicationAdapter {
	private SpriteBatch batch;
	private Sun sun;
	private Moon moon;
	private Earth earth;
	private Texture bg;
	private Plantoid plantoid;
	private double PlanetT, MoonT;
	private TextButton PauseButton;
	private Stage stage;
	private boolean pause;

	@Override
	public void create () {
		stage = new Stage(new ScreenViewport());
		Gdx.input.setInputProcessor(stage);
		Skin mySkin = new Skin(Gdx.files.internal("skin/glassy-ui.json"));

		batch = new SpriteBatch();
		moon = new Moon(new Texture("android/assets/ven.png"),30,30);
		sun = new Sun(new Texture("android/assets/sun.png"),200,200);
		earth = new Earth(new Texture("android/assets/pl.png"),60,60);
		plantoid = new Plantoid(new Texture("android/assets/pl2.png"),70,70);
		bg = new Texture("android/assets/bg.jpg");

		PauseButton = new TextButton("Pause",mySkin);
		PauseButton.setSize(200,150);
		PauseButton.setPosition(10,10);
		PauseButton.addListener(new InputListener(){
			@Override
			public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
				pause = !pause;
				return true;
			}
		});
		stage.addActor(PauseButton);
	}

	@Override
	public void render () {

		if (!pause){
			MoonT += 0.05;
			PlanetT += 0.01;
		}

		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		earth.getPos(350,350,200,PlanetT);
		moon.getPos(earth.PlanetPosX,earth.PlanetPosY,50,MoonT);
		plantoid.getPos(350,350,350, -PlanetT);

		batch.begin();
		batch.draw(bg,0,0);
		batch.draw(sun.PlanetBody,300 ,300, sun.PlanetWidth, sun.PlanetHeight);
		batch.draw(earth.PlanetBody, earth.PlanetPosX, earth.PlanetPosY, earth.PlanetWidth, earth.PlanetHeight);
		batch.draw(moon.PlanetBody, moon.PlanetPosX, moon.PlanetPosY, moon.PlanetWidth, moon.PlanetHeight);
		batch.draw(plantoid.PlanetBody, plantoid.PlanetPosX, plantoid.PlanetPosY, plantoid.PlanetWidth, plantoid.PlanetHeight);
		batch.end();

		stage.act();
		stage.draw();
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		sun.PlanetBody.dispose();
		earth.PlanetBody.dispose();
		moon.PlanetBody.dispose();
		plantoid.PlanetBody.dispose();
	}
}
