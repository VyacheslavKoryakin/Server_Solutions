package org.example.Patterns.Behavioral.Command;


import java.util.Stack;

public class Invoker {

    Stack<ButtonsCommand> buttonsCommands = new Stack<>();
    public void registerCommand (ButtonsCommand command) {
        buttonsCommands.push(command);

    }
    public void startCommand () {
            for (ButtonsCommand command : buttonsCommands) {
                command.execute();
            }
        }

    public void undo() {

        System.out.println("Canceled last command :"+ buttonsCommands.pop().toString());
    }
    public void print() {
        for (ButtonsCommand buttonsCommand : buttonsCommands) {
            System.out.println(buttonsCommand.toString());
        }


    }

}
