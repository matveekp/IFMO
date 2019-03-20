package lesson6.classWork.nested;

public interface Logger {


    public void log();
}


class SomeClass {

    public void someVoid() {

        Logger logger = new Logger() {
            @Override
            public void log() {
                System.out.println("log something");
            }
        };

        logger.log();

    }
}