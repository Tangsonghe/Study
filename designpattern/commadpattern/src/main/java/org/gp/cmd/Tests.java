package org.gp.cmd;

/**
 * @description:
 * @author: Spark_tang
 * @time: 2020/3/17 22:44
 */
public class Tests {
    public static void main(String[] args) {
        CMDController cmdController = new CMDController();
        FtpServer ftpServer = new FtpServer();

        cmdController.execute(new OpenCmd(ftpServer));

        cmdController.addCommand(new CDCmd(ftpServer, "/opt/apps"));
        cmdController.addCommand(new LSCmd(ftpServer, ""));
        cmdController.addCommand(new MkdirCmd(ftpServer, "/opt/apps"));
        cmdController.batchExecute();
    }
}
