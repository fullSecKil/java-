package filesearch.main;

import filesearch.serial.SerialFileSearch;
import filesearch.utils.Result;

import java.io.File;
import java.util.Date;

public class Main {
    public static void main(String[] args) {

        File file = new File("c:/windows/");
        String regex = "host";
        Date start, end;

        Result result = new Result();
        start = new Date();
        SerialFileSearch.searchFiles(file, regex, result);
        end = new Date();
        System.out.println(String.format("Serial Search: Execution Time: %d%n", end.getTime()-start.getTime()));
    }
}
