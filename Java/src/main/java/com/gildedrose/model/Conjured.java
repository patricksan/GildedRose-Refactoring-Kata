package com.gildedrose.model;

import com.gildedrose.Item;

public class Conjured extends GeneralGoods {

	public Item dailyUpdate(Item item) {
		item = super.dailyUpdate(item);
		item.quality--;
		return item;
	}
}
