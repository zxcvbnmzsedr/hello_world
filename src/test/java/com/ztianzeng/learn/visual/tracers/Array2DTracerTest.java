package com.ztianzeng.learn.visual.tracers;

/**
 * @author zhaotianzeng
 * @date 2019/9/24 10:39 上午
 * @version V1.0
 */
public class Array2DTracerTest {

    public static void main(String[] args) throws InterruptedException {
        new Main();
    }

    static class Main {
        // define tracer variables {
        Array2DTracer array2dTracer = new Array2DTracer("Grid");
        LogTracer logTracer = new LogTracer("Console");
        // }

        // define input variables
        String[] messages = {
                "Visualize",
                "your",
                "own",
                "code",
                "here!",
        };

        Main() {
            // visualize {
            Layout.setRoot(new VerticalLayout(logTracer, array2dTracer));
            array2dTracer.set(messages);
            VerticalLayout.delay();
            // }
            highlight(0);
        }

        // highlight each line of messages recursively
        void highlight(int line) {
            if (line >= messages.length) return;
            String message = messages[line];
            // visualize {
            logTracer.println(message);
            array2dTracer.selectRow(line, 0, message.length() - 1);
            VerticalLayout.delay();
            array2dTracer.deselectRow(line, 0, message.length() - 1);
            // }
            highlight(line + 1);
        }
    }
}