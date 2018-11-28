package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;

public class Sun extends Body {

    public Sun(Texture BodyTexture, int WIDTH, int HEIGHT){
        PlanetBody = BodyTexture;
        PlanetWidth = WIDTH;
        PlanetHeight = HEIGHT;
    }
}
