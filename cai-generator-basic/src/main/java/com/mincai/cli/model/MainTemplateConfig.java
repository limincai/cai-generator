package com.mincai.cli.model;

import lombok.Data;

/**
 * 静态模板配置
 *
 * @author limincai
 */
@Data
public class MainTemplateConfig {

    /**
     * 作者名
     */
    private String author = "limincai";

    /**
     * 输出信息
     */
    private String outputText = "输出结果";

    /**
     * 是否循环
     */
    private boolean loop = false;
}
