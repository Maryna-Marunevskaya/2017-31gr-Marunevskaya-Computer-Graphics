package computer_graphics.simplearcmodule.storage;

import computer_graphics.simplearcmodule.tools.view.BasicView;

public class ViewStorage {
    private static BasicView basicView;

    public static void setBasicView(BasicView bv){
        basicView=bv;
    }

   public static BasicView getBasicView(){
        return basicView;
    }
}
