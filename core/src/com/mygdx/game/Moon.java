package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;

public class Moon extends Body {

    public Moon(Texture BodyTexture, int WIDTH, int HEIGHT){
        PlanetBody = BodyTexture;
        PlanetWidth = WIDTH;
        PlanetHeight = HEIGHT;
    }
}
