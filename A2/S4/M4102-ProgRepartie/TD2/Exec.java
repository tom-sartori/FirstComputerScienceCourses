package TD2;

import java.util.concurrent.Executor;

public class Exec implements Executor {

    @Override
    public void execute(Runnable command) {
        Thread thread = new Thread();
    }
}
