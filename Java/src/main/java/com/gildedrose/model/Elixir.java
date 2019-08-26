package com.gildedrose.model;

import com.gildedrose.Item;

public class Elixir extends GeneralGoods {

	public Item dailyUpdate(Item item) {
		item.sellIn--;

		decreaseQualityIfNotNegative(item);
		qualityDegradesTwiceAsFastWhenDateHasPassed(item);

		return item;
	}

}
