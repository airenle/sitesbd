package HttpSpider;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

public class FileIo {
    static String file;

    public FileIo(String file){
        this.file = file;
    }
    public static void Write_To_Csv(String element)throws Exception{
        File csv = new File(file);
        BufferedWriter bfw = new BufferedWriter(new FileWriter(csv,true));
        bfw.write(element);
        bfw.close();

    }

}
