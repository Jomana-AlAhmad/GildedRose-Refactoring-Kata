package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GildedRoseTest {

    @Test
    void normal_item_with_zero_quality_does_not_go_below_zero_quality() {
        Item[] items = new Item[] { new Item("foo", 11, 0) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("foo", app.items[0].name);
        assertEquals(0,app.items[0].quality);
    }


    @Test
    void normal_item_sellIn_decreases_by_one() {
        Item[] items = new Item[] { new Item("foo", 11, 5) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("foo", app.items[0].name);
        assertEquals(10,app.items[0].sellIn);
    }

    @Test
    void normal_item_degrades_one_point_in_quality_each_day(){
        Item[] items = new Item[] { new Item("foo", 5, 5) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("foo", app.items[0].name);
        assertEquals(4,app.items[0].quality);
    }
    @Test
    void normal_item_degrades_two_point_in_quality_when_sellIn_date_passes(){
        Item[] items = new Item[] { new Item("foo", 0, 5) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("foo", app.items[0].name);
        assertEquals(3,app.items[0].quality);
    }

    @Test
    void aged_brie_increases_in_quality_when_it_ages(){
        Item[] items = new Item[] { new Item("Aged Brie", 5, 5) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("Aged Brie", app.items[0].name);
        assertEquals(6,app.items[0].quality);
    }
    @Test
    void aged_brie_sellIn_decreases_by_one(){
        Item[] items = new Item[] { new Item("Aged Brie", 5, 5) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("Aged Brie", app.items[0].name);
        assertEquals(4,app.items[0].sellIn);
    }


    @Test
    void aged_brie_quality_does_not_go_above_50(){
        Item[] items = new Item[] { new Item("Aged Brie", 5, 50) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("Aged Brie", app.items[0].name);
        assertEquals(50,app.items[0].quality);
    }

    @Test
    void sulfuras_quality_does_not_increase_or_decrease(){
        Item[] items = new Item[] { new Item("Sulfuras, Hand of Ragnaros", 5, 80) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("Sulfuras, Hand of Ragnaros", app.items[0].name);
        assertEquals(80,app.items[0].quality);
    }
    @Test
    void sulfuras_sellin_does_not_decrease(){
        Item[] items = new Item[] { new Item("Sulfuras, Hand of Ragnaros", 5, 80) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("Sulfuras, Hand of Ragnaros", app.items[0].name);
        assertEquals(5,app.items[0].sellIn);
    }
    @Test
    void backstage_passes_quality_increases_1_when_more_than_10_days_to_sellIn(){
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 11, 10) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("Backstage passes to a TAFKAL80ETC concert", app.items[0].name);
        assertEquals(11,app.items[0].quality);
    }
    @Test
    void backstage_passes_sellIn_decreases_by_one(){
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 11, 10) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("Backstage passes to a TAFKAL80ETC concert", app.items[0].name);
        assertEquals(10,app.items[0].sellIn);
    }
    @Test
    void backstage_passes_quality_increases_2_when_more_than_10_days_to_sellIn(){
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 9, 10) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("Backstage passes to a TAFKAL80ETC concert", app.items[0].name);
        assertEquals(12,app.items[0].quality);
    }
    @Test
    void backstage_passes_quality_increases_5_when_more_than_10_days_to_sellIn(){
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 5, 10) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("Backstage passes to a TAFKAL80ETC concert", app.items[0].name);
        assertEquals(13,app.items[0].quality);
    }
    @Test
    void backstage_passes_quality_is_0_when_sellIn_is_0(){
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 0, 10) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("Backstage passes to a TAFKAL80ETC concert", app.items[0].name);
        assertEquals(0,app.items[0].quality);
    }

    @Test
    void conjured_item_degrades_two_point_in_quality(){
        Item[] items = new Item[] { new Item("conjured", 10, 5) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("conjured", app.items[0].name);
        assertEquals(3,app.items[0].quality);
    }
    @Test
    void conjured_sellIn_decreases_by_one(){
        Item[] items = new Item[] { new Item("conjured", 10, 5) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("conjured", app.items[0].name);
        assertEquals(9,app.items[0].sellIn);
    }

    @Test
    void conjured_degrades_four_points_in_quality_when_sellIn_date_passes(){
        Item[] items = new Item[] { new Item("conjured", 0, 5) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("conjured", app.items[0].name);
        assertEquals(1,app.items[0].quality);
    }

    @Test
    void conjured_quality_is_never_negative(){
        Item[] items = new Item[] { new Item("conjured", 10, 0) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("conjured", app.items[0].name);
        assertEquals(0,app.items[0].quality);
    }
    @Test
    void conjured_quality_is_never_negative_even_if_quality_is_below_4(){
        Item[] items = new Item[] { new Item("conjured", 0, 3) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("conjured", app.items[0].name);
        assertEquals(0,app.items[0].quality);
    }
}
