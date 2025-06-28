package org.example.Patterns.Behavioral.Command;

public class RightButtonCommand extends ButtonsCommand {
    @Override
    public void execute() {
        button.clickRightButton();
    }
}
