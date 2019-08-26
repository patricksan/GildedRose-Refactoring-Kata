package com.gildedrose;

import com.gildedrose.model.*;

import java.util.stream.IntStream;

class GildedRose {
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
