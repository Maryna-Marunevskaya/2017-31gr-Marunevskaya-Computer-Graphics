package computer_graphics.simplearcmodule.storage;

import computer_graphics.simplearcmodule.entity.figure.Head;
import computer_graphics.simplearcmodule.tools.headreader.HeadReader;

public class HeadStorage {
    private static Head head=null;

    public static void read(String directory, String fileName){
        HeadReader hr=new HeadReader(directory, fileName);
        head=hr.read();
    }

    public static Head getHead(){
        return head;
    }
}
