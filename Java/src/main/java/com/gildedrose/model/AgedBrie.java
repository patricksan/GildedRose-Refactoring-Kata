package com.gildedrose.model;

import com.gildedrose.Item;

public class AgedBrie extends GeneralGoods {

	public Item dailyUpdate(Item item) {
		if (item.quality < MAX_QUALITY_NORMAL_GOODS) {
			item.quality++;
		}

		item.sellIn--;
		return item;
	}
}
