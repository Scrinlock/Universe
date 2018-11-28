package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;

public class Plantoid extends Body {

    public Plantoid(Texture BodyTexture, int WIDTH, int HEIGHT){
        PlanetBody = BodyTexture;
        PlanetWidth = WIDTH;
        PlanetHeight = HEIGHT;
    }
}
