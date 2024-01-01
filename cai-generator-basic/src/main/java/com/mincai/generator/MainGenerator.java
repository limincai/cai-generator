package com.mincai.generator;

import com.mincai.model.MainTemplateConfig;
import freemarker.template.TemplateException;

import java.io.File;
import java.io.IOException;

/**
 * @author limincai
 */
public class MainGenerator {
    public static void main(String[] args) throws TemplateException, IOException {
        // 生成静态文件
        String projectPath = System.getProperty("user.dir");
        // 输入路径
        String inputPath = projectPath + File.separator + "cai-generator-demo-project" + File.separator + "acm-template";
        //输出路径
        String outputPath = projectPath;
        // 执行复制
        StaticGenerator.copyFileByRecursive(inputPath, outputPath);

        // 生成动态文件
        String dynamicInputPath = projectPath + File.separator + "cai-generator-basic" + File.separator + "src/main/resources/templates/MainTemplate.java.ftl";
        String dynamicOutputPath = projectPath + File.separator + "acm-template/src/com/mincai/acm/MainTemplate.java";
        MainTemplateConfig mainTemplateConfig = new MainTemplateConfig();
        mainTemplateConfig.setAuthor("limincai123");
        mainTemplateConfig.setOutputText("输出");
        mainTemplateConfig.setLoop(true);
        DynamicGenerator.doGenerator(dynamicInputPath, dynamicOutputPath, mainTemplateConfig);
    }
}
