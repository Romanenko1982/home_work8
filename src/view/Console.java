package view;

import service.ConsoleService;

public class Console {

  public void startConsole() {
    ConsoleService consoleService = new ConsoleService();
    consoleService.console();
  }
}
