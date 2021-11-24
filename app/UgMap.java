package app;

import java.awt.*;  

public class UgMap extends Canvas{

    @Override
    public void paint(Graphics g) { 
        g.setColor(Color.CYAN); 
        Toolkit t=Toolkit.getDefaultToolkit();  
        Image i = t.getImage("/Users/hrd/Documents/UG/2020 2021/Sem 2/DCIT 204/code/ug-map/app/map_info.png");  
        g.drawImage(i,10, 10, this);  
    } 

}
