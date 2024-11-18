
package Jogl;
import java.awt.*;
//import java.awt.event.*;
import javax.swing.*;
import javax.media.opengl.*;

/**
 * This is a basic JOGL app. Feel free to
 * reuse this code or modify it.
 */
public class turtle extends JFrame {

    /**
     *
     */


    public static void main(String[] args) {
        final turtle app = new turtle();

        // show what we've done
/*    SwingUtilities.invokeLater (
      new Runnable() {
        public void run() {
          app.setVisible(true);
        }
      }
    );*/
    }

    public turtle() {
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
        gl.glOrtho(0.0, 800.0, 0.0, 650.0, -1.0, 1.0);

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
    public void turtle(GLAutoDrawable drawable){
        GL gl =drawable.getGL();
        // to make head
        circle(177,229,177,60,420,450,drawable);
        circle(0,0,0,10,450, 475,drawable);
        circle(0,0,0,10,390, 475,drawable);
        gl.glColor3f(150/255f,113/255f,80/255f);
        gl.glPointSize(1f);
        gl.glBegin(GL.GL_POINTS);
        for (double a = Math.toRadians(0) ;  a > Math.toRadians(-180) ; a-=Math.toRadians(1)){
            double x = (15 * (Math.cos(a))) + 420 ;
            double y = (15 * (Math.sin(a))) + 445 ;
            gl.glVertex2d(x , y);
        }
        gl.glEnd();
        // to make body
        circle(27,98,23,120,420,300,drawable);
        circle(54,202,52,115,420,300,drawable);
        circle(24,153,26,100,420,300,drawable);
        circle(24,229,76,70,420,300,drawable);
        // to make leg
        // left
        circle(128,178,127,35,290,350 ,drawable);
        circle(76 ,127,75 ,15 ,265,360 ,drawable);
        circle(128,178,127,35,310,210 ,drawable);
        circle(76 ,127,75 ,15 ,285,200 ,drawable);
        // right
        circle(128,178,127,35,550,350 ,drawable);
        circle(76 ,127,75 ,15 ,575,360 ,drawable);
        circle(128,178,127,35,530,210 ,drawable);
        circle(76 ,127,75 ,15 ,555,200 ,drawable);
        // to make tail
        gl.glColor3f(103/255f, 153/255f, 102/255f);
        gl.glBegin(GL.GL_POLYGON);
        gl.glVertex2i(400,182);
        gl.glVertex2i(440,182);
        gl.glVertex2i(420,155);
        gl.glEnd();
    }
    /**
     * Take care of drawing here.
     */
    public void display(GLAutoDrawable drawable) {
        GL gl = drawable.getGL();
        gl.glClear(GL.GL_COLOR_BUFFER_BIT);
        turtle(drawable);
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

