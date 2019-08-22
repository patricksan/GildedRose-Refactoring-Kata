package com.gildedrose;

import java.util.stream.IntStream;

/**
 * TODO: There is no check. We could add a check that a item can never be more than 50 and also for Sulfuras it has value 80
 */
class GildedRose {
	Item[] items;

	GildedRose(Item[] items) {
		this.items = items;
	}

	void updateQuality() {
		IntStream.range(0, items.length).forEach(i -> {
			Item item = items[i];
			if (!item.name.equals("Aged Brie")
					&& !item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
				if (item.quality > 0) {
					if (!item.name.equals("Sulfuras, Hand of Ragnaros")) {
						item.quality = item.quality - 1;
					}
				}
			} else {
				if (item.quality < 50) {
					item.quality = item.quality + 1;

					if (item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
						if (item.sellIn < 11) {
							if (item.quality < 50) {
								item.quality = item.quality + 1;
							}
						}

						if (item.sellIn < 6) {
							if (item.quality < 50) {
								item.quality = item.quality + 1;
							}
						}
					}
				}
			}
			if (!item.name.equals("Sulfuras, Hand of Ragnaros")) {
				item.sellIn = item.sellIn - 1;
			}
			if (item.sellIn < 0) {
				if (!item.name.equals("Aged Brie")) {
					if (!item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
						if (item.quality > 0) {
							if (!item.name.equals("Sulfuras, Hand of Ragnaros")) {
								item.quality = item.quality - 1;
							}
						}
					} else {
						item.quality = item.quality - item.quality;
					}
				} else {
					if (item.quality < 50) {
						item.quality = item.quality + 1;
					}
				}
			}
		});
	}
}
