import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;



public class HelloWorld {

    private static final Logger logger=LogManager.getLogger("HelloWorld");

    public static void main(String[] args) {



        // TODO Auto-generated method stub
        System.out.println("привет группа!!");

        for (int m = 1; m <= 100; m++) {
            if (m%2==0)
                System.out.println(m);
            logger.trace("step :: "+ m);
            logger.info("step :: "+ m);
            logger.warn("step :: "+ m);
            logger.error("step :: "+ m);

        }
    }
}


