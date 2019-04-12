package test;

import controller.input_handling.HandleInput;

public class HandleInputTest {
    public static void main(String[] args) {
        HandleInputTest test = new HandleInputTest();
        test.testCheckInputAndLog();
    }
    
    private void testCheckInputAndLog(){
        //Test to see if the checkInput method treats the input correct.
        //Expect to print 1
        System.out.println(HandleInput.checkInput("1", true));
        //Expect to catch exception, display it and print to file
        System.out.println(HandleInput.checkInput("a", true));
        //Expect to read the log from the file to the array and then print it to the screen
        HandleInput.getExceptionLog().printErrors();
        //Expect to clear the errorlog.txt file
        HandleInput.getExceptionLog().clearLog();
    }
}
