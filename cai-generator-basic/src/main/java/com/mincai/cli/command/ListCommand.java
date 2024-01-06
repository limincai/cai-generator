package com.mincai.cli.command;

import cn.hutool.core.io.FileUtil;
import picocli.CommandLine.Option;
import picocli.CommandLine.Command;

import java.io.File;
import java.util.List;

/**
 * 查看生成文件信息的命令类
 * @author limincai
 */
@Command(name = "list",description = "查看生成文件信息",mixinStandardHelpOptions = true)
public class ListCommand implements Runnable{

    @Override
    public void run() {
        String projectPath = System.getProperty("user.dir") + File.separator + "cai-generator-basic";
        // 整个项目的根命令
        File parentPath = new File(projectPath).getParentFile();
        // 输入路径
        String inputPath = new File(parentPath, "cai-generator-demo-project" + File.separator + "acm-template").getAbsolutePath();
        List<File> files = FileUtil.loopFiles(inputPath);
        // 输出所有的文件信息
        for (File file : files) {
            System.out.println(file);
        }
    }
}
