package com.mincai.cli.generator;

import com.mincai.cli.model.MainTemplateConfig;
import freemarker.template.TemplateException;
import freemarker.template.utility.StringUtil;

import java.io.File;
import java.io.IOException;

/**
 * @author limincai
 */
public class MainGenerator {

    public static void doGenerator(MainTemplateConfig mainTemplateConfig) throws TemplateException, IOException {
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
        DynamicGenerator.doGenerator(dynamicInputPath, dynamicOutputPath, mainTemplateConfig);
    }
}
