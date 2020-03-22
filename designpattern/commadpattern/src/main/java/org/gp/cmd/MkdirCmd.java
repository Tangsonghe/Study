package org.gp.cmd;

/**
 * @description:
 * @author: Spark_tang
 * @time: 2020/3/17 22:41
 */
public class MkdirCmd implements ICommand {

    private String folder;
    private FtpServer ftpServer;

    public MkdirCmd(FtpServer ftpServer, String folder) {
        this.folder = folder;
        this.ftpServer = ftpServer;
    }

    @Override
    public void execute() {
        this.ftpServer.mkdir(folder);
    }
}
