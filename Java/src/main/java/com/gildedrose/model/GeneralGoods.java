package com.gildedrose.model;

import com.gildedrose.Item;

public class GeneralGoods {

	private static final int MINIMAL_QUALITY = 0;
	private static final int SELL_IN_DATE_EXPIRED = 0;
	static final int MAX_QUALITY_NORMAL_GOODS = 50;

	public Item dailyUpdate(Item item) {
		item.sellIn--;
		decreaseQualityIfNotNegative(item);
		qualityDegradesTwiceAsFastWhenDateHasPassed(item);
		return item;
	}

	void qualityDegradesTwiceAsFastWhenDateHasPassed(Item item) {
		// Once the sell by date has passed, Quality degrades twice as fast
		if (item.sellIn < SELL_IN_DATE_EXPIRED) {
			decreaseQualityIfNotNegative(item);
		}
	}

	void decreaseQualityIfNotNegative(Item item) {
		// The Quality of an item is never negative
		if (item.quality > MINIMAL_QUALITY) {
			item.quality--;
		}
	}
}
