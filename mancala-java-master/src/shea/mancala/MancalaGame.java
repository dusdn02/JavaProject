package shea.mancala;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
import javax.swing.JPanel;


/**
 * 이 클래스는 모든 게임 작업을 처리한다.
 * @author Shea Bunge
 * @version 1.0
 */
@SuppressWarnings("serial")
class MancalaGame extends JPanel implements MouseListener {

	/**
	 * Board 클래스의 인스턴스 보유
	 */
	final Board board;

	/**
	 * 구덩이에 있는 돌의 양을 규정한다.
	 */
	private int[] pitStones = new int[] { 4, 4, 4, 4, 4, 4, 0, 4, 4, 4, 4, 4, 4, 0 };

	/**
	 * 그 선수는 현재 한 바퀴 돌고 있다.
	 * 1 또는 2 이외의 숫자일 수 없음
	 */
	private int currentPlayer = 1;

	/**
	 * 게임의 승리와 승자의 결정
	 *
	 * 유효한 값:
	 * -1 = 게임이 종료되지 않음
	 * 0 = 동점으로 종료된 게임
	 * 1 = 선수 1원
	 * 2 = 선수 2원
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
	 * 창 크기를 보드의 크기로 설정
	 * 만칼라 보드 크기 반환
	 */
	@Override
	public Dimension getPreferredSize() {
		return board.getSize();
	}

	/**
	 * 현재 회전이 있는 플레이어 검색
	 * @현재 플레이어 번호 반환
	 * @throws 런타임플레이어에 유효한 번호가 없는 경우 예외
	 */
	public int getCurrentPlayer() throws RuntimeException {
		if ( currentPlayer != 1 && currentPlayer != 2 ) {
			throw new RuntimeException("currentPlayer must be either 1 or 2");
		}

		return currentPlayer;
	}

	/**
	 * 현재 회전이 있는 *not* 플레이어 검색
	 * @다른 플레이어 번호 반환
	 */
	public int getOtherPlayer() {
		return currentPlayer == 1 ? 2 : 1;
	}

	/**
	 * 구덩이 사이를 돌멩이를 움직여 선수 차례를 행한다.
	 * @param Fit 사용자가 선택한 Pet
	 * 사용자 턴 종료 여부
	 */
	protected boolean moveStones(final int pit) {
		int pointer = pit;

		// 구덩이에 돌이 없으면 돌아오다.
		if ( pitStones[pit] < 1 ) {
			return true;
		}

		// 구덩이에서 돌을 꺼내다
		int stones = pitStones[pit];
		pitStones[pit] = 0;

		while ( stones > 0 ) {
			++pointer;

			// 다른 플레이어의 저장 피트를 건너뛰고 포인터를 재설정하십시오.
			if (pointer == 13) {
				pointer = 0;
			} else {
				pitStones[pointer]++;
				stones--;
			}

			repaint();
		}

		// 반대편 구덩이를 가리키다
		int inversePointer = -pointer + 12;

		// 캡처 확인
		if (pointer < 6 && pitStones[pointer] == 1 && pitStones[inversePointer] > 0) {

			// 이 돌과 반대편 구덩이의 돌을 함께 옮겨 보관하십시오.
			pitStones[6] += pitStones[inversePointer] + 1;

			// 구덩이를 치우다
			pitStones[pointer] = 0;
			pitStones[inversePointer] = 0;
		}

		// 턴이 저장 구덩이에서 종료되면 true로 돌아가다.
		return pointer == 6;
	}

	/**
	 * Begin the other player's turn
	 */
	public void switchTurn() {

		// 활성 플레이어 변경
		currentPlayer = getOtherPlayer();

		// 피트 위치 역방향
		int[] newStones = new int[14];
		System.arraycopy(pitStones, 7, newStones, 0, 7);
		System.arraycopy(pitStones, 0, newStones, 7, 7);

		pitStones = newStones;
		repaint();
	}

	/**
	 * 구덩이에 돌을 그리다.
	 * @param g 프레임 그래픽 객체
	 */
	protected void drawStones(Graphics g) {
		int cx, cy; // 추가 중심 교정

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
	 * 현재 플레이어에 대한 그림판 정보
	 * @param g Graphics 객체
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
	 * 판자와 돌을 스크린에 그려라.
	 * @param g 프레임 그래픽 객체
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
	 * 플레이어가 게임에서 이겼는지 확인하라.
	 */
	public void checkForWin() {
		boolean topRowEmpty = true, bottomRowEmpty = true;

		// 하단 열에 스톤이 있는지 확인하십시오.
		for (int i = 0; i < 6; ++i) {
			if (pitStones[i] > 0) {
				bottomRowEmpty = false;
				break;
			}
		}

		// 상단 열에 스톤이 있는지 점검하십시오.
		for (int i = 7; i < 13; ++i) {
			if (pitStones[i] > 0) {
				topRowEmpty = false;
				break;
			}
		}

		// 비어 있지 않은 줄에서 돌을 가져와서 그 선수의 가게에 추가해라.
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

			// 어떤 선수가 가장 많은 돌을 들고 있는지 결정하라.
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
	 * 선수 차례대로 하다
	 * 플레이어가 선택한 구덩이를 @param 핏
	 */
	public void doPlayerTurn(int pit) {

		// 선수의 연기를 하다
		boolean	result = moveStones(pit);

		// 선수가 돌멩이가 바닥나지 않도록 하다
		checkForWin();

		// 현재 턴이 종료되면 선수를 교체하다
		if ( ! result && winningPlayer < 0 ) {
			switchTurn();
		}
	}

	/**
	 * 플레이어가 피트를 선택하고 턴을 수행하는 시기 확인
	 * @param e 마우스 클릭 이벤트
	 */
	@Override
	public void mouseClicked(MouseEvent e) {
		int x, y;
		int mx = e.getX();
		int my = e.getY();

		// 맨 아래 줄에 있는 모든 구덩이를 순환하다.
		for (int pit = 0; pit < 6; ++pit) {
			x = board.getPitX(pit);
			y = board.getPitY(pit);

			// 클릭이 피트 영역 내에 있는지 확인하십시오.
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
