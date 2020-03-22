package org.gp.cmd;

/**
 * @description:
 * @author: Spark_tang
 * @time: 2020/3/17 22:40
 */
public class LSCmd implements ICommand {

    private String folder;
    private FtpServer ftpServer;

    public LSCmd(FtpServer ftpServer, String folder) {
        this.folder = folder;
        this.ftpServer = ftpServer;
    }

    @Override
    public void execute() {
        ftpServer.ls(folder);
    }
}
