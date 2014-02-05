package test.jnpr.template;

/**
 * Created by awallar on 2/5/14.
 */
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;
import java.util.Properties;

import java.io.StringWriter;

public class testTemplate {

    public static void main(String args[])
    throws Exception{

        Properties velocityProperties = new Properties();
        velocityProperties.setProperty("file.resource.loader.path", "C:\\Users\\awallar\\PSGithub");

        VelocityEngine ve=new VelocityEngine();
        ve.init(velocityProperties);

        VelocityContext context = new VelocityContext();
        context.put("pe_interface_dummy", "dummy_interface_pe");
        context.put("dummy_router_name", "name_dummy_router");

        StringWriter writer = new StringWriter();

        ve.mergeTemplate("sqltemplate.vm", "UTF-8" ,context, writer);
        System.out.println(writer.toString());

    }
}
