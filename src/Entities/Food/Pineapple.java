package Entities.Food;

import Storage.ImageLoader;

public class Pineapple extends Food {

	public Pineapple() {
		sprites = ImageLoader.getInstance().getPineapple();
		if (sprites == null) {
			System.out.println("Error while loading pineapple sprite");
		}
		points = 100;
	}




}
