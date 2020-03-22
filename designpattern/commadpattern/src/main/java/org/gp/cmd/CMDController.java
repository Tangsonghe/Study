package org.gp.cmd;

import java.util.ArrayList;
import java.util.List;

/**
 * @description:
 * @author: Spark_tang
 * @time: 2020/3/17 22:42
 */
public class CMDController {

    List<ICommand> cmds = new ArrayList<>();

    public void execute(ICommand command) {
        command.execute();
    }

    public void addCommand(ICommand command) {
        cmds.add(command);
    }

    public void batchExecute() {
        cmds.forEach(c -> c.execute());
    }

}
