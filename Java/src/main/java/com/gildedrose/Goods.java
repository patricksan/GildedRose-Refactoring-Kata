package com.gildedrose;

/**
 * Enumeration with all non-generic items
 */
public enum Goods {
	DEXTERITY("+5 Dexterity Vest"),
	AGED_BRIE("Aged Brie"),
	ELIXIR("Elixir of the Mongoose"),
	SULFURAS("Sulfuras, Hand of Ragnaros"),
	BACKSTAGE("Backstage passes to a TAFKAL80ETC concert"),
	CONJURED("Conjured Mana Cake");

	private final String name;

	Goods(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}
}
