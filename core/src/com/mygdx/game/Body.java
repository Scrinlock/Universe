package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.graphics.Texture;

public class Body extends ApplicationAdapter{

    public Texture PlanetBody;
    public int PlanetPosX;
    public int PlanetPosY;
    public int PlanetWidth;
    public int PlanetHeight;

    private int PosX(int ParentX, float R, double Time){
        int x1;
        x1 =(int) (ParentX + R * Math.cos(Time));
        return x1;
    }

    private int PosY(int ParentY, float R, double Time){
        int y1;
        y1 = (int) (ParentY + R * Math.sin(Time));
        return y1;
    }

    public void getPos(int ParentX, int ParentY, int R, double Time){
        PlanetPosX = PosX(ParentX,R, Time) + PlanetWidth/2;
        PlanetPosY = PosY(ParentY,R, Time) + PlanetHeight/2;
    }
}