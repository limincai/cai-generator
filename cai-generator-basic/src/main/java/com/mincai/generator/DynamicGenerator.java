package com.mincai.generator;


import com.mincai.model.MainTemplateConfig;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * 动态文件生成器
 *
 * @author limincai
 */
public class DynamicGenerator {
    public static void main(String[] args) throws TemplateException, IOException {
        String projectPath = System.getProperty("user.dir") + File.separator + "cai-generator-basic";
        String inputPath = projectPath + File.separator + "src/main/resources/templates/MainTemplate.java.ftl";
        String outputPath = projectPath + File.separator + "MainTemplate.java";
        MainTemplateConfig mainTemplateConfig = new MainTemplateConfig();
        mainTemplateConfig.setAuthor("limincai");
        mainTemplateConfig.setOutputText("输出");
        mainTemplateConfig.setLoop(true);

        doGenerator(inputPath, outputPath, mainTemplateConfig);
    }

    /**
     * 生成文件
     *
     * @param inputPath  输出路径
     * @param outputPath 输出路径
     * @param dataModel  数据模型
     */
    public static void doGenerator(String inputPath, String outputPath, Object dataModel) throws IOException, TemplateException {
        Configuration configuration = new Configuration(Configuration.VERSION_2_3_31);

        // 设置模板路径
        File templateDir = new File(inputPath).getParentFile();
        configuration.setDirectoryForTemplateLoading(templateDir);

        // 设置模板字符集
        configuration.setDefaultEncoding("utf-8");
        configuration.setNumberFormat("0.######");

        // 加载指定模板
        String templateName = new File(inputPath).getName();
        Template template = configuration.getTemplate(templateName);
        FileWriter fileWriter = new FileWriter(outputPath);
        // 数据模型
        template.process(dataModel, fileWriter);
        fileWriter.close();
    }
}
