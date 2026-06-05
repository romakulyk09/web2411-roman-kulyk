import org.gradle.api.DefaultTask;
import org.gradle.api.tasks.TaskAction;

import java.io.*;
import java.nio.file.*;
import java.util.zip.*;

public class GitArchiverTask extends DefaultTask {

    @TaskAction
    public void archive() throws Exception {
        GitArchiverExtension ext = getProject().getExtensions().getByType(GitArchiverExtension.class);

        String branch = runCommand("git rev-parse --abbrev-ref HEAD");
        String hash = runCommand("git rev-parse --short HEAD");

        String archiveName = "backup-" + branch + "-" + hash + ".zip";
        File outputDir = new File(getProject().getProjectDir(), ext.outputDir);
        outputDir.mkdirs();

        File zipFile = new File(outputDir, archiveName);
        File srcDir = new File(getProject().getProjectDir(), "src");

        zipFolder(srcDir, zipFile);

        System.out.println("Архів створено: " + zipFile.getPath());
    }

    private String runCommand(String command) throws Exception {
        ProcessBuilder pb = new ProcessBuilder(command.split(" "));
        pb.directory(getProject().getProjectDir());
        Process process = pb.start();
        BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
        return reader.readLine().trim();
    }

    private void zipFolder(File folder, File zipFile) throws Exception {
        ZipOutputStream zip = new ZipOutputStream(new FileOutputStream(zipFile));
        addToZip(folder, folder.getName(), zip);
        zip.close();
    }

    private void addToZip(File file, String entryName, ZipOutputStream zip) throws Exception {
        if (file.isDirectory()) {
            for (File child : file.listFiles()) {
                addToZip(child, entryName + "/" + child.getName(), zip);
            }
        } else {
            zip.putNextEntry(new ZipEntry(entryName));
            Files.copy(file.toPath(), zip);
            zip.closeEntry();
        }
    }
}
