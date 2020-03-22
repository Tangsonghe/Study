package org.gp.cmd;

/**
 * @description:
 * @author: Spark_tang
 * @time: 2020/3/17 22:34
 */
public class OpenCmd implements ICommand {

    private FtpServer ftpServer;

    public OpenCmd(FtpServer ftpServer) {
        this.ftpServer = ftpServer;
    }

    @Override
    public void execute() {
        ftpServer.open();;
    }
}
