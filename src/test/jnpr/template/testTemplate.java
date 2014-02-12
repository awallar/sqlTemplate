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

    ProjenMigrator pm = new ProjenMigrator(srcInterface, srcRouter, dstInterface, dstRouter);

    String migrationSql = pm.getMigrationSql();

    String rollbackSql = pm.getRollbackSql();

    System.out.println(migrationSql);
    System.out.println(rollbackSql);

    }
}
