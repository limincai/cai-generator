package com.mincai.cli.example;

import picocli.CommandLine;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;

import java.util.concurrent.Callable;

/**
 * @author limincai
 */
@Command(name = "login", version = "Login 1.0", mixinStandardHelpOptions = true)
public class Login implements Callable<Integer> {

    @Option(names = {"-u", "--user"}, description = "User name", interactive = true, prompt = "请输入账号：", arity = "0..1")
    String user;

    @Option(names = {"-p", "--password"}, description = "Passphrase", interactive = true, prompt = "请输入密码：", arity = "0..1")
    char[] password;

    @Option(names = {"-cp", "--checkedPassword"}, description = "Passphrase", interactive = true, prompt = "请输入密码：", arity = "0..1")
    char[] checkedPassword;

    @Override
    public Integer call() {
        System.out.println("user = " + user);
        System.out.println("password = " + String.valueOf(password));
        return 0;
    }

    public static void main(String[] args) {
        new CommandLine(new Login()).execute(args);
    }
}