package com.mincai;

import com.mincai.cli.CommandExecutor;

/**
 * @author limincai
 */
public class Main {
    public static void main(String[] args) {
        CommandExecutor commandExecutor = new CommandExecutor();
        commandExecutor.doExecute(args);
    }
}
