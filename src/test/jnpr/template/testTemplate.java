package test.jnpr.template;

/**
 * Created by awallar on 2/5/14.
 */
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;
import java.util.Properties;

import java.io.StringWriter;

public class testTemplate {

    public static void main(String args[]) throws Exception{

        String srcInterface = "srcInterfaceReal";
        String srcRouter = "srcRouterReal";
        String dstInterface = "dstInterfaceReal";
        String dstRouter = "dstRouterReal";
        String templateFile= "sqltemplate.vm";
        String templatePath= "/Users/jnickerson/Documents/develop/juniper/Optus/sqlTemplate";

        sqlTemplate ST= new sqlTemplate(srcInterface,srcRouter,dstInterface,dstRouter, templateFile,templatePath);
        ST.evaluate();
    }
}
