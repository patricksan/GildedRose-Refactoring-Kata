package com.gildedrose.model;

import com.gildedrose.Item;

public class Sulfuras extends GeneralGoods {
	public Item dailyUpdate(Item item) {
		// - "Sulfuras", being a legendary item, never has to be sold or decreases in Quality
		return item;
	}
}
