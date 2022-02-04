package lions.pride.inn;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import lions.pride.inn.Item;
import lions.pride.inn.LionsPrideInn;

class LionsPrideInnTest {

	@Test
	void foo() {
		Item[] items = new Item[] { new Item("foo", 0, 0) };
		LionsPrideInn app = new LionsPrideInn(items);
		app.updateQuality();
		assertEquals("fixme", app.items[0].name);
	}
}