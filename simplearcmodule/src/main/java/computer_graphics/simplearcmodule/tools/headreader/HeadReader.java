package computer_graphics.simplearcmodule.tools.headreader;

import android.graphics.PointF;
import android.os.Environment;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import computer_graphics.simplearcmodule.entity.figure.Head;

public class HeadReader {
    private String directory;
    private String fileName;
    public HeadReader(String directory, String fileName){
        this.directory= directory;
        this.fileName=fileName;
    }

    public Head read(){
        if(!Environment.getExternalStorageState().equals(
                Environment.MEDIA_MOUNTED)){
            return null;
        }
        else{
            File sdPath = Environment.getExternalStorageDirectory();

            if(directory==null||directory.isEmpty()){
                sdPath = new File(/*sdPath.getAbsolutePath()*/"/storage/8349-16E4");
            }
            else{
                sdPath = new File(/*sdPath.getAbsolutePath()*/ "/storage/8349-16E4"+ "/" + directory);
            }

            File sdFile = new File(sdPath, fileName);
            try{
                BufferedReader br=new BufferedReader(new FileReader(sdFile));
                String str="";
                List<PointF> v=new ArrayList<PointF>();
                List<ArrayList<Integer>> f=new ArrayList<ArrayList<Integer>>();
                while ((str = br.readLine()) != null) {
                    String values[]=str.split(" ");

                    if(values[0].equalsIgnoreCase("v")){
                        v.add(new PointF(Float.parseFloat(values[1]), Float.parseFloat(values[2])));
                    }
                    else if(values[0].equalsIgnoreCase("f")){
                        ArrayList<Integer> l=new ArrayList<Integer>();
                        l.add(Integer.parseInt( values[1].split("/")[0])-1);
                        l.add(Integer.parseInt( values[2].split("/")[0])-1);
                        l.add(Integer.parseInt( values[3].split("/")[0])-1);
                        f.add(l);
                    }
                }

                try{
                    br.close();
                }catch(Exception e){
                }
                return new Head(v, f);
            }
            catch(Exception e){
                return null;
            }
        }
    }
}
