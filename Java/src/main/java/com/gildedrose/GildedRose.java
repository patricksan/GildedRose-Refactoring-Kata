package com.gildedrose;

import java.util.stream.IntStream;

/**
 * TODO: There is no check. We could add a check that a item can never be more than 50 and also for Sulfuras it has value 80
 */
class GildedRose {
	private static final int MINIMAL_QUALITY = 0;
	private static final int MAX_QUALITY = 50;
	private Item[] items;

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
						item.quality--;
					}
				}

				if (item.name.equals(Goods.CONJURED.getName()) && item.quality < MAX_QUALITY) {
					item.quality--;
				}
			} else {
				if (item.quality < MAX_QUALITY) {
					item.quality++;

					if (item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
						if (item.sellIn < 11 && item.quality < MAX_QUALITY) {
							item.quality++;

						}

						if (item.sellIn < 6 && item.quality < MAX_QUALITY) {
							item.quality++;
						}
					}
				}
			}
			if (!item.name.equals("Sulfuras, Hand of Ragnaros")) {
				item.sellIn--;
			}
			if (item.sellIn < 0) {
				if (!item.name.equals("Aged Brie")) {
					if (!item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
						if (item.quality > 0) {
							if (!item.name.equals("Sulfuras, Hand of Ragnaros")) {
								item.quality--;
							}
						}
					} else {
						item.quality = MINIMAL_QUALITY;
					}
				} else {
					if (item.quality < MAX_QUALITY) {
						item.quality++;
					}
				}
			}
		});
	}
}
