package com.gildedrose;

class GildedRose {
    public static final String BACKSTAGE_PASSES = "Backstage passes to a TAFKAL80ETC concert";
    public static final String AGED_BRIE = "Aged Brie";
    public static final String SULFURAS = "Sulfuras, Hand of Ragnaros";
    public static final String CONJURED = "conjured";

    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (int i = 0; i < items.length; i++) {

            switch (items[i].name) {
                case AGED_BRIE:
                    updateQualityAndSellinOfBrie(i);
                    break;
                case BACKSTAGE_PASSES:
                    updateQualityAndSellinOfBackstage(i);
                    break;
                case CONJURED:
                    updateQualityAndSellinofConjured(i);
                    break;
                default:
                    updateQualityAndSellinDefault(i);
            }
        }
    }

    private void updateQualityAndSellinofConjured(int i) {
        if (items[i].quality > 0 ) {
            if (items[i].quality < 4) {
                items[i].quality = 0;
            } else {
                if (items[i].sellIn <= 0) {
                    updateQualityValue(i, -4);
                } else {
                    updateQualityValue(i, -2);
                }
                updateSellInValue(i);
            }
        }
    }

    private void updateQualityAndSellinOfBackstage(int i) {
        if (items[i].sellIn > 0 && items[i].quality < 50) {
                if (items[i].sellIn >= 11) {
                    items[i].quality++;
                } else if (items[i].sellIn < 6) {
                        updateQualityValue(i,3);
                } else if (items[i].sellIn < 11) {
                    updateQualityValue(i,2);;
                }
            } else {
                items[i].quality = 0;
            }
        updateSellInValue(i);
    }

    private void updateQualityAndSellinOfBrie(int i) {
        if (items[i].quality > 0) {
            if (items[i].quality < 50) {
                updateQualityValue(i,1);;
            }
        }
        if (items[i].sellIn < 0) {
            if (items[i].quality < 50) {
                updateQualityValue(i,1);;
            }
        }
        updateSellInValue(i);
    }


    private void updateQualityAndSellinDefault(int i) {
        if (!items[i].name.equals(SULFURAS)) {
            if (items[i].quality > 0) {
                if (items[i].sellIn <= 0) {
                    updateQualityValue(i,-2);;
                } else {
                    updateQualityValue(i,-1);;
                }
            }
            updateSellInValue(i);
        }
    }

    private void updateSellInValue(int i) {
        items[i].sellIn--;
    }

    private void updateQualityValue(int index,int i) {
        items[index].quality = items[index].quality + i;
    }
}