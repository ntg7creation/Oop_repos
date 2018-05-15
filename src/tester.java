import LogicL.logic_Board;
import PresentationL.gui_Game_Window;
import StorageL.Boards;
import StorageL.image_Loader;

public class tester {

	public static void main(String[] args) {
		System.out.println("starging test");
		Boards my_Boards = new Boards();
		image_Loader my_images = new image_Loader("cat");
		logic_Board logic = new logic_Board(3, my_Boards.get_Random_Board_of_Size(3));
		new gui_Game_Window(3, logic, my_images);

	}
}
