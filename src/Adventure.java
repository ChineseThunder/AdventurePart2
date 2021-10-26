import java.util.Scanner;

public class Adventure {
	private static Object Item;

	public static void main(String[] args) {
		Map map = new Map();
		map.createMap();

		Player player = new Player();
		player.setCurrentRoom(map.getStarterRoom());

		Scanner sc = new Scanner(System.in);
		System.out.println("WELCOME TO THE ADVENTURE GAME!\n");
		System.out.println("THIS IS YOUR COMMANDS:");
		System.out.println("--------------------------------");
		System.out.println("Exit - Exit game\nHelp - Commands list\nLook - Repeats room description \nNorth / Go North / N - Player moves North\nSouth / Go South / S - Player moves South\nEast  / Go East  / E - Player moves East\nWest  / Go West  / W - Player moves West");
		System.out.println("--------------------------------");
		System.out.println("\nYou are at a plane. You are about to jump out of the plane.\n");


		boolean playerMoved = false;
		while (true) {
			String input = sc.nextLine();

			if (input.equalsIgnoreCase("south") || (input.equalsIgnoreCase("s"))) {
			playerMoved = player.move("south");

			} else if (input.equalsIgnoreCase("north") || (input.equalsIgnoreCase("n"))) {
			playerMoved = player.move("north");

			} else if (input.equalsIgnoreCase("west") || (input.equalsIgnoreCase("w"))) {
			playerMoved = player.move("west");

			} else if (input.equalsIgnoreCase("east") || (input.equalsIgnoreCase("e"))) {
			playerMoved = player.move("east");
			}

			if (playerMoved) {
				System.out.println("You are now " + player.getCurrentRoom());
				
				if (player.getCurrentRoom() == map.getWinnerRoom()) {
					System.out.println("You Won!\nTry another path");
					System.exit(1);
				}
				else if (input.equalsIgnoreCase("exit")) {
					System.out.println("Winners never quit, and quitters never win");
					System.exit(1);
				}
				else if (input.equalsIgnoreCase("look")) {
					System.out.println(player.getCurrentRoom());
					player.getCurrentRoom().printList();
				}
				else if (input.equalsIgnoreCase("help")) {
					System.out.println("THIS IS YOUR COMMANDS:\nExit - Lets your exit the game\nLook - Repeats room description \nNorth - Moves north\nSouth - Moves south\nEast - Moves east\nWest - Moves west");
				}
				else if (input.equalsIgnoreCase("inventory")) {
					System.out.println("Inventory: ");
					for (int i = 0; i < player.getInventory().size(); i++) {
						System.out.println(player.getInventory().get(i).getItemName());
					}
				}
				else if (input.equalsIgnoreCase("take")) {
					player.getCurrentRoom().printList();
					System.out.println("What item do you want to pick up?");
					Scanner scan = new Scanner(System.in);
					String itemName = scan.nextLine();
					if (player.takeItem(itemName)) {
						System.out.println("item taken");
						for (int i = 0; i < player.getInventory().size(); i++) {
							System.out.println(player.getInventory().get(i).getItemName());
						}
					}
				}
				///bagvend herfra
				/*else if (input.equalsIgnoreCase("drop")) {
					player.getInventory().printList();
					System.out.println("What item do you want to drop?");
					Scanner inputDrop = new Scanner(System.in);
					String itemName = inDrop.nextLine();
					if (player.takeItem(itemName)) {
						System.out.println("item taken");
						for (int i = 0; i < player.getInventory().size(); i++) {
							System.out.println(player.getInventory().get(i).getItemName());
						}
					}
				}*/
			}
		}
	}
}


