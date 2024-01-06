package com.mincai.cli.command;

import cn.hutool.core.util.ReflectUtil;
import com.mincai.cli.model.MainTemplateConfig;
import picocli.CommandLine.Command;

import java.lang.reflect.Field;

/**
 * 输出用户输入参数信息的命令类
 * @author limincai
 */
@Command(name = "config",description = "输出输入参数信息",mixinStandardHelpOptions = true)
public class ConfigCommand implements Runnable{
    @Override
    public void run() {
        Field[] fields = ReflectUtil.getFields(MainTemplateConfig.class);
        for (Field field : fields) {
            System.out.println("字段类型：" + field.getType());
            System.out.println("字段名称：" + field.getName());
        }
    }
}
