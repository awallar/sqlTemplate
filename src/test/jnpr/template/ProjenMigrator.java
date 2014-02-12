package test.jnpr.template;

import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;

import java.io.StringWriter;
import java.util.Properties;

/**
 * Created by awallar on 2/6/14.
 */
public class ProjenMigrator {

    private String srcInterface;
    private String dstInterface;
    private String srcRouter;
    private String dstRouter;
    private String migrationTemplateFile;
    private String rollbackTemplateFile;
    private String templatePath;

    public ProjenMigrator(String srcInterface, String srcRouter, String dstInterface, String dstRouter) {
        this.srcInterface = srcInterface;
        this.srcRouter = srcRouter;
        this.dstInterface = dstInterface;
        this.dstRouter = dstRouter;
    }

    public String getMigrationSql() {
      Properties velocityProperties = new Properties();
      velocityProperties.setProperty("resource.loader", "file");
      velocityProperties.setProperty("file.resource.loader.path", ".");

      VelocityEngine ve = new VelocityEngine();
      ve.init(velocityProperties);

      VelocityContext context = new VelocityContext();
      context.put("srcInterface", this.srcInterface);
      context.put("dstInterface", this.dstInterface);
      context.put("srcRouter", this.srcRouter);
      context.put("dstRouter", this.dstRouter);

      StringWriter writer = new StringWriter();
      ve.mergeTemplate("migrationSqlTemplate.vm", "UTF-8", context, writer);
      return writer.toString();
    }

    public String getRollbackSql() {
      Properties velocityProperties = new Properties();
      velocityProperties.setProperty("resource.loader", "file");
      velocityProperties.setProperty("file.resource.loader.path", ".");

      VelocityEngine ve = new VelocityEngine();
      ve.init(velocityProperties);

      VelocityContext context = new VelocityContext();
      context.put("srcInterface", this.srcInterface);
      context.put("dstInterface", this.dstInterface);
      context.put("srcRouter", this.srcRouter);
      context.put("dstRouter", this.dstRouter);

      StringWriter writer = new StringWriter();
      ve.mergeTemplate("rollbackSqlTemplate.vm", "UTF-8", context, writer);
      return writer.toString();
    }

}
