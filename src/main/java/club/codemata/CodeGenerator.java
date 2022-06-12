package club.codemata;


import club.codemata.exception.YamlException;
import club.codemata.utils.YamlUtil;
import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;
import org.apache.maven.plugins.annotations.Mojo;

import java.io.IOException;

@Mojo(name = "generateCode")
public class CodeGenerator extends AbstractMojo {
    public void execute() throws MojoExecutionException, MojoFailureException {
        try {
            String string = YamlUtil.getString("spring.datasource");
            System.out.println(string);
        } catch (YamlException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
