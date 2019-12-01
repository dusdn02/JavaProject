package shea.mancala;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
import javax.swing.JPanel;


/**
 * �� Ŭ������ ��� ���� �۾��� ó���Ѵ�.
 * @author Shea Bunge
 * @version 1.0
 */
@SuppressWarnings("serial")
class MancalaGame extends JPanel implements MouseListener {

	/**
	 * Board Ŭ������ �ν��Ͻ� ����
	 */
	final Board board;

	/**
	 * �����̿� �ִ� ���� ���� �����Ѵ�.
	 */
	private int[] pitStones = new int[] { 4, 4, 4, 4, 4, 4, 0, 4, 4, 4, 4, 4, 4, 0 };

	/**
	 * �� ������ ���� �� ���� ���� �ִ�.
	 * 1 �Ǵ� 2 �̿��� ������ �� ����
	 */
	private int currentPlayer = 1;

	/**
	 * ������ �¸��� ������ ����
	 *
	 * ��ȿ�� ��:
	 * -1 = ������ ������� ����
	 * 0 = �������� ����� ����
	 * 1 = ���� 1��
	 * 2 = ���� 2��
	 */
	private int winningPlayer = -1;

	/**
	 * Initialize the class
	 */
	public MancalaGame() {
		board = new Board(this, Color.blue, Color.red);

		setBorder(BorderFactory.createLineBorder(Color.black));
		addMouseListener(this);
	}

	/**
	 * â ũ�⸦ ������ ũ��� ����
	 * ��Į�� ���� ũ�� ��ȯ
	 */
	@Override
	public Dimension getPreferredSize() {
		return board.getSize();
	}

	/**
	 * ���� ȸ���� �ִ� �÷��̾� �˻�
	 * @���� �÷��̾� ��ȣ ��ȯ
	 * @throws ��Ÿ���÷��̾ ��ȿ�� ��ȣ�� ���� ��� ����
	 */
	public int getCurrentPlayer() throws RuntimeException {
		if ( currentPlayer != 1 && currentPlayer != 2 ) {
			throw new RuntimeException("currentPlayer must be either 1 or 2");
		}

		return currentPlayer;
	}

	/**
	 * ���� ȸ���� �ִ� *not* �÷��̾� �˻�
	 * @�ٸ� �÷��̾� ��ȣ ��ȯ
	 */
	public int getOtherPlayer() {
		return currentPlayer == 1 ? 2 : 1;
	}

	/**
	 * ������ ���̸� �����̸� ������ ���� ���ʸ� ���Ѵ�.
	 * @param Fit ����ڰ� ������ Pet
	 * ����� �� ���� ����
	 */
	protected boolean moveStones(final int pit) {
		int pointer = pit;

		// �����̿� ���� ������ ���ƿ���.
		if ( pitStones[pit] < 1 ) {
			return true;
		}

		// �����̿��� ���� ������
		int stones = pitStones[pit];
		pitStones[pit] = 0;

		while ( stones > 0 ) {
			++pointer;

			// �ٸ� �÷��̾��� ���� ��Ʈ�� �ǳʶٰ� �����͸� �缳���Ͻʽÿ�.
			if (pointer == 13) {
				pointer = 0;
			} else {
				pitStones[pointer]++;
				stones--;
			}

			repaint();
		}

		// �ݴ��� �����̸� ����Ű��
		int inversePointer = -pointer + 12;

		// ĸó Ȯ��
		if (pointer < 6 && pitStones[pointer] == 1 && pitStones[inversePointer] > 0) {

			// �� ���� �ݴ��� �������� ���� �Բ� �Ű� �����Ͻʽÿ�.
			pitStones[6] += pitStones[inversePointer] + 1;

			// �����̸� ġ���
			pitStones[pointer] = 0;
			pitStones[inversePointer] = 0;
		}

		// ���� ���� �����̿��� ����Ǹ� true�� ���ư���.
		return pointer == 6;
	}

	/**
	 * Begin the other player's turn
	 */
	public void switchTurn() {

		// Ȱ�� �÷��̾� ����
		currentPlayer = getOtherPlayer();

		// ��Ʈ ��ġ ������
		int[] newStones = new int[14];
		System.arraycopy(pitStones, 7, newStones, 0, 7);
		System.arraycopy(pitStones, 0, newStones, 7, 7);

		pitStones = newStones;
		repaint();
	}

	/**
	 * �����̿� ���� �׸���.
	 * @param g ������ �׷��� ��ü
	 */
	protected void drawStones(Graphics g) {
		int cx, cy; // �߰� �߽� ����

		for (int pit = 0; pit < pitStones.length; ++pit) {
			if (pit == 6 || pit == 13) {
				cx = -3;
				cy = 0;
			} else if (pit > 9) {
				cx = 3;
				cy = 6;
			} else {
				cx = 7;
				cy = 9;
			}

			g.drawString( Integer.toString(pitStones[pit]), board.getPitCenterX(pit) + cx, board.getPitCenterY(pit) + cy );
		}
	}

	/**
	 * ���� �÷��̾ ���� �׸��� ����
	 * @param g Graphics ��ü
	 */
	protected void paintPlayerInfo(Graphics g) {

		if ( winningPlayer < 0 ) {
			g.drawString("Player " + getCurrentPlayer() + "'s turn", 20, 20);
		} else {
			if (winningPlayer == 0) {
				g.drawString("Draw!", 20, 20);
			} else {
				g.drawString("Player " + winningPlayer + " wins!", 20, 20);
			}
		}
	}

	/**
	 * ���ڿ� ���� ��ũ���� �׷���.
	 * @param g ������ �׷��� ��ü
	 */
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		g.setColor(Color.black);
		board.drawBoard(g);

		g.setColor(Color.DARK_GRAY);
		drawStones(g);

		g.setColor(Color.black);
		paintPlayerInfo(g);

	}

	/**
	 * �÷��̾ ���ӿ��� �̰���� Ȯ���϶�.
	 */
	public void checkForWin() {
		boolean topRowEmpty = true, bottomRowEmpty = true;

		// �ϴ� ���� ������ �ִ��� Ȯ���Ͻʽÿ�.
		for (int i = 0; i < 6; ++i) {
			if (pitStones[i] > 0) {
				bottomRowEmpty = false;
				break;
			}
		}

		// ��� ���� ������ �ִ��� �����Ͻʽÿ�.
		for (int i = 7; i < 13; ++i) {
			if (pitStones[i] > 0) {
				topRowEmpty = false;
				break;
			}
		}

		// ��� ���� ���� �ٿ��� ���� �����ͼ� �� ������ ���Կ� �߰��ض�.
		if (topRowEmpty || bottomRowEmpty) {
			if (topRowEmpty && ! bottomRowEmpty) {
				for (int i = 0; i < 6; ++i) {
					pitStones[6] += pitStones[i];
					pitStones[i] = 0;
				}
			} else if (! topRowEmpty && bottomRowEmpty) {
				for (int i = 7; i < 13; ++i) {
					pitStones[13] += pitStones[i];
					pitStones[i] = 0;
				}
			}

			// � ������ ���� ���� ���� ��� �ִ��� �����϶�.
			if (pitStones[6] > pitStones[13] ) {
				winningPlayer = getCurrentPlayer();
			} else if (pitStones[6] < pitStones[13]) {
				winningPlayer = getOtherPlayer();
			} else {
				// tie
				winningPlayer = 0;
			}

			removeMouseListener(this);
		}

	}

	/**
	 * ���� ���ʴ�� �ϴ�
	 * �÷��̾ ������ �����̸� @param ��
	 */
	public void doPlayerTurn(int pit) {

		// ������ ���⸦ �ϴ�
		boolean	result = moveStones(pit);

		// ������ �����̰� �ٴڳ��� �ʵ��� �ϴ�
		checkForWin();

		// ���� ���� ����Ǹ� ������ ��ü�ϴ�
		if ( ! result && winningPlayer < 0 ) {
			switchTurn();
		}
	}

	/**
	 * �÷��̾ ��Ʈ�� �����ϰ� ���� �����ϴ� �ñ� Ȯ��
	 * @param e ���콺 Ŭ�� �̺�Ʈ
	 */
	@Override
	public void mouseClicked(MouseEvent e) {
		int x, y;
		int mx = e.getX();
		int my = e.getY();

		// �� �Ʒ� �ٿ� �ִ� ��� �����̸� ��ȯ�ϴ�.
		for (int pit = 0; pit < 6; ++pit) {
			x = board.getPitX(pit);
			y = board.getPitY(pit);

			// Ŭ���� ��Ʈ ���� ���� �ִ��� Ȯ���Ͻʽÿ�.
			if ( mx > x && mx < x + board.pitWidth && my > y && my < y + board.pitHeight )  {
				doPlayerTurn(pit);
			}
		}
	}

	@Override public void mouseEntered(MouseEvent e) {}
	@Override public void mouseExited(MouseEvent e) {}
	@Override public void mousePressed(MouseEvent e) {}
	@Override public void mouseReleased(MouseEvent e) {}
}
