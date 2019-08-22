package com.gildedrose;

public class TextTestFixture {
    public static void main(String[] args) {
        System.out.println("OMGHAI!");

        Item[] items = new Item[]{
                new Item(Goods.DEXTERITY.getName(), 10, 20), //
                new Item(Goods.AGED_BRIE.getName(), 2, 0), //
                new Item(Goods.ELIXIR.getName(), 5, 7), //
                new Item(Goods.SULFURAS.getName(), 0, 80), //
                new Item(Goods.SULFURAS.getName(), -1, 80),
                new Item(Goods.BACKSTAGE.getName(), 15, 20),
                new Item(Goods.BACKSTAGE.getName(), 10, 49),
                new Item(Goods.BACKSTAGE.getName(), 5, 49),
                // this conjured item does not work properly yet
                new Item(Goods.CONJURED.getName(), 3, 6)};

        GildedRose app = new GildedRose(items);

        int days = 2;
        if (args.length > 0) {
            days = Integer.parseInt(args[0]) + 1;
        }

        for (int i = 0; i < days; i++) {
            System.out.println("-------- day " + i + " --------");
            System.out.println("name, sellIn, quality");
            for (Item item : items) {
                System.out.println(item);
            }
            System.out.println();
            app.updateQuality();
        }
    }

}
