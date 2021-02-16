package com.gildedrose;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Test with all scenarios described in the documentation.
 */
public class GildedRoseTest {

    @Test
    public void testBasicLowerBothValues() {
        Item[] items = new Item[]{new Item(Goods.ELIXIR.getName(), 1, 1)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();

        /* - At the end of each day our system lowers both values for every item */
        assertEquals(0, app.getItems()[0].sellIn);
        assertEquals(0, app.getItems()[0].quality);
    }

    @Test
    public void testOnceTheSellByDateHasPassedQualityDegradesTwiceAsFast() {
        Item[] items = new Item[]{new Item(Goods.ELIXIR.getName(), 2, 23)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(1, app.getItems()[0].sellIn);
        assertEquals(22, app.getItems()[0].quality);

        app.updateQuality();
        assertEquals(0, app.getItems()[0].sellIn);
        assertEquals(21, app.getItems()[0].quality);

        app.updateQuality();
        assertEquals(-1, app.getItems()[0].sellIn);
        assertEquals(19, app.getItems()[0].quality);
    }

    @Test
    public void testQualityIsNeverNegative() {
        Item[] items = new Item[]{new Item(Goods.ELIXIR.getName(), 10, 1)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(9, app.getItems()[0].sellIn);
        assertEquals(0, app.getItems()[0].quality);

        app.updateQuality();
        assertEquals(8, app.getItems()[0].sellIn);
        assertEquals(0, app.getItems()[0].quality);

        app.updateQuality();
        assertEquals(7, app.getItems()[0].sellIn);
        assertEquals(0, app.getItems()[0].quality);
    }

    @Test
    public void testAgedBrie() {
        Item[] items = new Item[]{new Item(Goods.AGED_BRIE.getName(), 10, 30)};
        GildedRose app = new GildedRose(items);
        // "Aged Brie" actually increases in Quality the older it gets
        app.updateQuality();
        assertEquals(9, app.getItems()[0].sellIn);
        assertEquals(31, app.getItems()[0].quality);

        app.updateQuality();
        assertEquals(8, app.getItems()[0].sellIn);
        assertEquals(32, app.getItems()[0].quality);

        app.updateQuality();
        assertEquals(7, app.getItems()[0].sellIn);
        assertEquals(33, app.getItems()[0].quality);
    }

    @Test
    public void testQualityNeverMoreThan50() {
        Item[] items = new Item[]{new Item(Goods.AGED_BRIE.getName(), 10, 49)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(9, app.getItems()[0].sellIn);
        assertEquals(50, app.getItems()[0].quality);

        app.updateQuality();
        assertEquals(8, app.getItems()[0].sellIn);
        assertEquals(50, app.getItems()[0].quality);

        app.updateQuality();
        assertEquals(7, app.getItems()[0].sellIn);
        assertEquals(50, app.getItems()[0].quality);
    }

    @Test
    public void testSulfuras() {
        Item[] items = new Item[]{new Item(Goods.SULFURAS.getName(), 10, 80)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(10, app.getItems()[0].sellIn);
        assertEquals(80, app.getItems()[0].quality);

        app.updateQuality();
        assertEquals(10, app.getItems()[0].sellIn);
        assertEquals(80, app.getItems()[0].quality);
    }

    @Test
    public void testBackstagePasses() {
        Item[] items = new Item[]{new Item(Goods.BACKSTAGE.getName(), 12, 30)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(11, app.getItems()[0].sellIn);
        assertEquals(31, app.getItems()[0].quality);

        app.updateQuality();
        assertEquals(10, app.getItems()[0].sellIn);
        assertEquals(32, app.getItems()[0].quality);

        app.updateQuality();
        assertEquals(9, app.getItems()[0].sellIn);
        assertEquals(34, app.getItems()[0].quality);

        app.updateQuality();
        assertEquals(8, app.getItems()[0].sellIn);
        assertEquals(36, app.getItems()[0].quality);

        app.updateQuality(); //7
        app.updateQuality(); //6
        app.updateQuality(); //5
        app.updateQuality(); //4

        app.updateQuality();
        assertEquals(3, app.getItems()[0].sellIn);
        assertEquals(48, app.getItems()[0].quality);

        app.updateQuality();
        assertEquals(2, app.getItems()[0].sellIn);
        assertEquals(50, app.getItems()[0].quality);

        app.updateQuality();
        assertEquals(1, app.getItems()[0].sellIn);
        assertEquals(50, app.getItems()[0].quality);
    }

    @Test
    public void testConjured() {
        Item[] items = new Item[]{new Item(Goods.CONJURED.getName(), 5, 30)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(4, app.getItems()[0].sellIn);
        assertEquals(28, app.getItems()[0].quality);

        app.updateQuality();
        assertEquals(3, app.getItems()[0].sellIn);
        assertEquals(26, app.getItems()[0].quality);

        app.updateQuality();
        assertEquals(2, app.getItems()[0].sellIn);
        assertEquals(24, app.getItems()[0].quality);
    }
}
