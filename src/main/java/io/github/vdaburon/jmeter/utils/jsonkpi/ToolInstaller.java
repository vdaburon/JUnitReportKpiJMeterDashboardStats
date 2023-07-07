package io.github.vdaburon.jmeter.utils.jsonkpi;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

public class ToolInstaller {
    public static void main(String[] argv) throws IOException {
        writeOut("junit-reporter-kpi-from-jmeter-dashboard-stats.cmd", false);
        writeOut("junit-reporter-kpi-from-jmeter-dashboard-stats.sh", true);
    }

    private static void writeOut(String resName, boolean executable) throws IOException {
        resName = "/io/github/vdaburon/jmeter/utils/jsonkpi/" + resName;
        File self = new File(ToolInstaller.class.getProtectionDomain().getCodeSource().getLocation().getFile());
        File src = new File(resName);
        String home = self.getParentFile().getParentFile().getParent();
        File dest = new File(home + File.separator + "bin" + File.separator + src.getName());

        InputStream is = ToolInstaller.class.getResourceAsStream(resName);
        Files.copy(is, dest.toPath(), StandardCopyOption.REPLACE_EXISTING);
        dest.setExecutable(executable);
    }
}
