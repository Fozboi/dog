import javax.swing.*;
import java.awt.*;
import java.util.*;

public class DrawPolygons extends Component{
    private ArrayList<Polygon> polygonList;

    public DrawPolygons(){
        Point p1 = new Point(100,100);
        Point p2 = new Point(150,250);
        Point p3 = new Point(100,200);

        polygonList = new ArrayList<>(3);

        polygonList.add(new Polygon("square" , p1));
        polygonList.add(new Polygon("triangle" , p2));
        polygonList.add(new Polygon("rectangle" , p3));
    }//constructor

    @Override
    public void paint(Graphics g) {
        for (int i = 0; i < polygonList.size(); i++) {

            String currentPolygon = polygonList.get(i).p_type;
            Point currentCenter = polygonList.get(i).centerpoint;

            if (currentPolygon.equals("square"))
                g.drawRect(currentCenter.x -10, currentCenter.y -10, 20, 20);
            else if (currentPolygon.equals("triangle")) {
                g.drawLine(currentCenter.x, currentCenter.y-10, currentCenter.x-10, currentCenter.y+10);
                g.drawLine(currentCenter.x-10, currentCenter.y+10,
                        currentCenter.x+10, currentCenter.y+10);
                g.drawLine(currentCenter.x+10, currentCenter.y+10, currentCenter.x, currentCenter.y-10);
            } else if (currentPolygon.equals("rectangle"))
                g.drawRect(currentCenter.x -20, currentCenter.y -10, 40, 20);
        }
    }//paint

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        DrawPolygons polygons = new DrawPolygons();

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBounds(30,30,300,300);
        frame.getContentPane().add(polygons);
        frame.setVisible(true);

    }//main

}//DrawPolygons