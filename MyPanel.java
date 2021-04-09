import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JPanel;

public class MyPanel extends JPanel implements MouseListener{
	final static int interval=25; //待機時間
	final static int panel_width=Example.frame_width; //パネルの横幅
	final static int panel_height=Example.frame_height-20; //パネルの縦幅
	ArrayList<Ball> al = new ArrayList<Ball>(); //クリックされたボールのインタンスを格納するリスト

	public MyPanel() {
		//マウスリスナーの登録
		addMouseListener(this);

		//再描画のためのスレッドを起動
		Thread thread = new Thread(new Runnable() {
			public void run() {
				while(true) {
					try {
						repaint();
						Thread.sleep(interval);
					}catch(InterruptedException e){
						e.printStackTrace();
						break;
					}
				}
			}
		});
		thread.start();
	}

	//過去にクリックされたボールを全て表示
	public void paint(Graphics g) {
		super.paint(g);
		for(Ball b : al) {
			g.setColor(b.color);
			g.fillOval(b.x-b.r, b.y-b.r, 2*b.r, 2*b.r);
		}
	}

	@Override
	//マウスをクリックした時、新たなボールを生成する
	public void mouseClicked(MouseEvent e) {
		Point point=e.getPoint();
		al.add(new Ball(point));
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO 自動生成されたメソッド・スタブ

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO 自動生成されたメソッド・スタブ

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO 自動生成されたメソッド・スタブ

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO 自動生成されたメソッド・スタブ

	}

}
