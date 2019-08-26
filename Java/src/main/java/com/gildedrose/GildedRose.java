package com.gildedrose;

import com.gildedrose.model.*;

import java.util.stream.IntStream;

/**
 * TODO: There is no check. We could add a check that a item can never be more than 50 and also for Sulfuras it has value 80
 */
class GildedRose {
	private static final int MINIMAL_QUALITY = 0;
	private static final int MAX_QUALITY = 50;
	Item[] items;

	GildedRose(Item[] items) {
		this.items = items;
	}

	void updateQuality() {
		IntStream.range(0, items.length).forEach(i -> {
			final GeneralGoods goods;

			switch (items[i].name) {
				case "Conjured Mana Cake":
					goods = new Conjured();
					break;
				case "Aged Brie":
					goods = new AgedBrie();
					break;
				case "Backstage passes to a TAFKAL80ETC concert":
					goods = new Backstage();
					break;
				case "+5 Dexterity Vest":
					goods = new Dexterity();
					break;
				case "Elixir of the Mongoose":
					goods = new Elixir();
					break;
				case "Sulfuras, Hand of Ragnaros":
					goods = new Sulfuras();
					break;
				default:
					goods = new GeneralGoods();
			}

			items[i] = goods.dailyUpdate(items[i]);
		});
	}
}
