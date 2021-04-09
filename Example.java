


import javax.swing.JFrame;

public class Example extends JFrame{
	final static int frame_width=640;
	final static int frame_height=480;

	public Example() {

		// ユーザーがこのフレームの「クローズ」を開始したときに、デフォルトで実行される処理を設定
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		//fmameのサイズをwidht × height に変更
		setSize(frame_width, frame_height);

		//新しいパネルを作成
		MyPanel panel = new MyPanel();

		//プロパティを設定
		setContentPane(panel);

		//このWindowを表示にする
		setVisible(true);
	}

	public static void main(String[] args) {
		new Example();
	}

}
