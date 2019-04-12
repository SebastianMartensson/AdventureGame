package controller.input_handling;

import controller.Program;

/*
The checkInput method checks any given input from the user. 
If checkNumerical is set to true only numerical values will be checked.
Else alphabetical values will be checked.
Each time the input is erroneous it is saved to an error log.
 */
public class HandleInput {
    private static Program program = new Program();
    private static Log exceptionLog = new Log();

    public static String checkInput(String input, boolean checkNumerical) {
        if (input.equals("")) {
            program.gameInput.nextLine();
        }
        boolean check;
        if (checkNumerical) {
            do {
                if (!input.matches("[0-9]")) {
                    check = true;
                    input = program.gameInput.nextLine();
                } else {
                    check = false;
                }
            } while (check);
        } else {
            do {
                if (!input.matches(".*[A-Za-z].*")) {
                    check = true;
                    input = program.gameInput.nextLine();
                } else {
                    check = false;
                }
            } while (check);
        }
        return input;
    }

    public static Log getExceptionLog() {
        return exceptionLog;
    }
}
