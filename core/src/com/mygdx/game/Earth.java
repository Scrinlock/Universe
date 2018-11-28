package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;

public class Earth extends Body {

    public Earth(Texture BodyTexture, int WIDTH, int HEIGHT){
        PlanetBody = BodyTexture;
        PlanetWidth = WIDTH;
        PlanetHeight = HEIGHT;
    }
}
