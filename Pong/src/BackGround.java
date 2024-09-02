import java.awt.*;

public class BackGround {
    public Color backGroundColor = new Color(129,142,211);
    //colors
    //light = 59,102,79 | 211,129,129 | 129,142,211 | 210,179,117
    //darker = 33,47,39 | 32,47,46 | 47,42,32
    //darkest = 30,28,19 | 24,19,30
    public void PatternLine(Graphics2D g2d){

        int gap = 0;
        for(int i = 0 ; i < 1000 ; i++){
            g2d.setColor(backGroundColor.darker());
            g2d.drawLine(0,gap,10000,gap);
            gap = gap + 30;
        }

    }

    public void PatternLine2(Graphics2D g2d){

        int gap = 0;
        for(int i = 0 ; i < 1000 ; i++){
            g2d.setColor(backGroundColor.darker());
            g2d.drawLine(0,gap,10000,gap);
            g2d.drawLine(gap,0,gap,10000);
            gap = gap + 35;
        }

    }

    public void PatternCircle(Graphics2D g2d){
        int vGap = 10;
        int hGap = 0;
        for(int i = 0 ; i < 100 ; i++){
            for (int j = 0 ; j < 100 ; j++){
                g2d.setColor(backGroundColor.darker());
                g2d.fillOval( hGap,vGap , 3, 3);
                hGap += 45;
            }
            vGap += 45;
            hGap = 0;
        }

    }

    public void PatternPlus(Graphics2D g2d){
        int x = 0;
        int y = 0;
        for(int i = 0 ; i < 100 ; i++){
            for (int j = 0 ; j < 100 ; j++){
                g2d.setColor(backGroundColor.darker());
                g2d.drawLine( x - 4 ,y , x + 4, y);
                g2d.drawLine( x ,y - 4 , x , y + 4);
                x += 45;
            }
            y += 45;
            x = 0;
        }

    }


}
