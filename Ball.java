import java.awt.Color;
import java.awt.Point;
import java.util.Random;

public class Ball extends Thread{
	final static int r=10; //ボールの半径
	final static int d=5; //
	int x, y; //現在のボールの座標
	int dx, dy; //ボールの方向ベクトル
	Color color; //ボールの色
	Random rand_coordination = new Random(); //ボールの方向を決める乱数
	Random rand_color = new Random(); //ボールの色を決める乱数

	public Ball(Point point) {

		//ボールの初期座標を決定
		this.x=point.x;
		this.y=point.y;

		//ボールの座標がウィンドウの外の時、エラー処理
		if(x<r) x=r;
		if(MyPanel.panel_width<x) x=MyPanel.panel_width-r;
		if(y<r) y=r;
		if(MyPanel.panel_height-r<y) y=MyPanel.panel_height-r;

		//乱数生成
		int v=rand_coordination.nextInt()%8; //ボールの動く方向を決定する配列のインデックスを決定
		if(v<0)v*=-1; //乱数が負数であれば、修正
		int color_index=rand_color.nextInt()%3; //ボールの色を決める配列のインデックスを決定
		if(color_index<0) color_index*=-1;  //乱数が負数であれば、修正

		//ボールの動く方向を決定する配列
		int vx[]= {-1,-1,-1,0,0,1,1,1};
		int vy[]= {-1,0,1,-1,1,-1,0,-1};

		//ボールの色を決める配列
		Color[] ball_color= {Color.blue, Color.cyan, Color.green, Color.lightGray};

		//速度の変化方向
		dx=vx[v];
		dy=vy[v];
		//ボールの色
		color=ball_color[color_index];

		start();
	}

	/*ボールの座標を更新する*/
	void move() {

		//ボールの座標を更新
		x+=dx*d;
		y+=dy*d;

		//ボールが壁に当たった時,ボールの進行方向を変更する
		if(x > MyPanel.panel_width-r)  dx *= -1;
		if(r > x)        dx *= -1;
		if(y > MyPanel.panel_height-r) dy *= -1;
		if(r > y)        dy *= -1;
	}

	public void run() {
		while(true) {
			move();
			try {
				Thread.sleep(MyPanel.interval);
			}catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
