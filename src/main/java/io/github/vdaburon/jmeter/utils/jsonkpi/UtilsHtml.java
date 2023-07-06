package io.github.vdaburon.jmeter.utils.jsonkpi;

import freemarker.core.HTMLOutputFormat;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import freemarker.template.TemplateExceptionHandler;
import freemarker.template.Version;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class UtilsHtml {

    private static Configuration cfg = null;

    /**
     * Initialise the Freemarker Template Engine for Html result
     * @throws IOException
     */
    public static void init() throws IOException {
        cfg = new Configuration();
        cfg.setClassForTemplateLoading(UtilsHtml.class, JUnitReportFromJMDashboardStats.K_FREEMARKER_HTML_TEMPLATE_DIRECTORY);

        cfg.setIncompatibleImprovements(new Version(2, 3, 22));
        cfg.setDefaultEncoding("UTF-8");
        cfg.setLocale(Locale.US);
        cfg.setOutputFormat(HTMLOutputFormat.INSTANCE);
        cfg.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);

    }

    /**
     * Write the Global KPIs Result in a Html format
     * @param globalResult contains the KPIs results
     * @param htmlFileOut Html out file result
     * @throws IOException can write the file
     * @throws TemplateException can read the template freemaker file
     */
    public static void saveHtmlFile(GlobalResult globalResult, String htmlFileOut, int typeTemplate) throws IOException, TemplateException {
        if (cfg == null) {
            init();
        }
        Template template = null;
        if (typeTemplate == JUnitReportFromJMDashboardStats.K_TYPE_HTML_TEMPLATE) {
            template = cfg.getTemplate(JUnitReportFromJMDashboardStats.K_FREEMARKER_HTML_TEMPLATE);
        }

        if (typeTemplate == JUnitReportFromJMDashboardStats.K_TYPE_DIV_HTML_TEMPLATE) {
            template = cfg.getTemplate(JUnitReportFromJMDashboardStats.K_FREEMARKER_DIV_HTML_TEMPLATE);
        }

        Map<String, Object> root = new HashMap<>();
        root.put("globalResult", globalResult);
        Writer fileWriter = new FileWriter(new File(htmlFileOut));
        try {
            template.process(root, fileWriter);
        } finally {
            fileWriter.close();
        }

    }

}

