import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.plugins.annotations.Parameter;

import java.io.File;
import java.io.FileWriter;
import java.time.LocalDate;

@Mojo(name = "check-readme")
public class AutoReadmeMojo extends AbstractMojo {

    @Parameter(defaultValue = "${project.basedir}", readonly = true)
    File baseDir;

    @Parameter(defaultValue = "${project.name}", readonly = true)
    String projectName;

    public void execute() throws MojoExecutionException {
        File readme = new File(baseDir, "README.md");

        if (readme.exists()) {
            getLog().info("README.md вже існує — нічого не робимо.");
            return;
        }

        getLog().warn("README.md не знайдено — генеруємо автоматично...");

        try {
            FileWriter writer = new FileWriter(readme);
            writer.write("# " + projectName + "\n\n");
            writer.write("Дата генерації: " + LocalDate.now() + "\n\n");
            writer.write("## Опис\n\n");
            writer.write("Цей файл згенеровано автоматично плагіном auto-readme-plugin.\n\n");
            writer.write("## Запуск\n\n");
            writer.write("```\n");
            writer.write("mvn clean package\n");
            writer.write("java -jar target/car-rental-1.0-jar-with-dependencies.jar\n");
            writer.write("```\n");
            writer.close();

            getLog().info("README.md успішно створено у " + baseDir.getPath());
        } catch (Exception e) {
            throw new MojoExecutionException("Помилка при створенні README.md", e);
        }
    }
}
