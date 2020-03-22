package org.gp.cmd;

/**
 * @description:
 * @author: Spark_tang
 * @time: 2020/3/17 22:35
 */
public class CDCmd implements ICommand {

    private FtpServer ftpServer;

    private String folder;

    public CDCmd(FtpServer ftpServer, String folder) {
        this.ftpServer = ftpServer;
        this.folder = folder;
    }

    @Override
    public void execute() {
        ftpServer.cd(folder);
    }
}
