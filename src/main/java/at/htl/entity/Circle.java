package at.htl.entity;

import javax.persistence.*;

@NamedQueries({
        @NamedQuery(
                name = "Circle.getByName", query = "from Circle where htmlName like ?1"
        )
})
@Entity
public class Circle extends Node {

    private int xPos;
    private int yPos;
    private int radius;

    @Column(name = "STROKE_WIDTH")
    private int strokeWidth;

    private String stroke;
    @Id
    private Long id;

    public Circle(String htmlId,
                  String htmlName,
                  Facility facility,
                  String description,
                  NodeType nodeType,
                  DeviceType deviceType,
                  String htmlIconFileName,
                  String htmlIconName,
                  Node destination,
                  LineConfig destinationLineConfig,
                  int xPos,
                  int yPos,
                  int radius,
                  int strokeWidth,
                  String stroke
    ) {
        super(htmlId,
                htmlName,
                facility,
                description,
                nodeType,
                deviceType,
                htmlIconFileName,
                htmlIconName,
                destination,
                destinationLineConfig);
        this.setxPos(xPos);
        this.setyPos(yPos);
        this.setRadius(radius);
        this.setStrokeWidth(strokeWidth);
        this.setStroke(stroke);
    }

    public Circle() {

    }

    //region getter and setter


    public int getxPos() {
        return xPos;
    }

    public void setxPos(int xPos) {
        this.xPos = xPos;
    }

    public int getyPos() {
        return yPos;
    }

    public void setyPos(int yPos) {
        this.yPos = yPos;
    }

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    public int getStrokeWidth() {
        return strokeWidth;
    }

    public void setStrokeWidth(int strokeWidth) {
        this.strokeWidth = strokeWidth;
    }

    public String getStroke() {
        return stroke;
    }

    public void setStroke(String stroke) {
        this.stroke = stroke;
    }
    //endregion


    @Override
    public String toString() {
        return super.toString() + " (Circle)";
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
