import org.gradle.api.Plugin;
import org.gradle.api.Project;

public class GitArchiverPlugin implements Plugin<Project> {

    public void apply(Project project) {
        project.getExtensions().create("gitArchiver", GitArchiverExtension.class);

        project.getTasks().register("archiveSources", GitArchiverTask.class, task -> {
            task.setGroup("build");
            task.setDescription("Архівує src/ у ZIP з назвою на основі git гілки та коміту");
            task.dependsOn("build");
        });
    }
}
