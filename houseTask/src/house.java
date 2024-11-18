

import java.awt.*;
//import java.awt.event.*;
import javax.swing.*;
import javax.media.opengl.*;

/**
 * This is a basic JOGL app. Feel free to
 * reuse this code or modify it.
 */
public class house extends JFrame {

    /**
     *
     */


    public static void main(String[] args) {
        final house app = new house();

        // show what we've done
/*    SwingUtilities.invokeLater (
      new Runnable() {
        public void run() {
          app.setVisible(true);
        }
      }
    );*/
    }

    public house() {
        //set the JFrame title
        super("Simple JOGL Application");

        //kill the process when the JFrame is closed
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //only three JOGL lines of code ... and here they are
        GLCanvas glcanvas = new GLCanvas();
        glcanvas.addGLEventListener(new SimpleGLEventListener());

        // add the GLCanvas just like we would	 any Component
        add(glcanvas, BorderLayout.CENTER);
        setSize(500, 300);

        //center the JFrame on the screen
        centerWindow();
        setVisible(true);
    }

    public void centerWindow() {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        Dimension frameSize  = this.getSize();

        if (frameSize.width  > screenSize.width ) frameSize.width  = screenSize.width;
        if (frameSize.height > screenSize.height) frameSize.height = screenSize.height;

        this.setLocation (
                (screenSize.width  - frameSize.width ) >> 1,
                (screenSize.height - frameSize.height) >> 1
        );
    }
}

/**
 * For our purposes only two of the
 * GLEventListeners matter. Those would
 * be init() and display().
 */
class SimpleGLEventListener implements GLEventListener
{

    /**
     * Take care of initialization here.
     */
    public void init(GLAutoDrawable drawable) {
        GL gl = drawable.getGL();
        gl.glClearColor(1.0f, 1.0f, 1.0f, 1.0f);
        gl.glViewport(0, 0, 600, 300);
        gl.glMatrixMode(GL.GL_PROJECTION);
        gl.glLoadIdentity();
        gl.glOrtho(0.0, 1200.0, 0.0, 800.0, -1.0, 1.0);

    }
    // method that do circle
    public void circle (float R , float G , float B , double radius , int i , int j , GLAutoDrawable drawable){
        GL gl =drawable.getGL();
        gl.glColor3f(R/255,G/255,B/255);
        final double ONE_DEGREE = (Math.PI/180);
        final double THREE_SIXTY = 2 * Math.PI;
        double x , y ;
        gl.glBegin(GL.GL_POLYGON);
        for (double a = 0 ;  a < THREE_SIXTY ; a+=ONE_DEGREE){
            x = radius * (Math.cos(a)) + i ; // to change the x-position.
            y = radius * (Math.sin(a)) + j ; // to change the y-position.
            gl.glVertex2d(x , y);
        }
        gl.glEnd();
    }
    public void quadrilateral(float R , float G , float B ,int a1 , int a2
    ,int b1 ,int b2 ,int c1 ,int c2 ,int d1 ,int d2 , GLAutoDrawable drawable){
        GL gl = drawable.getGL();
        gl.glColor3f(R/255,G/255,B/255);
        gl.glBegin(GL.GL_POLYGON);
        gl.glVertex2i(a1 , a2);
        gl.glVertex2i(b1 , b2);
        gl.glVertex2i(c1 , c2);
        gl.glVertex2i(d1 , d2);
        gl.glEnd();
    }
    public void triangle(float R , float G , float B ,int a1 , int a2
            ,int b1 ,int b2 ,int c1 ,int c2 , GLAutoDrawable drawable){
        GL gl = drawable.getGL();
        gl.glColor3f(R/255,G/255,B/255);
        gl.glBegin(GL.GL_POLYGON);
        gl.glVertex2i(a1 , a2);
        gl.glVertex2i(b1 , b2);
        gl.glVertex2i(c1 , c2);
        gl.glEnd();
    }
    /**
     * Take care of drawing here.
     */
    public void display(GLAutoDrawable drawable) {
        GL gl = drawable.getGL();
        gl.glClear(GL.GL_COLOR_BUFFER_BIT);
        // 1200 * 800
        // backGround
        quadrilateral(34,139,34,0,0,1200,0,1200,200,0,200,drawable);
        quadrilateral(111,203,240,0,200,1200,200,1200,500,0,500,drawable);
        quadrilateral(23,193,252,0,500,1200,500,1200,800,0,800,drawable);
        // mountain 1
        triangle(111, 78, 11, 250, 200, 500, 200, 400, 600, drawable);
        triangle(255, 255, 255, 330, 450, 450, 450, 400, 600, drawable);
        // mountain 2
        triangle(111,78,11,395,200,635,200,525,600,drawable);
        triangle(255, 255, 255, 470, 450, 580, 450, 525, 600, drawable);
        // mountain 3
        triangle(111, 78, 11, 540, 200, 790, 200, 665, 600, drawable);
        triangle(255, 255, 255, 605, 450, 730, 450, 665, 600, drawable);
        // mountain 4
        triangle(111, 78, 11, 700, 200, 950, 200, 825, 600, drawable);
        triangle(255, 255, 255,765,450,890,450,825,600, drawable);
        // leak
        quadrilateral(0,154,198,150,200,1010,200,930,220,150,220,drawable);
        // tree a like d
        quadrilateral(127,75,25,100,200,125,200,125,500,100,500,drawable);
        circle(0,255,1,60,110,480,drawable);
        circle(0,255,1,60,80,530,drawable);
        circle(0,255,1,60,120,530,drawable);
        circle(0,255,1,60,110,560,drawable);
        quadrilateral(127,75,25,175,200,200,200,200,500,175,500,drawable);
        circle(0,255,1,60,190,480,drawable);
        circle(0,255,1,60,160,530,drawable);
        circle(0,255,1,60,200,530,drawable);
        circle(0,255,1,60,190,560,drawable);
        quadrilateral(127,75,25,1000,200,975,200,975,500,1000,500,drawable);
        circle(0,255,1,60,990,480,drawable);
        circle(0,255,1,60,990,560,drawable);
        circle(0,255,1,60,950,560,drawable);
        circle(0,255,1,60,950,520,drawable);
        quadrilateral(127,75,25,1100,200,1075,200,1075,500,1100,500,drawable);
        circle(0,255,1,60,1090,480,drawable);
        circle(0,255,1,60,1000,560,drawable);
        circle(0,255,1,60,1000,580,drawable);
        circle(0,255,1,60,1090,560,drawable);
        circle(0,255,1,60,1090,580,drawable);
        circle(0,255,1,60,1100,560,drawable);
        circle(0,255,1,60,1150,530,drawable);
        // house
        quadrilateral(178,126,76,500,200,700,200,700,400,500,400,drawable);
        quadrilateral(204,204,254,520,320,570,320,570,400,520,400,drawable);
        quadrilateral(204,204,254,630,320,680,320,680,400,630,400,drawable);
        quadrilateral(77,51,26,580,200,620,200,620,300,580,300,drawable);
        triangle(126,0,1,480,385,720,385,600,480,drawable);
        // wall
        quadrilateral(153,101,50,50,220,1150,220,1150,235,50,235,drawable);
        quadrilateral(153,101,50,50,250,1150,250,1150,265,50,265,drawable);
        for (int x = 40 ; x < 1150 ; x+=70){
            quadrilateral(153,101,50,x,200,(x+10),200,(x+10),280,x,280,drawable);
        }
        // grass
        for (int x = -1 ; x <=1200 ; x+=16) {
            gl.glColor3f(48 / 255f, 153 / 255f, 87 / 255f);
            gl.glBegin(GL.GL_LINE_STRIP);
            gl.glVertex2i(x, 200);
            gl.glVertex2i(x+5, 215);
            gl.glEnd();
        }
        // sun
        for (double angle = 0; angle < 360; angle += 45) {
            double radians = Math.toRadians(angle);
            gl.glColor3f(173/255f, 130/255f, 102/255f);
            gl.glBegin(GL.GL_LINES);
            gl.glVertex2d(950, 700);
            gl.glVertex2d(950 + Math.cos(radians) * 120, 700 + Math.sin(radians) * 120);
            gl.glEnd();
        }
        circle(255,255,0,75,950,700,drawable);
        circle(255,255,255,60,0,800,drawable);
        circle(255,255,255,60,100,780,drawable);
        circle(255,255,255,60,150,800,drawable);
        circle(255,255,255,60,1200,800,drawable);
        circle(255,255,255,60,1100,780,drawable);
        circle(255,255,255,60,1050,800,drawable);
    }

    /**
     * Called when the GLDrawable (GLCanvas
     * or GLJPanel) has changed in size. We
     * won't need this, but you may eventually
     * need it -- just not yet.
     */
    public void reshape(
            GLAutoDrawable drawable,
            int x,
            int y,
            int width,
            int height
    ) {}

    /**
     * If the display depth is changed while the
     * program is running this method is called.
     * Nowadays this doesn't happen much, unless
     * a programmer has his program do it.
     */
    public void displayChanged(
            GLAutoDrawable drawable,
            boolean modeChanged,
            boolean deviceChanged
    ) {}

    public void dispose(GLAutoDrawable arg0) {
        // TODO Auto-generated method stub

    }
}

