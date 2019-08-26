package com.gildedrose;

import com.gildedrose.model.*;
import com.gildedrose.validator.GoodsValidator;

import java.util.stream.IntStream;

class GildedRose {
	private Item[] items;

	GildedRose(Item[] items) {
		this.items = items;
	}

	void updateQuality() {
		IntStream.range(0, items.length).forEach(i -> {
			final GeneralGoods goods = factoryGeneralGoods(items[i]);
			items[i] = goods.dailyUpdate(items[i]);
			GoodsValidator.validate(items[i]);
		});
	}

	private GeneralGoods factoryGeneralGoods(Item item) {
		if (item.name.equals(Goods.CONJURED.getName())) {
			return new Conjured();
		} else if (item.name.equals(Goods.AGED_BRIE.getName())) {
			return new AgedBrie();
		} else if (item.name.equals(Goods.BACKSTAGE.getName())) {
			return new Backstage();
		} else if (item.name.equals(Goods.DEXTERITY.getName())) {
			return new Dexterity();
		} else if (item.name.equals(Goods.ELIXIR.getName())) {
			return new Elixir();
		} else if (item.name.equals(Goods.SULFURAS.getName())) {
			return new Sulfuras();
		} else {
			return new GeneralGoods();
		}
	}

	Item[] getItems() {
		return items;
	}
}
