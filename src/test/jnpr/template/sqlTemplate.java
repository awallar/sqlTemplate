package test.jnpr.template;

import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;

import java.io.StringWriter;
import java.util.Properties;

/**
 * Created by awallar on 2/6/14.
 */
public class sqlTemplate {

    private String srcInterface;
    private String dstInterface;
    private String srcRouter;
    private String dstRouter;
    private String templateFile;
    private String templatePath;

    public sqlTemplate(String srcInterface, String srcRouter, String dstInterface, String dstRouter, String templateFile, String templatePath ) {
        this.srcInterface = srcInterface;
        this.srcRouter = srcRouter;
        this.dstInterface = dstInterface;
        this.dstRouter = dstRouter;
        this.templateFile= templateFile;
        this.templatePath=templatePath;
    }

    public void evaluate() {

        Properties velocityProperties = new Properties();
        velocityProperties.setProperty("file.resource.loader.path", this.templatePath );

        VelocityEngine ve=new VelocityEngine();
        ve.init(velocityProperties);

        VelocityContext context = new VelocityContext();
        context.put("srcInterface", this.srcInterface);
        context.put("srcRouter", this.srcRouter);
        context.put("dstInterface", this.dstInterface);
        context.put("dstRouter", this.dstRouter);

        StringWriter writer = new StringWriter();

        ve.mergeTemplate(this.templateFile, "UTF-8" ,context, writer);
        System.out.println(writer.toString());

    }

}
