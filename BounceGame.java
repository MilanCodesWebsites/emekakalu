import javax.microedition.midlet.*;
import javax.microedition.lcdui.*;

public class BounceGame extends MIDlet {
    private Display display;
    private Canvas gameCanvas;
    private int ballX, ballY, ballWidth, ballHeight;
    private int ballSpeedX, ballSpeedY;

    public BounceGame() {
        display = Display.getDisplay(this);
        gameCanvas = new GameCanvas();
        ballX = 10;
        ballY = 10;
        ballWidth = 20;
        ballHeight = 20;
        ballSpeedX = 2;
        ballSpeedY = 2;
    }

    public void startApp() {
        display.setCurrent(gameCanvas);
    }

    public void pauseApp() {
    }

    public void destroyApp(boolean unconditional) {
    }

    private class GameCanvas extends Canvas {
        public void paint(Graphics g) {
            g.setColor(0);
            g.fillRect(0, 0, getWidth(), getHeight());
            g.setColor(255);
            g.fillRect(ballX, ballY, ballWidth, ballHeight);
        }

        public void keyPressed(int keyCode) {
            if (keyCode == Canvas.KEY_LEFT) {
                ballSpeedX = -2;
            } else if (keyCode == Canvas.KEY_RIGHT) {
                ballSpeedX = 2;
            } else if (keyCode == Canvas.KEY_UP) {
                ballSpeedY = -2;
            } else if (keyCode == Canvas.KEY_DOWN) {
                ballSpeedY = 2;
            }
        }

        public void keyReleased(int keyCode) {
            if (keyCode == Canvas.KEY_LEFT || keyCode == Canvas.KEY_RIGHT) {
                ballSpeedX = 0;
            } else if (keyCode == Canvas.KEY_UP || keyCode == Canvas.KEY_DOWN) {
                ballSpeedY = 0;
            }
        }

        protected void paint(Graphics g) {
            // Clear the screen
            g.setColor(0);
            g.fillRect(0, 0, getWidth(), getHeight());

            // Draw the ball
            g.setColor(255);
            g.fillRect(ballX, ballY, ballWidth, ballHeight);

            // Move the ball
            ballX += ballSpeedX;
            ballY += ballSpeedY;

            // Check for collisions with walls
            if (ballX <= 0 || ballX >= getWidth() - ballWidth) {
                ballSpeedX = -ballSpeedX;
            }
            if (ballY <= 0 || ballY >= getHeight() - ballHeight) {
                ballSpeedY = -ballSpeedY;
            }

            // Schedule the next repaint
            repaint();
        }
    }
}