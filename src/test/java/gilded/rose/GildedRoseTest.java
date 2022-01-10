package gilded.rose;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

class GildedRoseTest {

	@Test
	void foo() {
		Item[] items = new Item[] { new Item("foo", 0, 0) };
		GildedRose app = new GildedRose(items);
		app.updateQuality();
		assertEquals("fixme", app.items[0].name);
	}
}