package org.example.Patterns.Behavioral.Command;

public class Main {
    public static void main(String[] args) {
        Invoker invoker = new Invoker();
        invoker.registerCommand(new LeftButtonCommand());
        invoker.registerCommand(new RightButtonCommand());


        invoker.startCommand();
        invoker.undo();


    }
}
