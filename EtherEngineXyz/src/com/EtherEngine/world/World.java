package com.EtherEngine.world;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class World {
	
	private Tile[] tiles;
	public static int WIDTH,HEIGHT;
	
	public World(String path) {
		try {
			BufferedImage map = ImageIO.read(getClass().getResource(path));
			int[] pixels = new int[map.getWidth()*map.getHeight()];
			WIDTH = map.getWidth(); 							HEIGHT = map.getHeight();
			tiles = new Tile[map.getWidth() * map.getHeight()];
			map.getRGB(0, 0,map.getWidth(),map.getHeight(),pixels,0,map.getWidth());
			for(int xx = 0;  xx<map.getWidth(); xx++) {
				for(int yy = 0; yy<map.getHeight(); yy++) {
					int pixelAtual  = pixels[xx + (yy*map.getWidth())];
					//		=LISTA DE TILES=
					//============================================================\\
					// 		=BASE - PRINCIPAL=
					if(pixelAtual == 0xFF000000) {
						//Floor = CHÂO
						tiles[xx+(yy*WIDTH)] = new FloorTile(xx*16,yy*16,Tile.GrassTile_Floor); 
					
					}else if(pixelAtual == 0xFFffffff) {
						//Wall = PAREDE
						tiles[xx+(yy*WIDTH)] = new WallTile(xx*16,yy*16,Tile.BrickTile_Wall); 
					
					//		=MATO - BUSH=
					}else if(pixelAtual == 0xFF94c795) {
						//Grass01
						tiles[xx+(yy*WIDTH)] = new FloorTile(xx*16,yy*16,Tile.Grass01_Floor); 
						
					}else if(pixelAtual == 0xFF73a774) {
						//Grass02
						tiles[xx+(yy*WIDTH)] = new FloorTile(xx*16,yy*16,Tile.Grass02_Floor); 
					}else if(pixelAtual == 0xFF5d805e) {
						//Grass03
						tiles[xx+(yy*WIDTH)] = new WallTile(xx*16,yy*16,Tile.Grass03_Wall); 
						
					}else if(pixelAtual == 0xFF5a875b) {
						//Flowers
						tiles[xx+(yy*WIDTH)] = new FloorTile(xx*16,yy*16,Tile.Flowers_Floor); 
					}else if(pixelAtual == 0xFF416842) {
						//HoleGrass
						tiles[xx+(yy*WIDTH)] = new FloorTile(xx*16,yy*16,Tile.HoleGrass_Floor); 
						
					}else if(pixelAtual == 0xFF395039) {
						//StickGrass
						tiles[xx+(yy*WIDTH)] = new FloorTile(xx*16,yy*16,Tile.StickGrass_Floor); 
					
					}else if(pixelAtual == 0xFF638764) {
						//Mushroom01
						tiles[xx+(yy*WIDTH)] = new FloorTile(xx*16,yy*16,Tile.Mushroom01_Floor); 
						
					}else if(pixelAtual == 0xFF4f7850) {
						//Mushroom02
						tiles[xx+(yy*WIDTH)] = new FloorTile(xx*16,yy*16,Tile.Mushroom02_Floor); 
						
					}else if(pixelAtual == 0xFF668f67){
						//Thicket
						tiles[xx+(yy*WIDTH)] = new WallTile(xx*16,yy*16,Tile.Thicket_Wall); 
					//============================================================\\
					// ESTRADAS = RoadModels A,B,C....
						//		=MODEL0 A=
						}else if(pixelAtual == 0xFF8d8f66) {
						//01
						tiles[xx+(yy*WIDTH)] = new FloorTile(xx*16,yy*16,Tile.RoadModel01A_Floor); 
						
						}else if(pixelAtual == 0xFF767852) {
						//02
						tiles[xx+(yy*WIDTH)] = new FloorTile(xx*16,yy*16,Tile.RoadModel02A_Floor); 
						
						}else if(pixelAtual == 0xFF56583d) {
						//03
						tiles[xx+(yy*WIDTH)] = new FloorTile(xx*16,yy*16,Tile.RoadModel03A_Floor); 
						
						}else if(pixelAtual == 0xFF373824) {
						//04
						tiles[xx+(yy*WIDTH)] = new FloorTile(xx*16,yy*16,Tile.RoadModel04A_Floor); 
						
						}else if(pixelAtual == 0xFF3f4027) {
						//05
						tiles[xx+(yy*WIDTH)] = new FloorTile(xx*16,yy*16,Tile.RoadModel05A_Floor); 
						
						}else if(pixelAtual == 0xFF2f301c) {
						//06
						tiles[xx+(yy*WIDTH)] = new FloorTile(xx*16,yy*16,Tile.RoadModel06A_Floor); 
						
						}else if(pixelAtual == 0xFF1f2011) {
						//07
						tiles[xx+(yy*WIDTH)] = new FloorTile(xx*16,yy*16,Tile.RoadModel07A_Floor); 
						
						}else if(pixelAtual == 0xFF17180c) {
						//08
						tiles[xx+(yy*WIDTH)] = new FloorTile(xx*16,yy*16,Tile.RoadModel08A_Floor);
						
						}else if(pixelAtual == 0xFF121209) {
						//09
						tiles[xx+(yy*WIDTH)] = new FloorTile(xx*16,yy*16,Tile.RoadModel09A_Floor);
						
						}else if(pixelAtual == 0xFF46481b) {
						//10
						tiles[xx+(yy*WIDTH)] = new FloorTile(xx*16,yy*16,Tile.RoadModel10A_Floor); 
						
						}else if(pixelAtual == 0xFF3e4018) {
						//11
						tiles[xx+(yy*WIDTH)] = new FloorTile(xx*16,yy*16,Tile.RoadModel11A_Floor); 
						
						}else if(pixelAtual == 0xFF343614) {
						//12
						tiles[xx+(yy*WIDTH)] = new FloorTile(xx*16,yy*16,Tile.RoadModel12A_Floor); 
						
						}else if(pixelAtual == 0xFF2d2e11) {
						//13
						tiles[xx+(yy*WIDTH)] = new FloorTile(xx*16,yy*16,Tile.RoadModel13A_Floor); 
						//
						
					//============================================================\\
					//	OAKs
					}else if(pixelAtual == 0xFF91db69) {
						//OakTree01
						tiles[xx+(yy*WIDTH)] = new WallTile(xx*16,yy*16,Tile.OakTree01_Wall); 
					}else if(pixelAtual == 0xFFcddf6c) {
						//OakTree02
						tiles[xx+(yy*WIDTH)] = new WallTile(xx*16,yy*16,Tile.OakTree02_Wall); 
					}else if(pixelAtual == 0xFF239063) {
						//OakTree03
						tiles[xx+(yy*WIDTH)] = new WallTile(xx*16,yy*16,Tile.OakTree03_Wall); 
					}else if(pixelAtual == 0xFF1ebc73) {
						//OakTree04
						tiles[xx+(yy*WIDTH)] = new WallTile(xx*16,yy*16,Tile.OakTree04_Wall); 
					}else if(pixelAtual == 0xFF4c3e24) {
						//OakTree05
						tiles[xx+(yy*WIDTH)] = new FloorTile(xx*16,yy*16,Tile.OakTree05_Floor); 
					}else if(pixelAtual == 0xFF676633) {
						//OakTree06
						tiles[xx+(yy*WIDTH)] = new FloorTile(xx*16,yy*16,Tile.OakTree06_Floor); 
					//============================================================\\
					
					}else if(pixelAtual == 0xFF8fd3ff) {
						//Player
						tiles[xx+(yy*WIDTH)] = new FloorTile(xx*16,yy*16,Tile.GrassTile_Floor);  

					}else {
						//Flor/CHÂO
						tiles[xx+(yy*WIDTH)] = new FloorTile(xx*16,yy*16,Tile.GrassTile_Floor); 

					}
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public void render(Graphics g) {
		for(int xx = 0;  xx < WIDTH; xx++){
			for(int yy = 0; yy < HEIGHT; yy++) {
				Tile tile = tiles[xx + (yy*WIDTH)];
				tile.render(g);
			}
		}
	}
}

