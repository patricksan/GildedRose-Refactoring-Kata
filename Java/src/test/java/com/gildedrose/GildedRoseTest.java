package com.gildedrose;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class GildedRoseTest {

    @Test
    public void testBasicLowerBothValues() {
        Item[] items = new Item[]{new Item("foo", 1, 1)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();

        /* - At the end of each day our system lowers both values for every item */
        assertEquals(0, app.items[0].sellIn);
        assertEquals(0, app.items[0].quality);
    }

    @Test
    public void testOnceTheSellByDateHasPassedQualityDegradesTwiceAsFast() {
        Item[] items = new Item[]{new Item("foo", 2, 23)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(1, app.items[0].sellIn);
        assertEquals(22, app.items[0].quality);

        app.updateQuality();
        assertEquals(0, app.items[0].sellIn);
        assertEquals(21, app.items[0].quality);

        app.updateQuality();
        assertEquals(-1, app.items[0].sellIn);
        assertEquals(19, app.items[0].quality);
    }

    @Test
    public void testQualityIsNeverNegative() {
        Item[] items = new Item[]{new Item("foo", 10, 1)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(9, app.items[0].sellIn);
        assertEquals(0, app.items[0].quality);

        app.updateQuality();
        assertEquals(8, app.items[0].sellIn);
        assertEquals(0, app.items[0].quality);

        app.updateQuality();
        assertEquals(7, app.items[0].sellIn);
        assertEquals(0, app.items[0].quality);
    }

    @Test
    public void testAgedBrie() {
        Item[] items = new Item[]{new Item("Aged Brie", 10, 30)};
        GildedRose app = new GildedRose(items);
        // "Aged Brie" actually increases in Quality the older it gets
        app.updateQuality();
        assertEquals(9, app.items[0].sellIn);
        assertEquals(31, app.items[0].quality);

        app.updateQuality();
        assertEquals(8, app.items[0].sellIn);
        assertEquals(32, app.items[0].quality);

        app.updateQuality();
        assertEquals(7, app.items[0].sellIn);
        assertEquals(33, app.items[0].quality);
    }

    @Test
    public void testQualityNeverMoreThan50() {
        Item[] items = new Item[]{new Item("Aged Brie", 10, 49)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(9, app.items[0].sellIn);
        assertEquals(50, app.items[0].quality);

        app.updateQuality();
        assertEquals(8, app.items[0].sellIn);
        assertEquals(50, app.items[0].quality);

        app.updateQuality();
        assertEquals(7, app.items[0].sellIn);
        assertEquals(50, app.items[0].quality);
    }

    @Test
    public void testSulfuras() {
        Item[] items = new Item[]{new Item("Sulfuras, Hand of Ragnaros", 10, 80)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(10, app.items[0].sellIn);
        assertEquals(80, app.items[0].quality);

        app.updateQuality();
        assertEquals(10, app.items[0].sellIn);
        assertEquals(80, app.items[0].quality);
    }

    @Test
    public void testBackstagePasses() {
        Item[] items = new Item[]{new Item("Backstage passes to a TAFKAL80ETC concert", 12, 30)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(11, app.items[0].sellIn);
        assertEquals(31, app.items[0].quality);

        app.updateQuality();
        assertEquals(10, app.items[0].sellIn);
        assertEquals(32, app.items[0].quality);

        app.updateQuality();
        assertEquals(9, app.items[0].sellIn);
        assertEquals(34, app.items[0].quality);

        app.updateQuality();
        assertEquals(8, app.items[0].sellIn);
        assertEquals(36, app.items[0].quality);

        app.updateQuality(); //7
        app.updateQuality(); //6
        app.updateQuality(); //5
        app.updateQuality(); //4


        app.updateQuality();
        assertEquals(3, app.items[0].sellIn);
        assertEquals(48, app.items[0].quality);

        app.updateQuality();
        assertEquals(2, app.items[0].sellIn);
        assertEquals(50, app.items[0].quality);

        app.updateQuality();
        assertEquals(1, app.items[0].sellIn);
        assertEquals(50, app.items[0].quality);
    }

    @Test
    public void testConjured() {
        Item[] items = new Item[]{new Item("Conjured", 5, 30)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(4, app.items[0].sellIn);
        assertEquals(28, app.items[0].quality);

        app.updateQuality();
        assertEquals(3, app.items[0].sellIn);
        assertEquals(26, app.items[0].quality);

        app.updateQuality();
        assertEquals(2, app.items[0].sellIn);
        assertEquals(24, app.items[0].quality);
    }
}
