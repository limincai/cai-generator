package com.mincai.cli.example;

import picocli.CommandLine;

import java.util.Arrays;

/**
 * @author limincai
 */
@CommandLine.Command(name = "main", mixinStandardHelpOptions = true)
public class SubCommandExample implements Runnable {


    @Override
    public void run() {
        System.out.println("执行主命令");
    }

    @CommandLine.Command(name = "--a", mixinStandardHelpOptions = true)
    static class AddCommand implements Runnable {
        @Override
        public void run() {
            System.out.println("执行增加命令");
        }
    }

    @CommandLine.Command(name = "--d", mixinStandardHelpOptions = true)
    static class DeleteCommand implements Runnable {
        @Override
        public void run() {
            System.out.println("执行删除命令");
        }
    }

    public static void main(String[] args) {
        new CommandLine(SubCommandExample.class).addSubcommand("--a", new AddCommand()).addSubcommand("--d", new DeleteCommand()).execute(args);
    }
}
