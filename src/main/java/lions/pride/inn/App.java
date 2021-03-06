package lions.pride.inn;

// You are not allowed to edit this file.
public class App {
	public static void main(String[] args) {
		System.out.println("OMGHAI!");

		Item[] items = new Item[] {
				new Item("+5 Dexterity Vest", 10, 20), //
				new Item("Fine Aged Cheddar", 2, 0), //
				new Item("Elixir of the Mongoose", 5, 7), //
				new Item("Sulfuras, Hand of Ragnaros", 0, 80), //
				new Item("Sulfuras, Hand of Ragnaros", -1, 80),
				// this conjured item does not work properly yet
				new Item("Conjured Mana Cake", 3, 6) };

		LionsPrideInn app = new LionsPrideInn(items);

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
