

import java.awt.*;
//import java.awt.event.*;
import javax.swing.*;
import javax.media.opengl.*;

/**
 * This is a basic JOGL app. Feel free to
 * reuse this code or modify it.
 */
public class sea extends JFrame {

    /**
     *
     */


    public static void main(String[] args) {
        final sea app = new sea();

        // show what we've done
/*    SwingUtilities.invokeLater (
      new Runnable() {
        public void run() {
          app.setVisible(true);
        }
      }
    );*/
    }

    public sea() {
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
        gl.glOrtho(0.0, 800.0, 0.0, 400.0, -1.0, 1.0);

    }

    /**
     * Take care of drawing here.
     */
    public void display(GLAutoDrawable drawable) {
        GL gl = drawable.getGL();
        gl.glClear(GL.GL_COLOR_BUFFER_BIT);
        // the sea
        // to make color
        gl.glColor3f(2/255f , 102/255f ,203/255f); // RGB
        // to do a polygon
        gl.glBegin(GL.GL_POLYGON);
        // do vertex
        gl.glVertex2i(0,0);
        gl.glVertex2i(0,200);
        gl.glVertex2i(800,200);
        gl.glVertex2i(800,0);
        // must end
        gl.glEnd();
        // to sky
        gl.glColor3f(135/255f , 206/255f ,234/255f); // RGB
        gl.glBegin(GL.GL_POLYGON);
        gl.glVertex2i(0,400);
        gl.glVertex2i(800,400);
        gl.glVertex2i(800,200);
        gl.glVertex2i(0,200);
        gl.glEnd();
        // the wave
        gl.glColor3f(25/255f , 134/255f , 234/255f);
        for (int y = 0 ; y < 200 ; y+=25){
        gl.glBegin(GL.GL_LINE_STRIP);
        for (int x=0; x<800;x++)
            gl.glVertex2d(x, (Math.sin(x/30.0)*15.0)+y); // 30 is the width of the wave , 15 is the height
        gl.glEnd();
        }
        // the bottom of ship
        gl.glColor3f(153/255f , 75/255f , 26/255f);
        gl.glBegin(GL.GL_POLYGON);
        gl.glVertex2i(150,200);
        gl.glVertex2i(650,200);
        gl.glVertex2i(600,150);
        gl.glVertex2i(200,150);
        gl.glEnd();
        // the top of ship
        gl.glColor3f(204/255f , 126/255f , 51/255f);
        gl.glBegin(GL.GL_POLYGON);
        gl.glVertex2i(200,230);
        gl.glVertex2i(600,230);
        gl.glVertex2i(600,200);
        gl.glVertex2i(200,200);
        gl.glEnd();
        gl.glColor3f(102/255f,50/255f,0/255f);
        // the rectangle
        gl.glBegin(GL.GL_POLYGON);
        gl.glVertex2i(377,230);
        gl.glVertex2i(423,230);
        gl.glVertex2i(423,330);
        gl.glVertex2i(377,330);
        gl.glEnd();
        gl.glColor3f(1.0f , 1.0f ,1.0f);
        // the triangle
        gl.glBegin(GL.GL_POLYGON);
        gl.glVertex2i(400,230);
        gl.glVertex2i(580,230);
        gl.glVertex2i(400,330);
        gl.glEnd();

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

