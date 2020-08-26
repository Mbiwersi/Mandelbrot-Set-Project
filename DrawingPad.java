//Class was provided by instructor
//

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Polygon;
import javax.swing.JFrame;
import javax.swing.JComponent;
import java.text.AttributedCharacterIterator;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;
import java.util.function.Consumer;

/**
 * Simplified access class for a Swing-based drawing pad.
 */
public class DrawingPad extends JFrame {
  private final int width, height;
  private final ArrayList<Consumer<Graphics>> tasks = new ArrayList<>();
  private final Color baseColor;

  /**
   * Create a drawing pad of a certain size, with black as its base
   * color.
   * @width width of the drawing pad
   * @height height of the drawing pad
   */
  public DrawingPad(int width, int height) {
    this(width, height, Color.black);
  }

  /**
   * Create a drawing pad of a certain size and default component
   * color.
   * @width width of the drawing pad
   * @height height of the drawing pad
   * @baseColor Default color for drawing components
   */
  public DrawingPad(int width, int height, Color baseColor) {
    this.width = width;
    this.height = height;
    this.baseColor = baseColor;
    setTitle("Drawing pad");
    setSize(width, height);
    setLayout(null);
    getContentPane().setBackground(Color.white);
    setResizable(false);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setMinimumSize(new Dimension(width, height));
    pack();
    setVisible(true);
  }

  /**
   * Draws a line, using the base color, between the points (x1,
   * y1) and (x2, y2) in this graphics context's coordinate system.
   */
  public void drawLine(int x1, int y1, int x2, int y2) {
    add(graphics -> graphics.drawLine(x1, y1, x2, y2));
  }

  /**
   * Draws a line, using the base color, between the points (x1,
   * y1) and (x2, y2) in this graphics context's coordinate system.
   */
  public void drawLine(Color color, int x1, int y1, int x2, int y2) {
    add(color, graphics -> graphics.drawLine(x1, y1, x2, y2));
  }

  /**
   * Draws the outline of an oval in the base color.
   */
  public void drawOval(int x, int y, int width, int height) {
    add(graphics -> graphics.drawOval(x, y, width, height));
  }

  /**
   * Draws the outline of an oval in the base color.
   */
  public void drawOval(Color color, int x, int y, int width, int height) {
    add(color, graphics -> graphics.drawOval(x, y, width, height));
  }

  /**
   * Draws a closed polygon defined by arrays of x and y
   * coordinates in the base color.
   */
  public void drawPolygon(int[] xPoints, int[] yPoints, int nPoints) {
    add(graphics -> graphics.drawPolygon(xPoints, yPoints, nPoints));
  }

  /**
   * Draws a closed polygon defined by arrays of x and y
   * coordinates in the base color.
   */
  public void drawPolygon(Color color, int[] xPoints, int[] yPoints, int nPoints) {
    add(color, graphics -> graphics.drawPolygon(xPoints, yPoints, nPoints));
  }

  /**
   * Draws the outline of a polygon defined by the specified Polygon
   * object in the base color.
   */
  public void drawPolygon(Polygon p) {
    add(graphics -> graphics.drawPolygon(p));
  }

  /**
   * Draws the outline of a polygon defined by the specified Polygon
   * object in the base color.
   */
  public void drawPolygon(Color color, Polygon p) {
    add(color, graphics -> graphics.drawPolygon(p));
  }

  /**
   * Draws a sequence of connected lines defined by arrays of x and y
   * coordinates in the base color.
   */
  public void drawPolyline(int[] xPoints, int[] yPoints, int nPoints) {
    add(graphics -> graphics.drawPolyline(xPoints, yPoints, nPoints));
  }

  /**
   * Draws a sequence of connected lines defined by arrays of x and y
   * coordinates in the base color.
   */
  public void drawPolyline(Color color, int[] xPoints, int[] yPoints, int nPoints) {
    add(color, graphics -> graphics.drawPolyline(xPoints, yPoints, nPoints));
  }

  /**
   * Draws the outline of the specified rectangle in the base color.
   */
  public void drawRect(int x, int y, int width, int height) {
    add(graphics -> graphics.drawRect(x, y, width, height));
  }

  /**
   * Draws the outline of the specified rectangle in the base color.
   */
  public void drawRect(Color color, int x, int y, int width, int height) {
    add(color, graphics -> graphics.drawRect(x, y, width, height));
  }

  /**
   * Draws an outlined round-cornered rectangle in the base color.
   */
  public void drawRoundRect(int x, int y, int width, int height,
                            int arcWidth, int arcHeight) {
    add(graphics -> graphics.drawRoundRect(x, y, width, height,
                                           arcWidth, arcHeight));
  }

  /**
   * Draws an outlined round-cornered rectangle in the base color.
   */
  public void drawRoundRect(Color color, int x, int y, int width, int height,
                            int arcWidth, int arcHeight) {
    add(color, graphics -> graphics.drawRoundRect(x, y, width, height,
                                           arcWidth, arcHeight));
  }

  /**
   * Renders the text of the specified iterator applying its
   * attributes in accordance with the specification of the
   * TextAttribute class in the base color.
   */
  public void drawString(AttributedCharacterIterator iterator, int x, int y) {
    add(graphics -> graphics.drawString(iterator, x, y));
  }

  /**
   * Renders the text of the specified iterator applying its
   * attributes in accordance with the specification of the
   * TextAttribute class in the base color.
   */
  public void drawString(Color color, AttributedCharacterIterator iterator, int x, int y) {
    add(color, graphics -> graphics.drawString(iterator, x, y));
  }

  /**
   * Draws the text given by the specified string, using this graphics
   * context's current font and the DrawingPad's base color.
   */
  public void drawString(String str, int x, int y) {
    add(graphics -> {
        graphics.drawString(str, x, y);
      });
  }

  /**
   * Draws the text given by the specified string, using this graphics
   * context's current font and the DrawingPad's base color.
   */
  public void drawString(Color color, String str, int x, int y) {
    add(color, graphics -> {
        graphics.drawString(str, x, y);
      });
  }

  /**
   * Paints a 3-D highlighted rectangle filled with the base
   * color.
   */
  public void fill3DRect (int x, int y,
                          int width, int height, boolean raised) {
    add(graphics -> graphics.fill3DRect(x, y, width, height, raised));
  }

  /**
   * Paints a 3-D highlighted rectangle filled with the base
   * color.
   */
  public void fill3DRect (Color color, int x, int y,
                          int width, int height, boolean raised) {
    add(color, graphics -> graphics.fill3DRect(x, y, width, height, raised));
  }

  /**
   * Fills a circular or elliptical arc covering the specified
   * rectangle in the base color.
   */
  public void fillArc(int x, int y, int width, int height,
                      int startAngle, int arcAngle) {
    add(graphics -> graphics.fillArc(x, y, width, height,
                                     startAngle, arcAngle));
  }

  /**
   * Fills a circular or elliptical arc covering the specified
   * rectangle in the base color.
   */
  public void fillArc(Color color, int x, int y, int width, int height,
                      int startAngle, int arcAngle) {
    add(color, graphics -> graphics.fillArc(x, y, width, height,
                                     startAngle, arcAngle));
  }

  /**
   * Fills an oval bounded by the specified rectangle with the base
   * color.
   */
  public void fillOval(int x, int y, int width, int height) {
    add(graphics -> graphics.fillOval(x, y, width, height));
  }

  /**
   * Fills an oval bounded by the specified rectangle with the base
   * color.
   */
  public void fillOval(Color color, int x, int y, int width, int height) {
    add(color, graphics -> graphics.fillOval(x, y, width, height));
  }

  /**
   * Fills a closed polygon defined by arrays of x and y
   * coordinates in the base color.
   */
  public void fillPolygon(int[] xPoints, int[] yPoints, int nPoints) {
    add(graphics -> graphics.fillPolygon(xPoints, yPoints, nPoints));
  }

  /**
   * Fills a closed polygon defined by arrays of x and y
   * coordinates in the base color.
   */
  public void fillPolygon(Color color, int[] xPoints, int[] yPoints, int nPoints) {
    add(color, graphics -> graphics.fillPolygon(xPoints, yPoints, nPoints));
  }

  /**
   * Fills the polygon defined by the specified Polygon object with
   * the base color.
   */
  public void fillPolygon(Polygon p) {
    add(graphics -> graphics.fillPolygon(p));
  }

  /**
   * Fills the polygon defined by the specified Polygon object with
   * the base color.
   */
  public void fillPolygon(Color color, Polygon p) {
    add(color, graphics -> graphics.fillPolygon(p));
  }

  /**
   * Fills the specified rectangle in the base color.
   */
  public void fillRect(int x, int y, int width, int height) {
    add(graphics -> graphics.fillRect(x, y, width, height));
  }

  /**
   * Fills the specified rectangle in the base color.
   */
  public void fillRect(Color color, int x, int y, int width, int height) {
    add(color, graphics -> graphics.fillRect(x, y, width, height));
  }

  /**
   * Fills the specified rounded corner rectangle with the base
   * color.
   */
  public void fillRoundRect(int x, int y, int width, int height,
                            int arcWidth, int arcHeight) {
    add(graphics -> graphics.fillRoundRect(x, y, width, height,
                                           arcWidth, arcHeight));
  }

  /**
   * Fills the specified rounded corner rectangle with the base
   * color.
   */
  public void fillRoundRect(Color color, int x, int y, int width, int height,
                            int arcWidth, int arcHeight) {
    add(color, graphics -> graphics.fillRoundRect(x, y, width, height,
                                           arcWidth, arcHeight));
  }

  // =================================================================
  // Internal routines

  protected void add(Color color, Consumer<Graphics> task) {
    final JComponent c = new JComponent() {
        @Override public void paint(Graphics g) {
          g.setColor(color);
          task.accept(g);
          paintChildren(g);
        }
      };
    c.setVisible(true);
    c.setSize(width, height);
    add(c, 0);
    repaint();
  }

  protected void add(Consumer<Graphics> task) {
    add(baseColor, task);
  }

  // =================================================================
  // An example main routine


}
