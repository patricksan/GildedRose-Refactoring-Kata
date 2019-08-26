package com.gildedrose.validator;

import com.gildedrose.Goods;
import com.gildedrose.Item;

public final class GoodsValidator {

	public static void validate(Item item) {
		validateQualityMax(item);
		validateSulfurasQuality(item);
		validateQualityNeverNegative(item);
	}

	private static void validateQualityNeverNegative(Item item) {
		if (item.quality < 0) {
			System.out.printf("Validation error: Quantity should not be negative [%s]", item);
		}
	}

	private static void validateSulfurasQuality(Item item) {
		if (item.name.equals(Goods.SULFURAS.getName()) && item.quality != 80) {
			System.out.printf("Validation error: %s should always have quality 80. [%s]", Goods.SULFURAS.getName(), item);
		}
	}

	private static void validateQualityMax(Item item) {
		if (!item.name.equals(Goods.SULFURAS.getName()) && item.quality > 50) {
			System.out.printf("Validation error: %s should always have quality below or equal 50. [%s]", item.name, item);
		}
	}
}
