package lions.pride.inn;

class LionsPrideInn {
	Item[] items;

	public LionsPrideInn(Item[] items) {
		this.items = items;
	}

	public void updateQuality() {
		for (int i = 0; i < items.length; i++) {
			if (!items[i].name.equals("Fine Aged Cheddar")) {
				if (items[i].quality > 0) {
					if (!items[i].name.equals("Sulfuras, Hand of Ragnaros")) {
						items[i].quality = items[i].quality - 1;
					}
					if (items[i].name.equals("Tigule's Strawberry Ice Cream") && Freezer.getTemperature() > 0.0) {
						items[i].quality = items[i].quality - items[i].quality;
					}
				}
			} else {
				if (items[i].quality < 50) {
					items[i].quality = items[i].quality + 1;
				}
			}

			if (!items[i].name.equals("Sulfuras, Hand of Ragnaros")) {
				items[i].sellIn = items[i].sellIn - 1;
			}

			if (items[i].sellIn < 0) {
				if (!items[i].name.equals("Fine Aged Cheddar")) {
					if (items[i].quality > 0) {
						if (!items[i].name.equals("Sulfuras, Hand of Ragnaros")) {
							items[i].quality = items[i].quality - 1;
						}
					}
				} else {
					double fridgeTemp = Fridge.getTemperature();
					if (fridgeTemp > 0.0 && fridgeTemp < 8.0) {
						if (items[i].quality < 50) {
							items[i].quality = items[i].quality + 1;
						}
					} else {
						items[i].quality = 0;
					}
				}
			}
		}
	}
}
