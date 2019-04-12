package test;
import controller.Dice;
import controller.Menu;


/*
This a test class for general testing. The class shall remain package protected.
 */
class MainTest {
    //Test variables
    private Dice dice;
    public static void main(String[] args) {
        MainTest test = new MainTest();

        /*----------Menu method test calls----------*/
        //test.testStartMenu();
        //test.testNavigationMenu();
        //test.testFightingMenu();
        /*----------Menu method test calls end----------*/
    }

    /*----------Test of various menus----------*/
    private void testStartMenu(){
        //Test the display of the start menu
        Menu.mainMenu();
    }

    private void testNavigationMenu(){
        //Test the display of the navigation menu
      //  Menu.navigateMenu();
    }
    private void testFightingMenu(){
        //Menu.fightingMenu();
    }
}
