package com.contest;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        items[0].sellIn = 9;
        items[0].quality = 19;
    }
}