package com.afengzi.automation.generator;

import org.apache.log4j.Logger;
import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.Velocity;
import org.apache.velocity.app.VelocityEngine;

import java.io.File;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by lixiuhai on 2015/2/27.
 */
public class CreateConfigPageServiceUtil {
    private final static Logger log = Logger.getLogger(CreateConfigPageServiceUtil.class);
    private String loadPath;

    public static void main(String[] args) {
        CreateConfigPageServiceUtil serviceUtil = new CreateConfigPageServiceUtil();
        serviceUtil.createConfigPage("spring-config-threadpool", "./jd-chongzhi-web/src/test/java/com/jd/sharding/");
    }

    public void createConfigPage(String templateName, String outPath) {
        PrintWriter writer = null;
        loadPath = "D:\\E_workspace\\template";
        try {
            VelocityEngine ve = new VelocityEngine();
            //����ģ�����·�����������õ���class��
            ve.setProperty(Velocity.FILE_RESOURCE_LOADER_PATH, loadPath);
            //���г�ʼ������
            ve.init();
            //����ģ�壬�趨ģ�����
            Template t = ve.getTemplate(templateName + ".vm", "gbk");
            //���ó�ʼ������
            VelocityContext context = new VelocityContext();
            context.put("threadPoolList", getThreadPoolList());
            //���������ʱhtm�ļ�-----�����ļ���ʼ
            String tempFileName = outPath + templateName + ".xml";
            createDir(tempFileName);
            writer = new PrintWriter(tempFileName);
            //����������ת�����
            t.merge(context, writer);
            writer.close();
        } catch (Exception e) {
            log.error("*******************�����쳣.", e);
        } finally {
            if (writer != null) {
                writer.close();
            }
        }
    }

    private void createDir(String fileName) {
        File file = new File(fileName);
        if (file.exists()) {
            return;
        }
        File parentFile = file.getParentFile();
        if (!parentFile.exists()) {
            if (parentFile.mkdirs()) {
                log.info("������̬�ļ�Ŀ¼�ɹ�,parentFile:" + parentFile);
            }
        }
    }

    private List<Object> getThreadPoolList() {
        List<Object> threadPoolParameters = new LinkedList<Object>();

//        ConfigBeanParameter rechargeTaskProcessorThreadPool_11 = new ConfigBeanParameter("\"rechargeTaskProcessorThreadPool_11\"");
//        ConfigBeanParameter orderDataToCenterProcessorThreadPool_11 = new ConfigBeanParameter("\"orderDataToCenterProcessorThreadPool_11\"");
//        threadPoolParameters.add(rechargeTaskProcessorThreadPool_11);
//        threadPoolParameters.add(orderDataToCenterProcessorThreadPool_11);
////        threadPoolParameters_11.add("###############################") ;
//
//        ConfigBeanParameter rechargeTaskProcessorThreadPool_12 = new ConfigBeanParameter("\"rechargeTaskProcessorThreadPool_12\"");
//        ConfigBeanParameter orderDataToCenterProcessorThreadPool_12 = new ConfigBeanParameter("\"orderDataToCenterProcessorThreadPool_12\"");
//        threadPoolParameters.add(rechargeTaskProcessorThreadPool_12);
//        threadPoolParameters.add(orderDataToCenterProcessorThreadPool_12);
//
//
//        ConfigBeanParameter rechargeTaskProcessorThreadPool_13 = new ConfigBeanParameter("\"rechargeTaskProcessorThreadPool_13\"");
//        ConfigBeanParameter rechargeTaskProcessorThreadPool_14 = new ConfigBeanParameter("\"rechargeTaskProcessorThreadPool_14\"");
//        ConfigBeanParameter rechargeTaskProcessorThreadPool_21 = new ConfigBeanParameter("\"rechargeTaskProcessorThreadPool_21\"");
//        ConfigBeanParameter rechargeTaskProcessorThreadPool_22 = new ConfigBeanParameter("\"rechargeTaskProcessorThreadPool_22\"");
//        ConfigBeanParameter rechargeTaskProcessorThreadPool_23 = new ConfigBeanParameter("\"rechargeTaskProcessorThreadPool_23\"");
//        ConfigBeanParameter rechargeTaskProcessorThreadPool_24 = new ConfigBeanParameter("\"rechargeTaskProcessorThreadPool_24\"");


        return threadPoolParameters;
    }


}
