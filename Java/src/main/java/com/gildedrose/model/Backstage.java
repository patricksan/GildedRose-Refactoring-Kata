package com.gildedrose.model;

import com.gildedrose.Item;

public class Backstage extends GeneralGoods {

	public Item dailyUpdate(Item item) {
		if (item.quality < MAX_QUALITY_NORMAL_GOODS) {
			item.quality++;
		}

		if (item.sellIn < 11 && item.quality < MAX_QUALITY_NORMAL_GOODS) {
			item.quality++;
		}

		if (item.sellIn < 6 && item.quality < MAX_QUALITY_NORMAL_GOODS) {
			item.quality++;
		}

		if (item.sellIn == 0) {
			item.quality = 0;
		}

		item.sellIn--;
		return item;
	}
}
