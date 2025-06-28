package org.example.Patterns.Behavioral.Command;

public class LeftButtonCommand extends ButtonsCommand{
    @Override
    public void execute() {
        button.clickLeftButton();
    }
}
